package ler_csvJAVA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
//        ArrayList<Clima> lista = new ArrayList<>();
//
//        String linha = "2022,Fevereiro,Quente,muita";
//        String dadosLinha[] = linha.split(",");
//        Clima objClima = new Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);
//
//        linha = "2022,Fevereiro,Quente,muita";
//        dadosLinha = linha.split(",");
//        objClima = new Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);
//
//        if (!lista.contains(objClima))
//        {
//            lista.add(objClima);
//        }
//
//        for(Clima c : lista)
//        {
//            System.out.println(c);
//        }
        List<Clima> lista = new ArrayList<>();
        String nomeBase = "base.csv";

        // O try-with-resources já fecha o arquivo automaticamente (igual ao 'with' do Python)
        try (BufferedReader leitor = new BufferedReader(
                new FileReader(nomeBase, StandardCharsets.UTF_8))) {

            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] dadosLinha = linha.split(",");

                Clima objClima = new Clima(dadosLinha[0],dadosLinha[1],dadosLinha[2], dadosLinha[3]);

                // Requer que o metodo equals() esteja implementado na classe Clima
                if (!lista.contains(objClima)) {
                    lista.add(objClima);
                }
            }

            for (Clima item : lista) {
                System.out.println(item);
            }

        } catch (Exception e) {
            System.err.println("Ocorreu algum erro... " + e.getMessage());
        }

    }
}
