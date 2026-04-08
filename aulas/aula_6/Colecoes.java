// Data: 01/04/2026

// import java.util.Stack;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Colecoes {

    public static void main(String[] args) {
        // Stack<Integer> pilha = new Stack<>();
        // pilha.push(15);
        // pilha.push(45);
        // pilha.push(100);
        // pilha.push(5);

        // System.out.println(pilha);
        // pilha.pop(); // comando somente de pilha, serve para remover o último adicionado

        // System.out.println(pilha.contains(5)); //vai mostrar false
        // System.out.println("Topo da pilha é: " + pilha.peek());

        // Exemplo simples para List (no mesmo estilo)
        List<Integer> lista = new ArrayList<>();
        lista.add(15);
        lista.add(45);
        lista.add(100);
        lista.add(5);
        lista.sort(null);

        // System.out.println(lista);
        lista.remove((Integer) 100);
        System.out.println(lista.contains(100));
        lista.remove(lista.size() - 1); // remove o último adicionado

        System.out.println(lista.contains(5)); // vai mostrar false
        System.out.println("Último da lista é: " + lista.get(lista.size() - 1));

        //percorrer a lista

        for (int i = 0; i < lista.size(); i++) { //usar quando trabalhar com índice, bom para exibir e localizar
            System.out.println(lista.get(i));
        }


        // percorrer via objeto
        // também não serve para alterar a lista
        // irá se perder
        for (Integer i : lista) {
            System.out.println(i);
        }

        // percorrer por um iterador/iterar é repetir
        // iterador sabe percorrer a lista
        Iterator<Integer> i = lista.iterator(); // bom para alterações de tamanho na lista em tempo de execução,adicionar/ remover
        while (i.hasNext()) {
            System.out.println(i.next());
            
        }

        


        Queue<Integer> fila = new LinkedList<>(); // precisamos da lista encadeada para imprementar uma fila
        fila.add(15);
        fila.add(45);
        fila.add(100);
        fila.add(5);
        // fila.sort(null); transformaria a fila em uma lista praticamente
        System.out.println(fila);

        fila.remove(); // remove o primeiro a entrar na fila, ordem de chegada
        System.out.println(fila.contains(15)); //não vai conter
        System.out.println(fila.peek());
        
        // Fila é para prioridade






    }
    
}
