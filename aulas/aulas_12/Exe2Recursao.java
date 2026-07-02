// 2) Receba uma lista seu tamanho, valor de pesquisa, valor de substituição. Caso o valor
// ocorra na lista, substituir o valor de pesquisa pelo valor de substituição

import java.util.ArrayList;
import java.util.Random;

class Exe2Recursao {

    public static void popular(ArrayList<Integer> lista, int quantidade) {
        Random gerador = new Random();

        for (int i = 0; i < quantidade; i++) {
            lista.add(gerador.nextInt(20));
        }
    }

    public static void exibir(ArrayList<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    public static void substituirRecursao(ArrayList<Integer> lista, int n, int valorPesquisa, int valorSubstituicao) {
        
        if (n == 0) {
            return;
        }

        if (lista.get(n - 1) == valorPesquisa) {
            lista.set(n - 1, valorSubstituicao);
        }

        substituirRecursao(lista, n - 1, valorPesquisa, valorSubstituicao);
    }

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<Integer>();

        int quantidade = 10;

        popular(lista, quantidade);

        exibir(lista);

        int valorPesquisa = 10;
        int valorSubstituicao = 88;

        substituirRecursao(
            lista,
            lista.size(),
            valorPesquisa,
            valorSubstituicao
        );

        System.out.println("Lista após substituição:");

        exibir(lista);
    }
}