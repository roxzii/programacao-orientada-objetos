
import java.io.*;
import java.util.*;

//classe responsavel pela criação do professor
public class Professor{
    private Manager data = new Manager();
    private int numero = 1;
    private Curso c = new Curso();

    public Professor() {}

    public Professor(String name) {
        short opc = 0;
       
        Manager data =new Manager();
        while(data.search("data_prof.txt","  Número: " + String.valueOf(numero)) != "") {
           numero++;
        }

        // Open and Write data file:
        // Faz a gravação no ficheiro o nome do professor e o número do professor:
        String str = "Nome: " + name + "  Número: " + numero + ";\n";
        data.write("data_prof.txt", str, true);
        // **********************************************

        // Pede ao utilizador para escolher o código do curso que o store vai lecionar:
        while (c.search(opc) == 0) {
            System.out.println("Por favor indique o curso que o professor vai Lecionar:");
            data.read("data_curso.txt");
            ;
            System.out.println("Escreva o código do curso que o professor vai lecionar");
            opc = Ler.umShort();
            // Verifica no ficheiro data_curso se o código digitado está associado a algum
            // curso
            if (c.search(opc) != 1) {
                System.out.println("Valor introduzido não válido.😞\nPor favor tente novamente:\n");
            }
        }
        // ************************************************************************************

        // Open and Write data in file:
        // Faz a gravação no ficheiro do número do professore associado ao número do
        // curso:
        str = "Número: " + numero + "  Nome do prof:" + name + "  Número do curso: " + opc + ";\n";
        data.write("data.txt", str, true);
        // **********************************************
    }

    // Função responsável por apagar um professor:
    // Recebe uma String x -> número do professor:
    // Recebe uma string y -> nome do ficheiro:
    public void del(String x, String y) {
        data.del(y, x);
    }

    // Função responsável por mostra ao utilizador os professor.
    // Se a função receber uma String vazia ela mostra a lista completa de
    // professores.
    // Se a função receber uma String com um número do curso ela mostra os
    // professores que lecionam esse curso:
    public void read(String x) {
        try {
            FileReader filename1 = new FileReader("data_prof.txt");
            FileReader filename2 = new FileReader("data.txt");
            BufferedReader br1 = new BufferedReader(filename1);
            BufferedReader br2 = new BufferedReader(filename2);
            String texto1;
            String texto2;

            // ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
            while ((texto1 = br1.readLine()) != null) {
                texto2 = br2.readLine();
                if (texto2.contains("Número do curso: " + x)) {
                    System.out.println(texto1);
                }
            }
        } catch (IOException erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }
    }

    // Verifica que um dado elemento está no ficheiro data_prof se tiver ele
    // devolver 1
    // Se não tiver no ficheiro ele devolve 0:
    public int search(int x) {
        try {
            FileReader filename = new FileReader("data_prof.txt");
            BufferedReader br = new BufferedReader(filename);
            String texto;

            // ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
            while ((texto = br.readLine()) != null) {
                if (texto.contains(" " + Integer.toString(x) + ";") == true) {
                    return 1;
                }
            }
        } catch (IOException erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }
        return 0;
    }

    // Função responsável por fazer a alteração do nome do professor:
    // number -> número do professor que se pretende alterar o nome.
    // name -> novo nome do professor
    public void change(String number, String name) {
        // Faz um cópia de todo o ficheiro para o ArrayList<String> dat
        // Ele faz slips para remover o nome antigo desse professor e adiciona o novo
        // nome do professor a lista
        ArrayList<String> dat = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("data_prof.txt"));
            String texto;

            while ((texto = br.readLine()) != null) {
                if (texto.contains(number)) {
                    String[] str;
                    str = texto.split("Número: ");
                    dat.add("Nome: " + name + "  Número: " + str[1] + "\n");
                } else {
                    dat.add(texto + "\n");
                }
            }
        } catch (Exception erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }

        // Copiamos o ArrayList<String> data para a String name_new, mas retiramos os, (, [
        // ]), do ArrayList<String> data
        String name_new = String.join("", dat);
        data.write("data_prof.txt", name_new, false);
        // **********************************************
    }
}