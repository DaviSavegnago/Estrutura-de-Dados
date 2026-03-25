from classes import Glicemia

def popular_lista(lista, nome_base):

    reader = open(nome_base, "r", encoding="utf8")

    for linha in reader:
        vetor_linha = linha.strip().split(",")
        obj = Glicemia(int(vetor_linha[0]), vetor_linha[1], vetor_linha[2])

        if obj not in lista:
            lista.append(obj)

    reader.close()

def exibir_lista(lista):
    for item in lista:
        print(f"{item.valor} - {item.data} - {item.hora}")

def media_glicemia(lista):
    soma = 0
    for item in lista:
        soma += item.valor

    return int(soma/len(lista))

def mediana_glicemia(lista):
    lista.sort(key=lambda g: g.valor)

    if(len(lista) % 2 == 0):
        i = len(lista)//2
        mediana = (lista[i-1].valor+lista[i].valor)/2
    else:
        i = (len(lista)//2)
        mediana = lista[i].valor

        return mediana