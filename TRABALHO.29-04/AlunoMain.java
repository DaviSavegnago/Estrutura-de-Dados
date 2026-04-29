package pkg;

import java.util.Scanner;

public class AlunoMain {
    public static void main(String[] args) {

        SistemaAcademico sistema = new SistemaAcademico();
        Scanner teclado = new Scanner(System.in);

        sistema.lerArquivo("aluno.csv"); 

        int opcao;

        do {
            System.out.println("      MENU      ");
            System.out.println("1 - Exibir todos nomes do arquivo:");
            System.out.println("2 - Ordenar por nome");
            System.out.println("3 - Ordenar por ano");
            System.out.println("4 - Buscar por nome");
            System.out.println("5 - Quantidade por ano");
            System.out.println("0 - Sair \n");
            
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    sistema.exibirTodos();
                    break;

                case 2:
                    sistema.ordenarPorNome();
                    sistema.exibirTodos();
                    break;

                case 3:
                    sistema.ordenarPorAno();
                    sistema.exibirTodos();
                    break;

                case 4:
                    System.out.print("Digite o nome EXATO (Ana Silva ou Diego Santos ... ): ");
                    String nome = teclado.nextLine();

                    Aluno encontrado = sistema.buscarPorNome(nome);

                    if (encontrado != null) {
                        encontrado.exibir();
                    } else {
                        System.out.println("Aluno não encontrado");
                    }
                    break;

                case 5:
                    sistema.contarPorAno();
                    break;

                case 0:
                    System.out.println("Saindo");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 0);

        teclado.close();
    }
}