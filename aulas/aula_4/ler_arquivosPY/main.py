from classes import Glicemia
from funcoes import popular_lista, exibir_lista, media_glicemia, mediana_glicemia


lista = []
# obj = Glicemia(191,"13/02/1016","7:00")
# lista.append(obj)

# lista.append(Glicemia(174,"13/02/1016","8:00"))

# for i in range(3):
#     valor = int(input("Valor glicemia: "))
#     data = input("Data [dd/mm/aaaa]: ")
#     hora = input("Hora [hh:mm]: ")

#     lista.append(Glicemia(valor,data,hora))

# for item in lista:
#     print(f"{item.valor} - {item.data} - {item.hora}")
nome_base = "dados.csv"

popular_lista(lista, nome_base)
exibir_lista(lista)

media = media_glicemia(lista)
print("Mediana glicemica: ", media)

mediana = mediana_glicemia(lista)
print("Mediana: ", mediana)