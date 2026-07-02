import java.util.ArrayList;

public class Recursao {

    //A - Inicialização da variável de controle
    //B - Teste de Parada
    //C - Transformação da Variável de Controle 

    static void mostrarSequencia(int numero){
        for (int i=0; i <= 0; i++){
            System.out.println(i);
        }
    }

    static void mostrarSequenciaDecrescente (int numero){
        for (; numero >= 0; numero --){
            System.out.println(numero);
        }
    }

    static void mostrarSequenciaDecrescenteRecursao (int numero){
        if (numero >= 0){
            System.out.println(numero);
            mostrarSequenciaDecrescenteRecursao(numero - 1); //ponto de recursão
        }
    }

    static void mostrarSequenciaCrescenteRecursao (int numero){
        if (numero >= 0){
            //System.out.println(numero);
            mostrarSequenciaCrescenteRecursao(numero - 1); //ponto de recursão
            System.out.println(numero);
        }
    }

    static void mostrarIntervalo (int ini, int fim){
        for (; ini <= fim; ini++){
            System.out.println(ini);
        }
    }

    static void mostarIntervaloRecursao (int ini, int fim){
        if (ini <= fim){
            System.out.println(ini);
            mostarIntervaloRecursao(ini + 1, fim);
        }
    }

    static void mostrarLista(ArrayList<Integer> lista){
        for (int i=0; i < lista.size(); i++){
        System.out.println(lista.get(i));
        }
        // for (integer i : lista) {
        //     System.out.println(i);
        // }
    }

    static void mostrarListaRecursão (ArrayList<Integer> lista, int n){
        if (n > 0){
            System.out.println(lista.get(n - 1));
            mostrarListaRecursão(lista, n-1);
            //System.out.println(lista.get(n - 1));
        }
    }

    static void mostrarParesListaRecursão (ArrayList<Integer> lista, int n){
        if (n > 0){
            mostrarParesListaRecursão(lista, n-1);
            if (lista.get(n-1) % 2 == 0){
                System.out.println(lista.get(n-1));
            }
        }
    }

    static void substituirRecursao (ArrayList<Integer> lista, int n, int alvo, int novoValor){
        if (n > 0) {
            if (lista.get(n - 1) == alvo) {
                lista.set(n - 1, novoValor);
            }
            substituirRecursao(lista, n - 1, alvo, novoValor);
            }
    }

    public static void main (String[] args){

        int numero = 5;

        //mostrarSequencia(numero); //mostrar a sequencia de 0 até número
        //mostrarSequenciaDecrescente(numero); //seq decrescente
        //mostrarSequenciaDecrescenteRecursao(numero);
        //mostrarSequenciaCrescenteRecursao(numero);

        //mostrarIntervalo(3, 6);
        //mostarIntervaloRecursao (3, 6);

        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(25);
        lista.add(30);
        lista.add(40);

        //mostrarLista(lista);
        //mostrarListaRecursão(lista, lista.size());
        //mostrarParesListaRecursão(lista, lista.size());
        substituirRecursao (lista, lista.size(), 30, 100);
         System.out.println("Lista após substituir 30 por 100: " + lista);

    }

   }