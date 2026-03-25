#include <iostream>
#include <cstdlib>
#include <vector> // para a lista

using namespace std;

#include "biblioteca.h"


int main()
{
    vector<int> listaNumeros;
    int quantidadeNumeros = 0;
    int faixaInicial = 10, faixaFinal = 15;
    vector<int> listaResultados;

    cout << "Digite quantos números quer gerar:\n -> ";
    cin >> quantidadeNumeros;

    popularListaAleatoria(listaNumeros, quantidadeNumeros, faixaInicial, faixaFinal);
    exibirLista(listaNumeros);

    copiarListaSemReplicados(listaNumeros, listaResultados);
    exibirLista(listaResultados);

    return 1;
}