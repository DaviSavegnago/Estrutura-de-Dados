import java.util.TreeSet;

public class Convocacao{

    public static void main (String[] args){

            TreeSet<String> convocados = new TreeSet<>();
            convocados.add ("Alisson");
            convocados.add ("Ederson");
            convocados.add ("Weverton");
            convocados.add ("Danilo");
            convocados.add ("Wesley");
            convocados.add ("Ibañez");
            convocados.add ("Marquinhos");
            convocados.add ("Gabriel Magalhães");
            convocados.add ("Léo Pereira");
            convocados.add ("Bremer");
            convocados.add ("Alex Sandro");
            convocados.add ("Douglas Santos");
            convocados.add ("Casemiro");
            convocados.add ("Danilo Santos");
            convocados.add ("Bruno Guimarães");
            convocados.add ("Fabinho");
            convocados.add ("Paquetá");
            convocados.add ("Rayan");
            convocados.add ("Luiz Henrique");
            convocados.add ("Martinelli");
            convocados.add ("Vini Jr");
            convocados.add ("Neymar Jr");
            convocados.add ("Matheus Cunha");
            convocados.add ("Endrick");
            convocados.add ("Igor Thiago");



            System.out.println("Jogadores da Convocacao: "); //PERCURSO ERD
            for (String jogador : convocados) {
                System.out.println(jogador);
            }

            if (convocados.contains("Neymar Jr")){ //PERCURSO RED
                System.out.println("\nComemora torcedor, Neymar esta na copa.");
            } else {
                    System.out.println("\nO Brasil perdeu um torcedor");
                }

            convocados.clear(); //PERCURSO EDR
            System.out.println("\nTamanho da convocacao após limpar: " + convocados.size());
            
    }

}