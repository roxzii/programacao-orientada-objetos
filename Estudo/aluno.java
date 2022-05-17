import java.lang.reflect.Array;
import java.util.ArrayList;

public class aluno {
    private String escola;
    private exame p1;

    public aluno(exame p1, String escola){
        this.escola = escola;
        this.p1 = p1;
    }

    public void plus(String x){
        ArrayList<String> aux = new ArrayList<>();
        aux.add(x);
        aux.add(String.valueOf(p1.getConcactos()));
        p1.setConcactos(aux);
    }
}
