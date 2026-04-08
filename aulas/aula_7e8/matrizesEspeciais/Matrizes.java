package MatrizesEspeciais;

import java.util.List;

public class Matrizes {
    /**
     * método de classe que inicializa com zeros a matriz
     * @param m - matriz original de inteiro que sera inicializada com zeros
     * @param qtdLinhas - quantidade de linhas da matriz
     * @param qtdColunas - quantidade de colunas da matriz
     */
    public static void inicializarMatrizInteira(int m[][], int qtdLinhas, int qtdColunas) {
        for (int lin = 0; lin < qtdLinhas; lin++) {
            for (int col = 0; col < qtdColunas; col++) {
                m[lin][col] = 0;
            }
        }

    }

    /**
     * 
     * @param m - matriz original que será exibida
     * @param qtdLinhas - quantidade de linhas da matriz
     * @param qtdColunas - quantidade de colunas da matriz
     */
    public static void exibirMatriz(int m[][], int qtdLinhas, int qtdColunas) {
        for (int lin = 0; lin < qtdLinhas; lin++) {
            for (int col = 0; col < qtdColunas; col++) {
                System.out.printf(m[lin][col] + "\t");
            }
        }
    }

    /**
     * método de classe que recebe uma matriz com muitor valores nulos e a converte para uma lista de matrizes especiais
     * @param m - matriz com valores nulos ou sua maioria
     * @param qtdLinhas - 
     * @param qtdColunas -
     * @param lista - lista que armazena os valores não nulos da matriz
     */
    public static void converter(int m[][], int qtdLinhas, int qtdColunas, List<Dado> lista) {
        for (int lin = 0; lin < qtdLinhas; lin++) {
            for (int col = 0; col < qtdColunas; col++) {
                if (m[lin][col] != 0) {
                    lista.add(new Dado(m[lin][col], lin, col));

                }
            }
        }
    }

        /**
        * método de classe que exibe o conteúdo de uma lista de tipo Dado
        * @param lista - contem os dados
         */
    public static void exibirLista(List<Dado> lista) {
    for (Dado item : lista) {
        System.out.println(item);
    }
    System.out.println("Total de elementos não nulos: " + lista.size());
    
    }
    
}
