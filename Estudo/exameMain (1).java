import java.util.ArrayList;

public class exameMain {
    static ArrayList<exame> plus = new ArrayList<>();

    public static void adiciona(exame p1, ArrayList<exame> plus){
        if(plus.contains(p1)){
            System.out.println("A pessoa já existe");
        }else{
            System.out.println("Pessoa adiciona com sucesso");
            plus.add(p1);
        }
    }

    public static void main(String[] args){
        exame p1 = new exame("Maria", 12345);
        exame p2 = new exame("Ana", 20263);
        exame p3 = (exame)p1.clone();
        exame p4 = p1;
        //System.out.println("P4:" + "\n" + p4);
        p1.setNome("Novo nome");
        ArrayList<String> conta = new ArrayList<>();
        conta.add("amigo1@gmail.com");
        conta.add("amigo2@gmail.com");
        p1.setConcactos(conta);
        int[] tele = new int[2];
        tele[0] = 1111;
        tele[1] = 2222;
        p1.setTelefones(tele);
        //System.out.println("P1:" + "\n" + p1);
        //System.out.println("P3:" + "\n" + p3);
        aluno a1 = new aluno(p1, "Amadoura");
        System.out.println(p1);
        a1.plus("jomiguelsa1238@mgial.com");
        System.out.println(p1);
    }
}
