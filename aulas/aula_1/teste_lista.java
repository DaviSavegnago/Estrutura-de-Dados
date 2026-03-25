import java.util.ArrayList;
import java.util.Scanner;

public class teste_lista
{
    public static void main(String[] args)
    {
        ArrayList<String> listaNome = new ArrayList<>();

        listaNome.add("Gabriel");

        System.out.println(listaNome);

        if(!listaNome.isEmpty())
        {
            Scanner teclado = new Scanner(System.in);

            System.out.print("Digite um nome: ");
            String nome = teclado.nextLine();

            if(listaNome.contains(nome))
            {
                listaNome.remove(nome);
            }
            else
            {
                System.out.println("Nome não está na lista");
            }

            System.out.println(listaNome);
            teclado.close();
        }
        else
        {
            System.out.println("Lista vazia");
        }
    }
}