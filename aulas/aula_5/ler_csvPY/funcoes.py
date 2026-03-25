from classes import Clima

def popular_lista(lista, nome_base):

    reader = open(nome_base, "r", encoding="utf8")

    for linha in reader:
        vetor_linha = linha.strip().split(",")
        obj = Clima(vetor_linha[0], vetor_linha[1], vetor_linha[2], vetor_linha[3])

        if obj not in lista:
            lista.append(obj)

    reader.close()

def exibir_lista(lista):
    for item in lista:
        print(f"{item.ano} - {item.mes} - {item.temperatura} - {item.precipitacao}")

def mais_chuva(lista):
    