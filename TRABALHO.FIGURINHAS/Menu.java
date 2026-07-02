import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    private ArvoreFigura repetidas = new ArvoreFigura();
    private ArvoreFigura desejadas = new ArvoreFigura();

    public void executar() {

        ArquivoCSV.carregar("figuras_repetidas_pessoais.csv", repetidas);
        ArquivoCSV.carregar("figuras_desejadas_pessoais.csv", desejadas);

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar figuras repetidas");
            System.out.println("2 - Listar figuras repetidas");
            System.out.println("3 - Cadastrar figuras desejadas");
            System.out.println("4 - Listar figuras desejadas");
            System.out.println("5 - Carregar repetidas OUTRO");
            System.out.println("6 - Carregar desejadas OUTRO");
            System.out.println("7 - Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    cadastrarRepetida();
                    break;

                case 2:
                    repetidas.listar();
                    break;

                case 3:
                    cadastrarDesejada();
                    break;

                case 4:
                    desejadas.listar();
                    break;

                case 5:

                    ArvoreFigura repetidasOutro = new ArvoreFigura();

                    ArquivoCSV.carregar("figuras_repetidas_outro.csv", repetidasOutro);

                    System.out.println("\nFIGURAS REPETIDAS DO OUTRO\n");

                    repetidasOutro.listar();

                    System.out.println("\nMATCHES\n");

                    repetidasOutro.mostrarMatches(desejadas);

                    break;

                case 6:

                    ArvoreFigura desejadasOutro = new ArvoreFigura();

                    ArquivoCSV.carregar("figuras_desejadas_outro.csv", desejadasOutro);

                    System.out.println("\nFIGURAS DESEJADAS DO OUTRO\n");

                    desejadasOutro.listar();

                    System.out.println("\nMATCHES\n");

                    repetidas.mostrarMatches(desejadasOutro);

                    break;

                case 7:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");

            }

        } while (opcao != 7);

    }

    private void cadastrarRepetida() {

        Figura figura = lerFigura();

        repetidas.inserir(figura);

        ArquivoCSV.salvar("figuras_repetidas_pessoais.csv", figura);

        System.out.println("Figura cadastrada.");
    }

    private void cadastrarDesejada() {

        Figura figura = lerFigura();

        desejadas.inserir(figura);

        ArquivoCSV.salvar("figuras_desejadas_pessoais.csv", figura);

        System.out.println("Figura cadastrada.");
    }

    private Figura lerFigura() {

        scanner.nextLine();

        System.out.print("Seleção: ");
        String selecao = scanner.nextLine();

        System.out.print("Número: ");
        int numero = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        System.out.print("É rara? (true/false): ");
        boolean rara = scanner.nextBoolean();

        return new Figura(selecao, numero, descricao, quantidade, rara);
    }

}