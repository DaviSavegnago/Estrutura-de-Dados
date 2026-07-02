import java.io.*;

public class ArquivoCSV {

    public static void carregar(String nomeArquivo, ArvoreFigura arvore) {

        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {

            br.readLine();

            String linha;

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(",");

                String nomeSelecao = dados[0];
                int numeroFigura = Integer.parseInt(dados[1]);
                String descricao = dados[2];
                int quantidade = Integer.parseInt(dados[3]);
                boolean rara = Boolean.parseBoolean(dados[4]);

                Figura figura = new Figura(
                        nomeSelecao,
                        numeroFigura,
                        descricao,
                        quantidade,
                        rara
                );

                arvore.inserir(figura);
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo.");
        }

    }

    public static void salvar(String nomeArquivo, Figura figura) {

        File arquivo = new File(nomeArquivo);

        try {

            boolean existe = arquivo.exists();

            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (!existe) {
                bw.write("nomeSelecao,numeroFigura,descricao,quantidade,rara");
                bw.newLine();
            }

            bw.write(
                    figura.getNomeSelecao() + "," +
                    figura.getNumeroFigura() + "," +
                    figura.getDescricao() + "," +
                    figura.getQuantidade() + "," +
                    figura.isRara()
            );

            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo.");
        }

    }

}