import java.io.*;
import java.util.*;
import java.util.Calendar;


//classe responsavel pela criação do curso
public class Curso{
    private int numero = 1;
    Manager dat = new Manager();

    Curso(){}
    
    Curso(String name, String hora, String calendario){
        
        Manager data =new Manager();
        while(data.search("data_curso.txt","  Número: " + String.valueOf(numero)) != ""){
           numero++;
        }
        
        //Open and Write data in the file:
        //Faz a gravação no ficheiro do nome, curso e número do curso:
        String str = "Nome: " + name + " Horário: " + hora + " Carga semanal: " + horarioSemanal(hora) + "  Calendário: " + calendario + "  Número: " + numero + ";\n";
        dat.write("data_curso.txt", str, true);
    }

    //Responsável por apagar um Curso:
    //Recebe um x -> número do curso
    public void delcurso2(String x){
       dat.del("data_curso.txt", x);
    }

    //Verifica que um dado elemento está no ficheiro data_curso se tiver ele devolver 1, se não tiver no ficheiro ele devolve 0:
    public int search(int x){
        try {
            FileReader filename = new FileReader("data_curso.txt");
            BufferedReader br = new BufferedReader(filename);
            String texto;

            //ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
            while ((texto = br.readLine()) != null) {
                if(texto.contains(" " + Integer.toString(x) + ";") == true){
                    return 1;
                }
            }
            
        } catch (IOException erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }
        return 0;
    }

    public int horarioSemanal(String hora){
        int inicio, fim, semanal;
        String[] str;
        str = hora.split("-");
        
        inicio = Integer.parseInt(str[0]);
        fim = Integer.parseInt(str[1]);
        semanal = (fim - inicio)*5;
        return semanal;
    }
    
    //verifica se o curso esta a decorrer na data presente
    public void calendario(){
        try{
            FileReader filename = new FileReader("data_curso.txt");
            BufferedReader br = new BufferedReader(filename);
            String texto;
            while((texto = br.readLine()) != null){
                System.out.println(texto);
                String[] str, str1, ns;
                ns = texto.split("  Calendário: ");
                String aux;
                aux = ns[1];
                ns = aux.split(" ");
                aux = ns[0];
                str = aux.split("/");
                aux = str[2];
                str1 = aux.split("-");
                int day1, day2, mes1, mes2, year1, year2;

                day1 = Integer.parseInt(str[0]);
                mes1 = Integer.parseInt(str[1]);
                year1 = Integer.parseInt(str1[0]);
                day2 = Integer.parseInt(str1[1]);
                mes2 = Integer.parseInt(str[3]);
                year2 = Integer.parseInt(str[4]);
                
                //linhas de codigo que vão buscar as informações ao calendário local
                Calendar cal = Calendar.getInstance ();
                cal.get(Calendar.YEAR);
                cal.get(Calendar.MONTH);
                cal.get(Calendar.DAY_OF_MONTH);
                
                //Condiçoes para verificar se p curso está ativo na data presente
                if(cal.get(Calendar.YEAR) > year1 && cal.get(Calendar.YEAR) < year2){
                    System.out.println("O curso está a decorrer.");                 
                }
                else{
                    if(cal.get(Calendar.YEAR) == year1){
                        if(cal.get(Calendar.MONTH) >= mes1){
                            if(cal.get(Calendar.DAY_OF_MONTH) >= day1){
                                System.out.println("O curso está a decorrer.");
                            }
                            else{
                                System.out.println("Não está a decorrer.");
                            }
                        }
                        else{
                            System.out.println("Não está a decorrer."); 
                        }
                    }
                    else{
                        if(cal.get(Calendar.YEAR) == year2){
                            if(cal.get(Calendar.MONTH) <= mes2){
                                System.out.println("Estou aqui");
                                if(cal.get(Calendar.DAY_OF_MONTH) <= day2){
                                    System.out.println("Ocurso está a decorrer.");
                                }
                                else{
                                    System.out.println("Não está a decorrer.");
                                } 
                            }
                            else{
                                System.out.println("Não está a decorrer."); 
                           }
                        }
                        else{
                            System.out.println("Não está a decorrer.");
                       }
                    }
                }        
            } 
        }
        catch(Exception erro){
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }
    }
}