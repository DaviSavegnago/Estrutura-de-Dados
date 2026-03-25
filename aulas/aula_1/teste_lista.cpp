#include <cstdlib>
#include <iostream>
#include <string>

#define TAMANHO 10

using namespace std;

#include "utilidades.h"


int main()
{
    string vetorNomes[TAMANHO];
    inicializar(vetorNomes);
    int totalNomesInseridos = 0;

    totalNomesInseridos = inserir("Davi", vetorNomes, totalNomesInseridos);
    totalNomesInseridos = inserir("Eduardo", vetorNomes, totalNomesInseridos);
    totalNomesInseridos = inserir("Gabriel", vetorNomes, totalNomesInseridos);

    if(totalNomesInseridos > 0)
    {
        exibir(vetorNomes);
    }
    else
    {
        cout << "O vetor está vazio";
    }

    ondeEsta(vetorNomes);
    deletar(vetorNomes);

    return 1;
}
