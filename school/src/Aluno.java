import java.io.*;
import java.util.*;

//classe responsavel pela criação do aluno
public class Aluno{
    private Manager data = new Manager();
    private int numero = 1;
    private static ArrayList<Integer> list_number = new ArrayList<Integer>();// Lista responsável por guardar os números dos alunos
    private Curso c = new Curso();
    private Professor p = new Professor();

    public Aluno() {}

    public Aluno(String name, String loc, int age) {
        int opc = 0;

        Manager data = new Manager();
        while(data.search("data_aluno.txt","  Número: " + String.valueOf(numero)) != "") {
           numero++;
        }

        // Open and Write data in file:
        // Faz a gravação na String do nome do aluno associado ao número do aluno e ao
        // número do curso:
        String[] str = new String[3];
        str[0] = "Nome: " + name + "  Idade: " + age + "  Localização: " + loc + "  Número: " + numero + ";\n";
        // **********************************************

        // Pede ao utilizador para escolher o código do curso que o aluno escolheu:
        while (c.search(opc) == 0) {
            System.out.println("Por favor indique o curso que o aluno frequentar:");
            data.read("data_curso.txt");
            System.out.println("Escreva o código do curso que pretende selecionar");
            opc = Ler.umShort();
            // Verifica no ficheiro data_curso se o código digitado está associado a algum
            // curso
            if (c.search(opc) != 1) {
                System.out.println("Valor introduzido não válido.😞\nPor favor tente novamente:\n");
            }
        }
        // ************************************************************************************

        // Open and Write data in file:
        // Faz a gravação na String do nome do aluno associado ao número do aluno e ao
        // número do curso:
        str[1] = "Número: " + numero + "  Nome do aluno: " + name + "  Número do curso: " + opc + "\n";
        // **********************************************

        int curso = opc;

        // Pede ao utilizador para escolher o código do professor para o aluno:
        while (p.search(opc) == 0) {
            System.out.println("Por favor indique o professor para atribuir ao aluno:");
            p.read(Integer.toString(curso));
            System.out.println("Escreva o código do professor que pretende selecionar");
            opc = Ler.umShort();
            // Verifica no ficheiro data_curso se o código digitado está associado a algum
            // curso
            if (p.search(opc) != 1) {
                System.out.println("Valor introduzido não válido.😞\nPor favor tente novamente:\n");
            }
        }
        // ************************************************************************************

        // Open and Write data in file:
        // Faz a gravação na String do nome do aluno associado ao número do aluno e ao
        // número do professor:
        str[2] = "Número: " + numero + "  Número do professor: " + opc + "\n";
        // **********************************************

        //Gravação dos dados no ficheiros:
        //Ele só faz a gravação no final quando o usuário preencher todos os campos necessários:
        data.write("data_aluno.txt", str[0], true);
        data.write("data_ac.txt", str[1], true);
        data.write("data_ap.txt", str[2], true);
        //**************************************************************** */
    }

    // Função responsável por apagar um aluno:
    // Recebe uma String x -> número do aluno:
    // Recebe uma string y -> nome do ficheiro:
    public void del(String x, String y) {
        data.del(y, x);
    }

    //Função responsável por alterar os dados dos alunos
    //Recebe o novo nome do aluno e o número desse aluno
    public void change(String name, String num, String file, String split1, String split2) {
        // Faz um cópia de todo o ficheiro para o ArrayList<String> dat
        // Ele faz slips para remover o nome antigo desse aluno e adiciona o novo nome do aluno a lista
        ArrayList<String> dat = new ArrayList<String>();
        try {
            FileReader filename = new FileReader(file);
            BufferedReader br = new BufferedReader(filename);
            String texto;

            while ((texto = br.readLine()) != null) {
                if (texto.contains(num) == false) {
                    dat.add(texto + "\n");
                } else {
                    //Em str[0] fica guardado -> "Nome :"
                    //Em str[1] fica guardado -> age + "Localização: " + loc + "  Número: " + num + "\n"
                    String[] str;
                    str = texto.split(split1);
                    String aux = str[1];
                    String aux0 = str[0];
                    str = aux.split(split2);
                    //É adicionado a lista um aluno com todos os dados do aluna antigo mas o novo dado alterado:
                    switch (split1){
                        case "Nome: ":
                            dat.add("Nome: " + name + "  Idade:" + str[1] + "\n");
                            break;
                        case "Idade: ":
                            dat.add(aux0 + "Idade: " + name + "  Localização:" + str[1] + "\n");
                            break;
                        case "Localização: ":
                            dat.add(aux0 + "Localização: " + name + "  Número:" + str[1] + "\n");
                            break;
                    }
                }
            }

        } catch (IOException erro) {
            System.out.println("###### Erro: " + erro.getMessage());
            erro.printStackTrace();
        }
        // *********************************************************************************

        // Copiamos o ArrayList<String> data para a String name_new, mas retiramos os, (, [
        // ]), do ArrayList<String> data
        String name_new = String.join("", dat);
        data.write("data_aluno.txt", name_new, false);
        // **********************************************
    }
}