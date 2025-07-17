/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 2817
Ficheiro: Analise.java
Data: 19.06.2025
--------------------------------------*/

/*
1. Objetivo
Este projeto tem como objetivo gerir o stock de peças automóveis, incluindo 
o registo de fornecedores, vendas e consulta da localização das peças dentro do armazém.
*/

/*
2. Visão [Interfaces Gráficas]
- ApresentacaoVisao
- LoginVisao
- MenuPrincipal
- PecaVisao
- FornecedorVisao
- VendaVisao
- ConsultaStockVisao
*/

/*
3. Entidades Fortes e Seus Atributos (Modelo)
- PecaModelo
    int id
    String nome
    String referencia
    String categoria               // (de CategoriaPeca.tab)
    String estado                 // (de EstadoPeca.tab: Nova, Usada, etc.)
    String marcaAutomovel         // (de MarcasAutomoveis.tab)
    String modeloAutomovel        // (de ModelosAutomoveis.tab)
    String localizacao            // (de Localizacao.tab)
    FornecedorModelo fornecedor   // Relação direta com FornecedorModelo
    float preco
    int quantidade
    String disponibilidade
    boolean status

- FornecedorModelo
    int id
    String nome
    String telefone.
    String email
    String contatoResponsavel
    String nacionalidade
    String provincia
    String municipio
    String comuna

- VendaPecaModelo
    int id
    PecaModelo peca                   // Relação direta com PecaModelo
    String dataVenda
    int quantidade
    double precoUnitario
    double totalVenda                 // Calculado: precoUnitario * quantidade
    String nomeCliente
    String telefoneCliente
    String nomeFuncionario
    String tipoPagamento              // (de TiposPagamento.tab)
    String condicaoVenda              // (de CondicoesVenda.tab)


4. Ficheiros (Persistência de Dados)
- PecaFile.dat
- FornecedorFile.dat
- VendaPecaFile.dat


5. Tabelas de Apoio (Entidades Fracas usadas como atributos)
- CategoriaPeca.tab          → atributo: categoria
- EstadoPeca.tab             → atributo: estado
- MarcasAutomoveis.tab       → atributo: marcaAutomovel
- ModelosAutomoveis.tab      → atributo: modeloAutomovel
- Localizacao.tab            → atributo: localizacao
- TiposPagamento.tab         → atributo: tipoPagamento
- CondicoesVenda.tab         → atributo: condicaoVenda
- Nacionalidades.tab
- Municipios.tab
- Comunas.tab

6. Listagens e Pesquisas

- Listagem geral de Peças
- Pesquisa de Peça por Nome ou Referência
- Consulta de Stock por Categoria ou Localização
- Listagem de Fornecedores
- Histórico de Vendas por Peça ou Cliente

7. Diversos
7.1 - Implementação: Java com Swing
7.2 - IDE: Notepad++
*/
