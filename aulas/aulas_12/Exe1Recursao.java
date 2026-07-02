//EXERCÍCIOS POR RECURSÃO:
// 1 Receba uma lista, seu tamanho, valor de pesquisa. 
// Caso o valor de pesquisa ocorra na lista, retornar quantas vezes ela aparece

import java.util.ArrayList;
import java.util.Random;

class Exe1Recursao {

    public static void popular(ArrayList<Integer> lista, int quantidade) {

        Random gerador = new Random();

        for (int i = 0; i < quantidade; i++) {

            lista.add(gerador.nextInt(30));
        }
    }

    public static void exibir(ArrayList<Integer> lista) {

        for (int i = 0; i < lista.size(); i++) {

            System.out.println(lista.get(i));
        }
    }

    public static int contarRecursao(ArrayList<Integer> lista, int n, int valor) {

        if (n > 0) {

            if (lista.get(n - 1) == valor) {

                return 1 + contarRecursao(lista, n - 1, valor);

            } else {

                return contarRecursao(lista, n - 1, valor);
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<Integer>();

        int quantidade = 10;

        popular(lista, quantidade);

        exibir(lista);

        int valorPesquisa = 10;

        System.out.println("O valor 10 aparece "+ contarRecursao(lista, lista.size(), valorPesquisa)+ " vezes.");
    }
}