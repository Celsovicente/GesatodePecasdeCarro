/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 35217
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
*/

/*
3. Entidades Fortes e Seus Atributos (Modelo)
- PecaModelo
    int id
    String nome
    String referencia
    String categoria              
    String estado                 
    String marcaAutomovel         
    String modeloAutomovel        
    String localizacao            
    FornecedorModelo fornecedor   
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
    PecaModelo peca                   
    int quantidade
    double precoUnitario
    String nomeCliente
    String telefoneCliente
    String nomeFuncionario
    String tipoPagamento             
    String condicaoVenda             
    String dataVenda
    double totalVenda                 
    boolean status


4. Ficheiros (Persistência de Dados)
- PecaFile.dat
- FornecedorFile.dat
- VendaPecaFile.dat


5. Tabelas de Apoio (Entidades Fracas usadas como atributos)
- CategoriaPeca.tab          
- EstadoPeca.tab             
- MarcasAutomoveis.tab       
- ModelosAutomoveis.tab      
- Localizacao.tab            
- TiposPagamento.tab         
- CondicoesVenda.tab         
- Nacionalidades.tab
- Municipios.tab
- Comunas.tab
- NomeFuncionario.tab

6. Listagens e Pesquisas

- Listagem geral de Peças
- Pesquisa de Peça por Id 
- Pesquisa de Peça por Referência
- Listagem de Fornecedores
- Pesquisa de Forncedores por Id
- Pesquisa de Fornecedores por Nome
- Listagem de Vendas 
- Pesquisa de Venda por Id
- Pesquisa de Venda por Nome do Cliente

7. Diversos
7.1 - Implementação: Java com Swing
7.2 - IDE: Notepad++
*/
