import java.io.*;
import java.util.*;


//Classe responsável pelo gerenciamento dos ficheiros
public class Manager{

    //Função responsável por verificar o número de linhas de um ficheiro. Ela recebe um argumento file.
    //file -> nome do ficheiro que é para contar as linhas
    public int FileLine(String file){
        int line = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while(reader.readLine() != null){
                line++;
            }
            reader.close();
            return line;
        } catch (Exception erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }
        return line;
    }

    // Função responsável por fazer a procura do elemento nos ficheiros. Ela recebe dois elementos como argumentos:
    // file -> nome do ficheiro onde procurar;
    // name -> a palavra que é suposto encontrar.
    // No fim ela returna no formato de uma String str todas as linhas do ficheiro que contém aquela palavra.
    public String search(String file, String name) {
        // Faz um cópia de todos os elemento do ficheiro que têm a palavra que procuramos
        ArrayList<String> data = new ArrayList<String>();
        try {
            FileReader filename = new FileReader(file);
            BufferedReader br = new BufferedReader(filename);
            String texto;

            // ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
            while ((texto = br.readLine()) != null) {
                if (texto.contains(name) == true) {
                    data.add(texto + "\n");
                }
            }
        } catch (IOException erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }

        // Copiamos o ArrayList<String> data para a String str, mas retiramos os, (, [
        // ]), do ArrayList<String> data
        String str = String.join("", data);
        return str;
    }

    // Função responsável por fazer a procura do elemento nos ficheiros. Ela recebe dois elementos como argumentos:
    // file -> nome do ficheiro onde procurar;
    // name -> a palavra que é suposto encontrar.
    // No fim ela TRUE se o elemento estiver no ficheiro ou FALSE se não tiver.
    public boolean search_boolean(String file, String name) {
        try {
            FileReader filename = new FileReader(file);
            BufferedReader br = new BufferedReader(filename);
            String texto;

            // ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
            while ((texto = br.readLine()) != null) {
                if (texto.contains(name) == true) {
                    return true;
                }
            }
        } catch (IOException erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }

        return false;
    }

    // Função responsável por mostrar ao utilizador o menu de procura. Ela recebe 3
    // argumentos:
    // file -> nome do ficheiro onde é suposto fazer a procura dos dados;
    // clas -> de qual classe o utilizador pretende procurar.
    public void searchMenu(String file, String clas) {
        short opc = 0;
        String name;
        //Validação do input:
        //************************************************************************** */
        while (opc != 1 & opc != 2) {
            System.out.println("\nComo pretende fazer a procura pelo " + clas + " ?");
            System.out.println("1-> Pelo nome");
            System.out.println("2-> Pelo número");
            opc = Ler.umShort();
            if(opc != 1 & opc != 2){
                System.err.println("❌Valor digitado inválido.❌\nPor favor tente novamente.");
            }
        }
        //************************************************************************** */
        if (opc == 1) {
            System.out.println("Indique o nome do " + clas + " por qual quer procurar:");
            name = Ler.umaString();
            System.out.println(search(file, name));
            System.out.println("Prima ENTER para continuar:");
            name = Ler.umaString();
        } else {
            System.out.println("Indique o número do " + clas + " por qual quer procurar:");
            name = Ler.umaString();
            System.out.println(search(file, name));
            System.out.println("Prima ENTER para continuar:");
            name = Ler.umaString();
        }
    }

    // Função responsável por fazer a leitura de um ficheiro:
    // file -> nome do ficheiro a ser lido.
    // Ela ler esse ficheiro até ao fim dele.
    public void read(String file) {
        try {
            FileReader filename = new FileReader(file);
            BufferedReader br = new BufferedReader(filename);
            String texto;

            // ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
            while ((texto = br.readLine()) != null) {
                System.out.println(texto);
            }

        } catch (IOException erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }
    }

    //Função responsável por juntar os dados do aluno com os dados dos cursos
    //Essa função ler o ficheiro data_ac.txt para encontrar a relação entre o número do aluno e o número do curso
    //E depois procura no ficheiro data_curso.txt os dados do curso e imprimir juntamente com os dados do aluno.
    public void readcurso(){
        try {
            FileReader file_aluno = new FileReader("data_aluno.txt");
            FileReader file_ac = new FileReader("data_ac.txt");
            BufferedReader br_aluno = new BufferedReader(file_aluno);
            BufferedReader br_ac = new BufferedReader(file_ac);
            String aluno;
            String[] number_curso;
            String curso;

            // ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
            while ((aluno = br_aluno.readLine()) != null) {
                System.out.println("*************************\n" + aluno + "\nCurso:");
                number_curso = br_ac.readLine().split("Número do curso: ");

                FileReader file_curso = new FileReader("data_curso.txt");
                BufferedReader br_curso = new BufferedReader(file_curso);
                while((curso = br_curso.readLine()) != null){
                    if(curso.contains(number_curso[1])){
                        System.out.println(curso);
                    }
                }                
            }

        } catch (IOException erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }
    }

    //Função responsável por juntar os dados do aluno com os dados dos professores
    //Essa função ler o ficheiro data_ap.txt para encontrar a relação entre o número do aluno e o número do professor
    //E depois procura no ficheiro data_prof.txt os dados do professor e imprimir juntamente com os dados do aluno.
    public void readprof(){
        try {
            FileReader file_aluno = new FileReader("data_aluno.txt");
            FileReader file_ap = new FileReader("data_ap.txt");
            BufferedReader br_aluno = new BufferedReader(file_aluno);
            BufferedReader br_ap = new BufferedReader(file_ap);
            String aluno;
            String[] number_prof;
            String curso;

            // ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
            while ((aluno = br_aluno.readLine()) != null) {
                System.out.println("*************************\n" + aluno + "\nProfessore:");
                number_prof = br_ap.readLine().split("Número do professor: ");

                FileReader file_prof = new FileReader("data_prof.txt");
                BufferedReader br_prof = new BufferedReader(file_prof);
                while((curso = br_prof.readLine()) != null){
                    if(curso.contains(number_prof[1])){
                        System.out.println(curso);
                    }
                }                
            }

        } catch (IOException erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }
    }

    //Função responsável por juntar os dados do aluno com os dados dos professores e com os dados do curso
    //Essa função ler o ficheiro data_ap.txt para encontrar a relação entre o número do aluno e o número do professor
    //Essa função ler o ficheiro data_ac.txt para encontrar a relação entre o número do aluno e o número do curso
    //E depois procura nos ficheiros data_prof.txt e data_curso.txt os dados do professor e do curso
    //Finalmente imprimir esse dados juntamente com os dados do aluno.
    public void readAll(){
        try {
            FileReader file_aluno = new FileReader("data_aluno.txt");
            FileReader file_ap = new FileReader("data_ap.txt");
            FileReader file_ac = new FileReader("data_ac.txt");
            BufferedReader br_aluno = new BufferedReader(file_aluno);
            BufferedReader br_ap = new BufferedReader(file_ap);
            BufferedReader br_ac = new BufferedReader(file_ac);
            String aluno;
            String[] number_prof;
            String[] number_curso;
            String texto;

            // ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
            while ((aluno = br_aluno.readLine()) != null) {
                System.out.println("*************************\n" + aluno + "\n-> Professore:");
                number_prof = br_ap.readLine().split("Número do professor: ");
                number_curso = br_ac.readLine().split("Número do curso: ");

                FileReader file_prof = new FileReader("data_prof.txt");
                BufferedReader br_prof = new BufferedReader(file_prof);
                while((texto = br_prof.readLine()) != null){
                    if(texto.contains(number_prof[1])){
                        System.out.println(texto);
                    }
                }
                
                System.out.println("-> Cursos:");
                FileReader file_curso = new FileReader("data_curso.txt");
                BufferedReader br_curso = new BufferedReader(file_curso);
                while((texto = br_curso.readLine()) != null){
                    if(texto.contains(number_curso[1])){
                        System.out.println(texto);
                    }
                }
            }

        } catch (IOException erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }
    }
    
    public void estatistica(){  
        int maior = -999999;
        String curso = "";
        try {
            FileReader file = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(file);
            String texto;

            while((texto = br.readLine()) != null){
                int count = 0;
                String[] aux = texto.split("Número do curso: ");
                String[] number = aux[1].split(";");
                FileReader f = new FileReader("data_ac.txt");
                BufferedReader r = new BufferedReader(f);
                String str;
                while((str = r.readLine()) != null){
                    if(str.contains("Número do curso: " + number[0])){
                        count++;
                        if(count > maior ){
                            maior = count;
                            curso = number[0];
                        }
                    }
                }
            }

            file = new FileReader("data_curso.txt");
            br = new BufferedReader(file);
            
            while((texto = br.readLine()) != null){
                if(texto.contains("Número: " + curso + ";")){
                    System.out.println("O curso com o maior número de alunos é:");
                    System.out.println(texto);
                }
            }

        } catch (Exception erro) {
            System.out.println("An error occurred.");
            erro.printStackTrace();
        }

        System.out.println("\nNúmero total de alunos registados na escola:" + FileLine("data_aluno.txt"));
        
        //função que diz o numero total de cursos
        try{
            FileReader file = new FileReader("data_curso.txt");
            BufferedReader br = new BufferedReader(file);
            String texto;
            int num = 0;
            while((texto = br.readLine()) != null){
                num++;
            }
            System.out.println("\nNúmero total de cursos:" + FileLine("data_curso.txt"));
        }
        catch(Exception erro){
            System.out.println("An error occurred.");
            erro.printStackTrace();
        }
        
        //função que diz o número total de professores
        try{
            FileReader file = new FileReader("data_prof.txt");
            BufferedReader br = new BufferedReader(file);
            String texto;
            int num = 0;
            while((texto = br.readLine()) != null){
                num++;
            }
            System.out.println("\nNúmero total de professores:" + FileLine("data_prof.txt"));
        }
        catch(Exception erro){
            System.out.println("An error occurred.");
            erro.printStackTrace();
        }
    }

    //Método para criar os ficheiros txt vazios na inicialização do programa
    public void File(){
        File a = new File("data_prof.txt");
        File b = new File("data_curso.txt");
        File c = new File("data_ap.txt");
        File d = new File("data_ac.txt");
        File e = new File("data_aluno.txt");
        File f = new File("data.txt");
        try {
            a.createNewFile();
            b.createNewFile();
            c.createNewFile();
            d.createNewFile();
            e.createNewFile();
            f.createNewFile();
        } catch (Exception erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }
    }

    //Esta função é responsável por escrever num ficheiro uma mensagem
    //file -> nome do ficheiro
    //message -> mensagem a ser escrita no ficheiro
    //x = true -> mantem os dados do ficheiro e apenas adiciona mais
    //x = false -> apaga todos os dados do ficheiro e escreve os novos dados por cima
    public void write(String file, String message, Boolean x){
        try {
            BufferedWriter write = new BufferedWriter(new FileWriter(file, x));
            write.write(message);
            write.close();
        } catch (Exception erro) {
            System.out.println("An error occurred.");
            erro.printStackTrace();
        }
    }

    //Esta função é responsável por apagar dados em ficheiros
    //file -> nome do ficheiro onde é para apagar os dados
    //delete -> dados que devem ser apagados
    public void del(String file, String delete){
        //Faz um cópia de todo o ficheiro para o ArrayList<String> dat exceto o Curso que queremos apagar:
        ArrayList<String> dat = new ArrayList<String>();
        try {
            BufferedReader del = new BufferedReader(new FileReader(file));
            String texto;
            
            //ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
            while ((texto = del.readLine()) != null) {
                if(texto.contains("Número: " + delete) == false){
                    dat.add(texto + "\n");
                }
            }
            
        } catch (IOException erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }
        String str = String.join("", dat);
        write(file, str, false);
    }
}