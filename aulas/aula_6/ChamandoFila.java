import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ChamandoFila {
    public static void main(String[] args) {
        Queue<Integer> filaNormal = new LinkedList<>();
        Queue<Integer> filaPrioritaria = new LinkedList<>();

        int contarNormal = 0;
        int contaPrioritaria = 0;
        int totalAtendimentos = 0;

        Scanner teclado = new Scanner(System.in);
        String opcao; // preparação de um tratamento de erros, melhor receber em string e converter do que esperar um int e receber uma string que fará o programa crashar
        String qualFila;
        do {
            System.out.println("MENU");
            System.out.println("1 - Ficha normal");
            System.out.println("2 - Ficha prioritária");
            System.out.println("3 - Chama ficha");
            System.out.println("4 - Mostra fichas");
            System.out.println("5 - Sair do Sistema");

            opcao = teclado.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Gerando ficha normal: " + (contarNormal+1));
                    filaNormal.offer(contarNormal);
                    contarNormal++;
                    break;

                case "2":
                    System.out.println("Gerando ficha prioritária: " + (contaPrioritaria+1) );
                    filaPrioritaria.offer(contaPrioritaria);
                    contaPrioritaria++;
                    break;

                case "3":
                    int fichaAtendida = -1;
                    if (totalAtendimentos % 3 == 0) { // a cada 3 chamadas normal chama uma prioritária
                        qualFila = "PRIORITARIA";
                    } else { //chamar normal
                        qualFila = "NORMAL";
                    }
                    // PELO NÚMERO DE ATENDIMENTO EM PRIORITARIA
                    if (qualFila.equals("PRIORITARIA") && !filaPrioritaria.isEmpty()) {
                        fichaAtendida = (int) filaPrioritaria.poll();
                        totalAtendimentos++;                     
                    } else if (qualFila.equals("NORMAL") && !filaNormal.isEmpty()) {
                        fichaAtendida = (int) filaNormal.poll();
                        totalAtendimentos++;
                    } else if (qualFila.equals("NORMAL") && !filaNormal.isEmpty() && !filaPrioritaria.isEmpty()) {
                        qualFila = "PRIORITARIA";
                        fichaAtendida = (int) filaPrioritaria.poll();
                        totalAtendimentos++;
                    }
                    if (fichaAtendida != -1) {
                        System.out.println("Chamando ficha "+qualFila +":" + fichaAtendida);
                    } else {
                        System.out.println("Ninguem para ser atendido");
                    }

                    break;

                case "4":
                    System.out.println("Mostrando fichas faltantes ");
                    int totalNormalFaltantes = filaNormal.size();
                    int totalPrioritariaFaltantes = filaPrioritaria.size();

                    //como a fila é de valores primitivos, podemos exibir assim
                    System.out.println("Fila normal: " + filaNormal);
                    System.out.println("Total de fichas: " + totalNormalFaltantes);
                    
                    System.out.println("Fila prioritária: " + filaPrioritaria);
                    System.out.println("Total de fichas: " + totalPrioritariaFaltantes);

                    break;
                case "5":
                    System.out.println("Encerrando Sistema");
            
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        } while (!opcao.equals("5"));

        teclado.close();
    }
    
}
