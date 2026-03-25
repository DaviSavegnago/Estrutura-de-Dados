#include <iostream>
#include <cstdlib>
#include <vector> // para a lista
#include <ctime>

using namespace std;

/**
 * @brief método que popula uma lista com números inteiros aleatórios dentro de uma faixa
 * 
 * @param lista contém os números aleatórios gerados
 * @param quantidadeNumeros contém quantos números se deseja inserir na lista
 * @param faixaInicial contém o número inicial da faixa
 * @param faixaFinal contém o número final da faixa
 */
void popularListaAleatoria(vector<int> &lista, int quantidadeNumeros, int faixaInicial, int faixaFinal)
{
    //observe o simbolo & na frente de variável lista. Isso acontece pq em C++ se houver alteração na lista
    // precisa usar o simbolo de endereçamento &
    srand(time(NULL));
    int numeroSorteado;
    for(int i = 0; i < quantidadeNumeros; i++)
    {
        numeroSorteado = faixaInicial + (rand() % faixaFinal);
        lista.push_back(numeroSorteado);
    }
}

/**
 * @brief método que recebe uma lista e a exibe, elementos um abaixo do outro
 * 
 * @param lista lista contendo números inteiros
 */
void exibirLista(vector<int> lista)
{
    for(int i = 0; i < lista.size(); i++)
    {
        cout << lista[i] << "\n";
    }

    cout << "+--------------+\n";
    cout << "Total de elementos: " << lista.size() << "\n";
}

/**
 * @brief método que copia o conteúdo da lista origem para dentro da lista destino sem os replicados
 * 
 * @param listaOrigem lista original contendo todos os números
 * @param listaDestino lista final contendo somente os números não replicados
 */
void copiarListaSemReplicados(vector<int> listaOrigem,vector<int> &listaDestino)
{
    int numeroTemporario = 0;
    int flag = 0;
    for(int i = 0; i < listaOrigem.size(); i++)
    {
        numeroTemporario = listaOrigem[i];
        for(int j = 0; j < listaDestino.size(); j++)
        {
            if(listaOrigem[i] == listaDestino[j])
            {
                flag = 1;
            }
        }

        if(flag == 0)
        {
            listaDestino.push_back(numeroTemporario);
        }
        flag = 0;
    }
}