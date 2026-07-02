//RECURSÃO - É um recurso computacional de programação que substitui as instruções de repetição (for while)
  //  toda repetição obedece a 3 pontos:
    //   A - inicialização da variável de controle
    //   B - teste de parada com a variável de controle
    //   C - transformação da variável de controle

import java.util.ArrayList;
import java.util.Random;

class Recursao {
    public static void popular (ArrayList<Integer> lista, int quantidade){
        Random gerador = new Random();
        int numero;
        for (int i = 0; i<quantidade; i++){
            numero = gerador.nextInt(bound: 100);
            lista.add (numero);
        }
    }

    public static void exibir (ArrayList<Integer> lista) {
        for (int i=0; i< lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }

    public static void exibirR (ArrayList<Integer> lista, int n){
        if (n > 0){
            // codigo antes do empilhamento
            exibirR(lista, n - 1);
            // codigo depois do empilhamento
        }
    }

    public static void main (String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        int quantidade = 5;
        popular(lista, quantidade);
        //exibir(lista);
        exibirR(lista, lista.size());
        system.out.println ("a SOMA DOS ELEMENTOS DA LISTA É: "+somarR (lista, lista.size()));
        system.out.println ("A quantidade de pares na lista é: "+contarParesR(lista, lista.size()));
    }
}


                            //EXERCÍCIOS POR RECURSÃO:
// 1 Receba uma lista, seu tamanho, valor de pesquisa. 
// Caso o valor de pesquisa ocorra na lista, retornar quantas vezes ela aparece

// 2) Receba uma lista seu tamanho, valor de pesquisa, valor de substituição. Caso o valor
// ocorra na lista, substituir o valor de pesquisa pelo valor de substituição

// 3) Receba uma lista, seu tamanho e retorne TRUE se a lista é ordenada, FALSE se a lista
//desordenada

// 4) Receba uma lista e seu tamanho. O método deve exibir todos os números múltiplos de 4