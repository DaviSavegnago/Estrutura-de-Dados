//O programa lê os dados climáticos do arquivo, armazena cada registro em objetos da classe BaseClima dentro de uma lista,
//depois percorre esses dados para contar, por ano, quantos meses foram quentes e quantos tiveram muita chuva utilizando HashMap, 
//no final, identifica e exibe o ano mais quente e o ano mais chuvoso.

public class BaseClima {

    //atributos
    public int ano;
    public String mes;
    public String temperatura;
    public String chuva;

    //construtor, para inicializar os dados
    public BaseClima(int ano, String mes, String temperatura, String chuva) {
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.chuva = chuva;
    }


    //para exibir em formato de texto, de forma organizada
    @Override
    public String toString() {
        return ano + " | " + mes + " | " + temperatura + " | " + chuva;
    }


    //define o critério de igualdade entre dois objetos
    //nesse caso, considera igual se for o mesmo ano e mês
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BaseClima)) return false;

        BaseClima outro = (BaseClima) obj;
        return this.ano == outro.ano &&
               this.mes.equals(outro.mes);
    }

    //gera um código de identificação do objeto
    @Override
    public int hashCode() {
        return (ano + mes).hashCode();
    }
}