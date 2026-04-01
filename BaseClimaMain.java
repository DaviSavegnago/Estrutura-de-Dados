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

        //percorre os registros
        for (BaseClima c : lista) {

            //conta os meses "Quente"
            if (c.temperatura.equalsIgnoreCase("Quente")) {
                calorPorAno.put(c.ano, calorPorAno.getOrDefault(c.ano, 0) + 1);
            }

            //Conta meses com "Muita", chuva
            if (c.chuva.equalsIgnoreCase("muita")) {
                chuvaPorAno.put(c.ano, chuvaPorAno.getOrDefault(c.ano, 0) + 1);
            }
        }

        //ano mais quente
        int anoMaisQuente = 0, maxCalor = 0;
        for (int ano : calorPorAno.keySet()) {
            if (calorPorAno.get(ano) > maxCalor) {
                maxCalor = calorPorAno.get(ano);
                anoMaisQuente = ano;
            }
        }

        //ano mais chuvoso
        int anoMaisChuvoso = 0, maxChuva = 0;
        for (int ano : chuvaPorAno.keySet()) {
            if (chuvaPorAno.get(ano) > maxChuva) {
                maxChuva = chuvaPorAno.get(ano);
                anoMaisChuvoso = ano;
            }
        }

        //resultado final
        System.out.println("\nRESULTADO:");
        System.out.println("Ano mais quente: " + anoMaisQuente);
        System.out.println("Ano mais chuvoso: " + anoMaisChuvoso);
    }

    public static void main(String[] args) {

        ArrayList<BaseClima> lista = new ArrayList<>();

        lerCSV(lista);

        exibirDados(lista);
        analisar(lista);
    }
}