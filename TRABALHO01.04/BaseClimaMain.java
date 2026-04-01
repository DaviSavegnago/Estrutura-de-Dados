import java.io.BufferedReader;       
import java.io.FileReader;          
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

//O programa lê os dados climáticos do arquivo, armazena cada registro em objetos da classe BaseClima dentro de uma lista,
//depois percorre esses dados para contar, por ano, quantos meses foram quentes e quantos tiveram muita chuva utilizando HashMap, 
//no final, identifica e exibe o ano mais quente e o ano mais chuvoso.

public class BaseClimaMain {

    public static void lerCSV(ArrayList<BaseClima> lista) {

        String caminho = "base.csv";

        //leitura do arquivo
        try (BufferedReader leitor = new BufferedReader(
                new FileReader(caminho, StandardCharsets.UTF_8))) {

            String linha;

            //linha por linha
            while ((linha = leitor.readLine()) != null) {

                //separa usando vírgula
                String[] dados = linha.split(",");

                //conversão de String para int (ano)
                int ano = Integer.parseInt(dados[0]);

                //outros permanecem String
                String mes = dados[1];
                String temperatura = dados[2];
                String chuva = dados[3];

                //criação do objeto
                BaseClima c = new BaseClima(ano, mes, temperatura, chuva);

                //evitar duplicados
                if (!lista.contains(c)) {
                    lista.add(c);
                }
            }

        } catch (Exception e) {
            //se der erro na leitura do arquivo
            System.out.println("Erro ao ler CSV: " + e.getMessage());
        }
    }

    //exibe os dados carregados
    public static void exibirDados(ArrayList<BaseClima> lista) {

        System.out.println("\nDados carregados:");
        for (BaseClima c : lista) {
            System.out.println(c);
        }
    }

    public static void analisar(ArrayList<BaseClima> lista) {

        //estruturas para contagem por ano
        HashMap<Integer, Integer> calorPorAno = new HashMap<>();
        HashMap<Integer, Integer> chuvaPorAno = new HashMap<>();
        HashMap<Integer, Integer> mediaPorAno = new HashMap<>();
        HashMap<Integer, Integer> poucaPorAno = new HashMap<>();
        HashMap<Integer, Integer> nadaPorAno = new HashMap<>();

        //percorre os registros
        for (BaseClima c : lista) {

            //conta os meses "Quente"
            if (c.temperatura.equalsIgnoreCase("Quente")) {
                calorPorAno.put(c.ano, calorPorAno.getOrDefault(c.ano, 0) + 1);
            }

            //Conta meses com "Muita", "Media" chuva
            String chuva = c.chuva.toLowerCase();

            if (chuva.equals("muita")) {
                chuvaPorAno.put(c.ano, chuvaPorAno.getOrDefault(c.ano, 0) + 1);
            } else if (chuva.equals("media")) {
                mediaPorAno.put(c.ano, mediaPorAno.getOrDefault(c.ano, 0) + 1);
            } else if (chuva.equals("pouca")) {
                poucaPorAno.put(c.ano, poucaPorAno.getOrDefault(c.ano, 0) + 1);
            } else if (chuva.equals("nada")) {
                nadaPorAno.put(c.ano, nadaPorAno.getOrDefault(c.ano, 0) + 1);
            }
        }

        //ano mais quente, ajeitei caso de empate
         ArrayList<Integer> anosMaisQuentes = new ArrayList<>();
        int maxCalor = 0;

        for (int ano : calorPorAno.keySet()) {
            int valor = calorPorAno.get(ano);

            if (valor > maxCalor) {
                maxCalor = valor;
                anosMaisQuentes.clear();
                anosMaisQuentes.add(ano);
            } else if (valor == maxCalor) {
                anosMaisQuentes.add(ano);
            }
        }

        //ano mais chuvoso, ajeitei caso de empate
        ArrayList<Integer> anosMaisChuvosos = new ArrayList<>();
        int maxChuva = 0;

        for (int ano : chuvaPorAno.keySet()) {
            int valor = chuvaPorAno.get(ano);

            if (valor > maxChuva) {
                maxChuva = valor;
                anosMaisChuvosos.clear();
                anosMaisChuvosos.add(ano);
            } else if (valor == maxChuva) {
                anosMaisChuvosos.add(ano);
            }
        }

         int melhorAnoChuva = -1;

        for (int ano : anosMaisChuvosos) {

            if (melhorAnoChuva == -1) {
                melhorAnoChuva = ano;
                continue;
            }

            int mediaAtual = mediaPorAno.getOrDefault(ano, 0);
            int mediaMelhor = mediaPorAno.getOrDefault(melhorAnoChuva, 0);

            if (mediaAtual > mediaMelhor) {
                melhorAnoChuva = ano;
            } else if (mediaAtual == mediaMelhor) {

                int poucaAtual = poucaPorAno.getOrDefault(ano, 0);
                int poucaMelhor = poucaPorAno.getOrDefault(melhorAnoChuva, 0);

                if (poucaAtual > poucaMelhor) {
                    melhorAnoChuva = ano;
                } else if (poucaAtual == poucaMelhor) {

                    int nadaAtual = nadaPorAno.getOrDefault(ano, 0);
                    int nadaMelhor = nadaPorAno.getOrDefault(melhorAnoChuva, 0);

                    if (nadaAtual > nadaMelhor) {
                        melhorAnoChuva = ano;
                    }
                }
            }
        }


        //resultado final
       System.out.println("\nRESULTADO:");

        if (anosMaisQuentes.size() > 1) {
            System.out.println("Empate anos mais quentes: " +
                    anosMaisQuentes.toString().replace("[", "").replace("]", ""));
        } else {
            System.out.println("Ano mais quente: " + anosMaisQuentes.get(0));
        }

        if (anosMaisChuvosos.size() > 1) {
            System.out.println("Empate na chuva (muita): " +
                    anosMaisChuvosos.toString().replace("[", "").replace("]", ""));
            System.out.println("Desempate -> Ano mais chuvoso (mais médias): " + melhorAnoChuva);
        } else {
            System.out.println("Ano mais chuvoso: " + melhorAnoChuva);
        }
    }

    public static void main(String[] args) {

        ArrayList<BaseClima> lista = new ArrayList<>();

        lerCSV(lista);

        exibirDados(lista);
        analisar(lista);
    }
}
