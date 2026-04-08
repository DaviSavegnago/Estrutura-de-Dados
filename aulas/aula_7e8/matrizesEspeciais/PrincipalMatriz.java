package MatrizesEspeciais;
import java.util.List;
import java.util.ArrayList;

public class PrincipalMatriz {
    public static void main(String[] args) {
        int dimensao = 10;
        int matriz[][] = new int[dimensao][dimensao];
                                        // passamos o endereço da matriz original, da referencia //recebemos apenas o
                                        // endereço
        Matrizes.inicializarMatrizInteira(matriz, dimensao, dimensao);
        
        matriz[0][3] = 1;
        matriz[1][1] = 1;
        matriz[2][4] = 1;
        matriz[5][7] = 1;
        matriz[7][9] = 1;
        matriz[8][8] = 1;
                                
        Matrizes.exibirMatriz(matriz, dimensao, dimensao);

        List<Dado> matrizEspecial = new ArrayList<>();
        Matrizes.converter(matriz, dimensao, dimensao, matrizEspecial);
        Matrizes.exibirLista(matrizEspecial);

    }
    
}
