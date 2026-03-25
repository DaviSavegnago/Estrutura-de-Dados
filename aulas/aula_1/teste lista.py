lista_nome = []

lista_nome.append("Gabriel")

print(lista_nome)

if len(lista_nome) != 0:
    nome = input("Digite um nome: ")
    if lista_nome.__contains__(nome):
        lista_nome.remove("nome")
    else:
        print("Nome não está na lista")

    print(lista_nome)
else:
    print("Lista vazia")
