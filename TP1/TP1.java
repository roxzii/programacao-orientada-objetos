//Tratar dos ficherios binarios
//Adicionar cenas á esatistica
import java.io.*;
import java.util.*;

public class TP1{
    public static void main(String[] args) {
        Manager data = new Manager(); // Classe responsável por gerir parte dos ficheiros
        short x = 0; // Variável dedicada a escolha de opções do utilizador no Menu principal.
        short opc = 0; // Variável dedicada a escolha de opções do utilizador nos Menu secundários.
        String aux;
        data.File();

        while (x != 17) {
            for (int i = 0; i < 50; i++) {
                System.out.println("");
            }
            System.out.println("🐉        MENU        🐉");
            System.out.println("1-> Adicionar um novo Aluno");
            System.out.println("2-> Listar Alunos");
            System.out.println("3-> Procurar Aluno");
            System.out.println("4-> Remover um aluno");
            System.out.println("5-> Alterar dados dos alunos");
            System.out.println("<---------------------------------->");
            System.out.println("6-> Adicionar um Professor");
            System.out.println("7-> Listar Professores");
            System.out.println("8-> Procurar Professores");
            System.out.println("9-> Remover um Professor");
            System.out.println("10-> Alterar o nome do professor");
            System.out.println("<---------------------------------->");
            System.out.println("11-> Adicionar um curso");
            System.out.println("12-> Listar cursos");
            System.out.println("13-> Procurar curso");
            System.out.println("14-> Remover um curso");
            System.out.println("15-> Calendário dos cursos");
            System.out.println("<---------------------------------->");
            System.out.println("16-> Estatisticas");
            System.out.println("<---------------------------------->");
            System.out.println("17-> Sair");
            x = Ler.umShort();

            switch (x) {
                case 1:
                    String name, loc, hora, calendario;
                    if (data.FileLine("data_prof.txt") != 0) {
                        int age;
                        System.out.println("Indique o nome do Aluno:");
                        name = Ler.umaString();
                        System.out.println("Indique a localidade do Aluno:");
                        loc = Ler.umaString();
                        System.out.println("Indique a idade do Aluno:");
                        age = Ler.umInt();
                        Aluno a = new Aluno(name, loc, age);
                    } else {
                        System.out.println(
                                "❌❌Ainda não existem professores.❌❌\nPor favor adicione primeiro os professores.");
                        System.out.println("Prima ENTER para continuar:");
                        name = Ler.umaString();
                    }
                    break;
                case 2:
                    opc = 25;
                    String xx = " ", xxx = " ";
                    while (opc != 3) {
                        // Limpar a tela:
                        // ********************************** */
                        for (int i = 0; i < 50; i++) {
                            System.out.println("");
                        }
                        // ********************************** */
                        System.out.println();
                        System.out.println("Escolha que informações pretende aparecer na lista:");
                        System.out.println("0-> [x] Mostra dados sobre o aluno");
                        System.out.println("1-> [" + xx + "] Mostra dados sobre o professor");
                        System.out.println("2-> [" + xxx + "] Mostra dados sobre o curso");
                        System.out.println("Digite 3 para mostra os dados pedidos:");
                        opc = Ler.umShort();

                        // Alterar a check box do Menu
                        // 1º check box:
                        if (opc == 1) {
                            if (xx == " ") {
                                xx = "x";
                            } else {
                                xx = " ";
                            }
                        }
                        // 2º check box:
                        if (opc == 2) {
                            if (xxx == " ") {
                                xxx = "x";
                            } else {
                                xxx = " ";
                            }
                        }
                        // ************************************* */
                    }
                    System.out.println("\n👤        ALUNOS         👤");
                    if (xxx != "x" & xx != "x") {
                        data.read("data_aluno.txt");
                    }
                    if (xxx == "x" & xx != "x") {
                        data.readcurso();
                    }
                    if (xx == "x" & xxx != "x") {
                        data.readprof();
                    }
                    if (xx == "x" & xxx == "x") {
                        data.readAll();
                    }
                    // data.read("data_aluno.txt");
                    System.out.println("Prima ENTER para continuar:");
                    aux = Ler.umaString();
                    break;
                case 3:
                    data.searchMenu("data_aluno.txt", "aluno");
                    break;
                case 4:
                    Aluno a2 = new Aluno();
                    String delete;
                    data.read("data_aluno.txt");
                    System.out.println("Indique o número do Aluno que quer eliminar:");
                    delete = Ler.umaString();
                    a2.del(delete, "data_aluno.txt");
                    a2.del(delete, "data_ac.txt");
                    a2.del(delete, "data_ap.txt");
                    break;
                case 5:
                    opc = 0;
                    Aluno a = new Aluno();

                    for (int i = 0; i < 50; i++) {
                        System.out.println("");
                    }

                    // Verifica se existe alunos:
                    if (data.FileLine("data_aluno.txt") != 0) {
                        // Validação do opção escolhida pelo utilizador:
                        while (opc > 3 | opc < 1) {
                            System.out.println("Indique qual dado do aluno pretende alterar:");
                            System.out.println("1-> Nome do aluno");
                            System.out.println("2-> Idade do aluno");
                            System.out.println("3-> Localização do aluno");
                            opc = Ler.umShort();
                        }
                        // ***************************************************** */

                        // Seleção do aluno que se pretende alterar os dados, essa seleção é feita
                        // utilizado o número do aluno:
                        String num = "dsadasda";
                        // Verificação se o número digitado pelo utilizador existe no ficheiro
                        // "data_aluno.txt":
                        while (data.search_boolean("data_aluno.txt", ("Número: " + num + ";")) == false) {
                            data.read("data_aluno.txt");
                            System.out.println("Indique o número do aluno:");
                            num = Ler.umaString();
                        }
                        // ******************************************************* */
                        // ************************************************************************ */

                        switch (opc) {
                            case 1:
                                System.out.println("Indique o novo nome do aluno:");
                                name = Ler.umaString();
                                a.change(name, num, "data_aluno.txt", "Nome: ", "  Idade:");
                                break;
                            case 2:
                                System.out.println("Indique a nova idade do aluno:");
                                name = Ler.umaString();
                                a.change(name, num, "data_aluno.txt", "Idade: ", "  Localização:");
                                break;
                            case 3:
                                System.out.println("Indique a nova localização do aluno:");
                                name = Ler.umaString();
                                a.change(name, num, "data_aluno.txt", "Localização: ", "  Número:");
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("❌❌Ainda não existem alunos.❌❌\nPor favor adicione primeiro um aluno.");
                        System.out.println("Prima ENTER para continuar:");
                        name = Ler.umaString();
                    }
                    // ************************************************ */
                    break;
                case 6:
                    if (data.FileLine("data_curso.txt") != 0) {
                        System.out.println("Indique o nome do novo professor:");
                        name = Ler.umaString();
                        Professor p = new Professor(name);
                    } else {
                        System.out.println("❌❌Ainda não existem cursos.❌❌\nPor favor adicione primeiro os cursos.");
                        System.out.println("Prima ENTER para continuar:");
                        name = Ler.umaString();
                    }
                    break;
                case 7:
                    Professor p1 = new Professor();
                    System.out.println("\n📖        PROFESSORES         📖");
                    p1.read("");
                    System.out.println("Prima ENTER para continuar:");
                    aux = Ler.umaString();
                    break;
                case 8:
                    data.searchMenu("data_prof.txt", "professore");
                    break;
                case 9:
                    Professor p2 = new Professor();
                    p2.read("");
                    System.out.println("Indique o número do Professor que quer apagar:");
                    delete = Ler.umaString();
                    p2.del(delete, "data_prof.txt");
                    p2.del(delete, "data.txt");
                    break;
                case 10:
                    Professor p = new Professor();
                    opc = -9;

                    // Verifica se existem professor no sistema:
                    if (data.FileLine("data_prof.txt") != 0) {
                        // Validação do número do professor:
                        while (p.search(opc) == 0) {
                            for (int i = 0; i < 50; i++) {
                                System.out.println("");
                            }
                            p.read("");
                            System.out.println("Indique o número do Professor que quer alterar o nome:");
                            opc = Ler.umShort();
                        }
                        // ***************************************************** */
                        System.out.println("Indique o nome nome do professor:");
                        name = Ler.umaString();
                        p.change(String.valueOf(opc), name);
                    } else {
                        System.out.println(
                                "❌❌Ainda não existem professores.❌❌\nPor favor adicione primeiro um professor.");
                        System.out.println("Prima ENTER para continuar:");
                        name = Ler.umaString();
                    }
                    //************************************************************* */
                    break;
                case 11:
                    System.out.println("Indique o nome do Novo curso:");
                    name = Ler.umaString();
                    System.out.println("Indique o horário do curso:");
                    hora = Ler.umaString();
                    System.out.println("Indique o Calendário anual do curso:");
                    calendario = Ler.umaString();
                    Curso c = new Curso(name, hora, calendario);       
                    break;
                case 12:
                    Curso c1 = new Curso();
                    System.out.println("\n📝        CURSOS          📝");
                    data.read("data_curso.txt");
                    System.out.println("Prima ENTER para continuar:");
                    aux = Ler.umaString();
                    break;
                case 13:
                    data.searchMenu("data_curso.txt", "curso");
                    break;
                case 14:
                    Curso c2 = new Curso();
                    data.read("data_curso.txt");
                    ;
                    System.out.println("Indique o número do curso que pretende apagar:");
                    delete = Ler.umaString();
                    c2.delcurso2(delete);
                    break;
                case 15:
                    Curso c4 = new Curso();
                    System.out.println("\n📝        CURSOS          📝");
                    c4.calendario();
                    System.out.println("Prima ENTER para continuar:");
                    aux = Ler.umaString();
                    break;
                case 16:
                    for (int i = 0; i < 50; i++){
                        System.out.println("");
                    }
                    data.estatistica();
                    System.out.println("Clique no ENTER para continuar.");
                    aux = Ler.umaString();
                    break;
                case 17:
                    System.out.println("Saindo ....");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
