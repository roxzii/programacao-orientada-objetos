import java.util.ArrayList;

public class exame {
    private int cc;
    private String nome;
    private ArrayList<String> contactos;
    private int[] telefones;

    public exame(String nome, int cc){
        this.nome = nome;
        this.cc = cc;
        contactos = new ArrayList<>();
        telefones = new int[2];
        for (int i = 0; i < 2; i++){
            telefones[0] = 0;
        }
    }

    //Métodos sets e gets:
    public int getCC(){
        return cc;
    }
    public String getNome(){
        return nome;
    }
    public ArrayList<String> getConcactos(){
        return contactos;
    }
    public int[] getTelefones(){
        return telefones;
    }
    public void setCC(int cc){
        this.cc = cc;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setConcactos(ArrayList<String> concactos){
        this.contactos = concactos;
    }
    public void setTelefones(int[] telefones){
        this.telefones = telefones;
    }

    public boolean equals(Object a){
        if (a != null & this.getClass() == a.getClass()){
            return true;
        }else{
            return false;
        }
    }

    public boolean ValidarContactos(String x){
        return contactos.contains(x);
    }

    public boolean ValidarTelefones(int t){
        for(int i = 0; i < 2; i ++){
            if(telefones[i] == t){
                return true;
            }
        }
        return false;
    }

    public Object clone(){
        exame copia = new exame(this.nome, this.cc);
        return copia;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < 2; i++){
            str = telefones[i] + " | " + str;
        }
        return "CC = " + cc + " Nome = " + nome + " Concactos = " + contactos + " Telefone = " + str;
    }
}
