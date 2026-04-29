package pkg;

public class Aluno {
	
    private String nome;
    private String curso;
    private String sexo;
    private int anoIngresso;

    public Aluno(String nome, String curso, String sexo, int anoIngresso) {
        this.nome = nome;
        this.curso = curso;
        this.sexo = sexo;
        this.anoIngresso = anoIngresso;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("Curso: " + curso);
        System.out.println("Sexo: " + sexo);
        System.out.println("Ano de Ingresso:  " + anoIngresso);
        System.out.println(" \n"); //Pra não ficar colado
    }
}