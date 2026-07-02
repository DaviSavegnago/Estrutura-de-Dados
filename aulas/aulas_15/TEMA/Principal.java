import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {

        ArrayList<String> vertices = new ArrayList<>();

        // Primeira leitura: descobrir os vértices
        Scanner arq = new Scanner(new File("mapa.csv"));

        while (arq.hasNextLine()) {

            String linha = arq.nextLine();
            String[] dados = linha.split(",");

            String origem = dados[0];
            String destino = dados[1];

            if (!vertices.contains(origem)) {
                vertices.add(origem);
            }

            if (!vertices.contains(destino)) {
                vertices.add(destino);
            }
        }

        arq.close();

        vertices.sort(null);

        System.out.println("Vertices encontrados:");
        System.out.println(vertices);

        Grafo g = new Grafo(vertices);

        // Segunda leitura: inserir as arestas
        arq = new Scanner(new File("mapa.csv"));

        while (arq.hasNextLine()) {

            String linha = arq.nextLine();
            String[] dados = linha.split(",");

            String origem = dados[0];
            String destino = dados[1];

            g.inserirAresta(
                g.pegarIndice(origem),
                g.pegarIndice(destino)
            );
        }

        arq.close();

        System.out.println();
        g.mostrarMatriz();

        System.out.println();
        g.mostrarGrafo();
    }
}