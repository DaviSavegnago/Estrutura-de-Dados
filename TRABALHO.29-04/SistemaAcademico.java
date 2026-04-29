package pkg;

import java.io.*;
import java.util.*;

public class SistemaAcademico {
    private List<Aluno> alunos = new ArrayList<>();

    public void lerArquivo(String caminho) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminho));
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                String nome = dados[0];
                String curso = dados[1];
                String sexo = dados[2];
                int ano = Integer.parseInt(dados[3]);

                alunos.add(new Aluno(nome, curso, sexo, ano));
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo");
        }
    }

    public void ordenarPorNome() {
        Collections.sort(alunos, new Comparator<Aluno>() { //ordena alfabeticamente
            public int compare(Aluno a, Aluno b) {
                return a.getNome().compareTo(b.getNome());
            }
        });
    }

    public void ordenarPorAno() {
        Collections.sort(alunos, new Comparator<Aluno>() { //ordena cronologicamente
            public int compare(Aluno a, Aluno b) {
                return Integer.compare(a.getAnoIngresso(), b.getAnoIngresso());
            }
        });
    }

    public Aluno buscarPorNome(String nome) {
        for (Aluno a : alunos) {
            if (a.getNome().equals(nome)) {
                return a;
            }
        }
        return null;
    }

    public void contarPorAno() {
        Map<Integer, Integer> contador = new HashMap<>(); //armazena os alunos por ano

        for (Aluno a : alunos) {
            int ano = a.getAnoIngresso();
            if (contador.containsKey(ano)) {
                contador.put(ano, contador.get(ano) + 1);
            } else {
                contador.put(ano, 1);
            }
        }

        for (Integer ano : contador.keySet()) {
            System.out.println("Ano: " + ano + ": " + contador.get(ano) + " alunos!\n");
        }
    }

    public void exibirTodos() {
        for (Aluno a : alunos) {
            a.exibir();
        }
    }
}