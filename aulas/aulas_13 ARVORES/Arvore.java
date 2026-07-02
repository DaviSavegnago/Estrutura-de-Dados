import java.util.TreeSet;

public class Arvore{

    public static void main (String[] args){

        TreeSet<String> arvore = new TreeSet<>();
        arvore.add ("Banana");
        arvore.add ("Macã");
        arvore.add ("Laranja");
        arvore.add ("Abacaxi");
        arvore.add ("Uva");
        arvore.add ("Uva");
        arvore.add ("Manga");

        System.out.println("Elementos da TreeSet: "); //PERCURSO ERD
        for (String fruta : arvore) {
            System.out.println(fruta);
        }

        if (arvore.contains("Caqui")){ //PERCURSO RED
            System.out.println("\nA TreeSet contém Caqui.");
        } else {
            System.out.println("\nA TreeSet não contém Caqui");
        }

        arvore.clear(); //PERCURSO EDR
        System.out.println("\nTamanho da TreeSet após limpar: " + arvore.size());

    }

}