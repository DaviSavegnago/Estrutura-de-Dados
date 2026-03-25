import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Glicemia> lista = new ArrayList<>();

        //alternativa 1 (colocando em uma variavel temporaria e depois add na lista)
        Glicemia obj = new Glicemia(191,"11/03/2026","8:00");
        lista.add( obj );

        //alternativa 2 (colocando direto na lista)
        lista.add(new Glicemia(191,"11/03/2026","8:00"));

        //alternativa 3

        int valor;
        String data, hora;
        for(int i = 0; i < 3; i++)
        {
            System.out.println("Valor glicemia: ");
            valor = teclado.nextInt();
            teclado.nextLine();

            System.out.println("Data [dd/mm/aaa]: ");
            data = teclado.nextLine();

            System.out.println("Hora [hh:mm]: ");
            hora = teclado.nextLine();

            lista.add(new Glicemia(valor,data,hora));
        }

        //exibir a lista
        for(int i = 0; i < lista.size(); i++)
        {
            System.out.println(lista.get(i).valor+"-"+lista.get(i).data+"-"+lista.get(i).hora);
        }
    }
}
