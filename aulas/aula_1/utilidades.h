void inicializar(string vetor[])
{
    for(int i=0; i<TAMANHO; i++)
    {
        vetor[i] = "vazio";
    }
}

int inserir(string nome, string vetor[], int total)
{
    if(total == TAMANHO)
    {
        cout << "Vetor lotado\n";
    }
    else
    {
        for(int i = 0; i<TAMANHO; i++)
        {
            if(vetor[i] == "vazio")
            {
                vetor[i] = nome;
                total++;
                break;
            }
        }
    }
}

void exibir(string vetor[])
{
    for(int i=0; i<TAMANHO; i++)
    {
        if(vetor[i] != "vazio")
        {
            cout << vetor[i] << "\n";
        }
    }
    
}

void ondeEsta(string vetor[])
{
    int flag=0;

    for (int i = 0; i < TAMANHO; i++)
    {
        if(vetor[i] != "vazio")
        {
            flag = 1;
        }
    }
    
    if(flag==1)
    {
        string procurar;

        cout << "Digite um nome: ";
        cin >> procurar;
        cout << "\n";

        for(int i = 0; i<TAMANHO; i++)
        {
            if(vetor[i] == procurar)
            {
                cout << "Nome encontrado no índice: " << i << "\n";
                flag = 2;
            }
        }

        if(flag != 2)
        {
            cout << "Nome não encontrado!\n";
            flag = 0;
        }
    }
}

void deletar(string vetor[])
{
    string nomeEscolhido;
    int flag = 0;
    cout << "\n";
    exibir(vetor);

    cout << "\nQual nome você deseja deletar?\n-> ";
    cin >> nomeEscolhido;

    for(int i = 0; i< TAMANHO; i++)
    {
        if(vetor[i] == nomeEscolhido)
        {
            vetor[i] = "vazio";
            flag = 1;
        }
    }

    if(flag != 1)
    {
        cout << "O nome digitado não existe na lista.\n";
        flag = 0;
    }

    cout << "\n";
    exibir(vetor);
}