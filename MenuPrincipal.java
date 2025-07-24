/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 35217
Ficheiro: Analise.java
Data: 16.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import SwingComponents.*;
import Calendario.*;

public class MenuPrincipal extends JFrame implements ActionListener
{
    private JMenuBar menuBar;
    private JMenu menuFornecedor, menuVenda, menuPeca, menuListagem, menuAjuda, menuTabela, menuDefesa;
    private JMenuItem novoFornecedorItem, editarFornecedorItem, eliminarFornecedorItem, sairFornecedorItem;
    private JMenuItem novaVendaItem, editarVendaItem, eliminarVendaItem, sairVendaItem;
    private JMenuItem novaPecaItem, editarPecaItem, eliminarPecaItem, sairPecaItem;
    private JMenuItem listarPecaItem, pesquisarPecaItem, listarVendaItem, pesquisarVendaItem, 
    listarFornecedorItem, pesquisarFornecedorItem;
    private JMenuItem novaDefesaItem, listarDefesaItem, pesquisarDefesaItem;
    private JMenuItem categoriaItem, estadoPecaItem, marcasAutomoveisItem, tipoPagamentoItem, localizacaoItem,
    condicaoVendaItem, modeloAutomovelItem, nacionalidadeItem, provinciaItem, municipioItem, comunaItem,
    nomeFuncionarioItem, conferencia, diocese, paroquia;

	public MenuPrincipal(String user)
	{
		super("Menu Principal " + user);
		
		menuBar = new JMenuBar();
		
		instanciarObjetos();
		
		setJMenuBar( menuBar);
		
		setSize(800, 700);
		setLocationRelativeTo(null);
		setVisible(true);
	}

    public void instanciarObjetos()
    {
        // instanciando os elementos do menuBar
        menuBar.add(menuPeca = new JMenu("Peca"));
        menuPeca.setMnemonic('P');
        //menuPeca.setIcon(new ImageIcon("image/"));
        menuBar.add(menuFornecedor = new JMenu("Fornecedor"));
        menuFornecedor.setMnemonic('F');
        //menuFornecedor.setIcon(new ImageIcon(""));
        menuBar.add(menuVenda = new JMenu("Venda"));
        menuVenda.setMnemonic('V');
        //menuVenda.setIcon(new ImageIcon(""));
        menuBar.add(menuListagem = new JMenu("Listagens/Pesquisas"));
        menuListagem.setMnemonic('L');
        menuListagem.setIcon(new ImageIcon("image/search32.png"));
        menuBar.add(menuTabela = new JMenu("Tabela"));
        menuTabela.setIcon(new ImageIcon("image/all/tabela24.png"));
        menuBar.add(menuAjuda = new JMenu("AJuda"));
        menuAjuda.setMnemonic('A');
        menuAjuda.setIcon(new ImageIcon("image/help.png"));
        menuBar.add(menuDefesa = new JMenu("Defesa"));
        menuDefesa.setMnemonic('D');

        // instanciando os elementos do menuPecas
        menuPeca.add(novaPecaItem = new JMenuItem("Nova Peca", new ImageIcon("image/novo24.png")));
        novaPecaItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
        menuPeca.add(editarPecaItem = new JMenuItem("Editar", new ImageIcon("image/edit24.png")));
        menuPeca.add(eliminarPecaItem = new JMenuItem("Eliminar", new ImageIcon("image/delete24.png")));
        menuPeca.addSeparator();
        menuPeca.add(sairPecaItem = new JMenuItem("Sair", new ImageIcon("image/logout24.png")));

        // instanciando os elementos do menuFornecedor
        menuFornecedor.add(novoFornecedorItem = new JMenuItem("Novo Fornecedor", new ImageIcon("image/novo24.png")));
        novoFornecedorItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
        menuFornecedor.add(editarFornecedorItem = new JMenuItem("Editar", new ImageIcon("image/edit24.png")));
        menuFornecedor.add(eliminarFornecedorItem = new JMenuItem("Eliminar", new ImageIcon("image/delete24.png")));
        menuFornecedor.addSeparator();
        menuFornecedor.add(sairFornecedorItem = new JMenuItem("Sair", new ImageIcon("image/logout24.png")));

        // instanciando os elementos do menuVenda
        menuVenda.add(novaVendaItem = new JMenuItem("Nova Venda", new ImageIcon("image/novo24.png")));
        novaVendaItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        menuVenda.add(editarVendaItem = new JMenuItem("Editar", new ImageIcon("image/edit24.png")));
        menuVenda.add(eliminarVendaItem = new JMenuItem("Eliminar", new ImageIcon("image/delete24.png")));
        menuVenda.addSeparator();
        menuVenda.add(sairVendaItem = new JMenuItem("Sair", new ImageIcon("image/logout24.png")));

        // instanciando os elementos do menuListagem
        menuListagem.add(listarFornecedorItem = new JMenuItem("Listar Fornecedor"));
        menuListagem.add(pesquisarFornecedorItem = new JMenuItem("Pesquisar Fornecedor"));
        menuListagem.addSeparator();
        menuListagem.add(listarPecaItem = new JMenuItem("Listar Pecas"));
        menuListagem.add(pesquisarPecaItem = new JMenuItem("Pesquisar Pecas"));
        menuListagem.addSeparator();
        menuListagem.add(listarVendaItem = new JMenuItem("Listar Vendas"));
        menuListagem.add(pesquisarVendaItem = new JMenuItem("Pesquisar Vendas"));
        menuListagem.addSeparator();
        menuListagem.add(listarDefesaItem = new JMenuItem("Listar Defesas"));

        // instanciando os elementos do menuTabela
        menuTabela.add(categoriaItem = new JMenuItem("Categoria"));
        menuTabela.add(estadoPecaItem = new JMenuItem("Estado da Peca"));
        menuTabela.add(marcasAutomoveisItem = new JMenuItem("Marcas de Automoveis"));
        menuTabela.add(localizacaoItem = new JMenuItem("Localizacao"));
        menuTabela.add(tipoPagamentoItem = new JMenuItem("Tipo de Pagamento"));
        menuTabela.add(condicaoVendaItem = new JMenuItem("Condicao de Venda"));
        menuTabela.add(modeloAutomovelItem = new JMenuItem("Modelo de Automoveis"));
        menuTabela.add(nacionalidadeItem = new JMenuItem("Nacionalidade"));
        menuTabela.add(provinciaItem = new JMenuItem("Provincia"));
        menuTabela.add(municipioItem = new JMenuItem("Municipio"));
        menuTabela.add(comunaItem = new JMenuItem("Comuna"));
        menuTabela.add(nomeFuncionarioItem = new JMenuItem("Nome do Funcionario"));
        menuTabela.add(conferencia = new JMenuItem("Conferencia"));
        menuTabela.add(diocese = new JMenuItem("Diocese"));
        menuTabela.add(paroquia = new JMenuItem("Paroquia"));

        // instanciando os elementos do menu Defesa
        menuDefesa.add(novaDefesaItem = new JMenuItem("Nova Defesa"));
        menuDefesa.addSeparator();
        menuDefesa.add(pesquisarDefesaItem = new JMenuItem("Pesquisar Defesa"));

        // adiconando os eventos nos elementos do menuPecas
        novaPecaItem.addActionListener(this);
        editarPecaItem.addActionListener(this);
        eliminarPecaItem.addActionListener(this);
        sairPecaItem.addActionListener(this);
        listarPecaItem.addActionListener(this);
        pesquisarPecaItem.addActionListener(this);

        // adicionando eventos nos elementos do menuVendas
        novaVendaItem.addActionListener(this);
        editarVendaItem.addActionListener(this);
        eliminarVendaItem.addActionListener(this);
        sairVendaItem.addActionListener(this);
        listarVendaItem.addActionListener(this);
        pesquisarVendaItem.addActionListener(this);
        
        // adicionando eventos nos elementos do menuFornedor
        novoFornecedorItem.addActionListener(this);
        editarFornecedorItem.addActionListener(this);
        eliminarFornecedorItem.addActionListener(this);
        sairFornecedorItem.addActionListener(this);
        listarFornecedorItem.addActionListener(this);
        pesquisarFornecedorItem.addActionListener(this);

        // adicionando eventos aos elementos das tabelas
        categoriaItem.addActionListener(this);
        estadoPecaItem.addActionListener(this);
        marcasAutomoveisItem.addActionListener(this);
        modeloAutomovelItem.addActionListener(this);
        localizacaoItem.addActionListener(this);
        tipoPagamentoItem.addActionListener(this);
        condicaoVendaItem.addActionListener(this);
        nacionalidadeItem.addActionListener(this);
        provinciaItem.addActionListener(this);
        municipioItem.addActionListener(this);
        comunaItem.addActionListener(this);
        nomeFuncionarioItem.addActionListener(this);
        conferencia.addActionListener(this);
        diocese.addActionListener(this);
        paroquia.addActionListener(this);

        // adicionando evento aos elementos do menu defesa
        novaDefesaItem.addActionListener(this);
        pesquisarDefesaItem.addActionListener(this);
        listarDefesaItem.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == novoFornecedorItem)
            new FornecedorVisao(false, new FornecedorModelo());
        else if(event.getSource() == editarFornecedorItem)
            new EditarFornecedor();
        else if(event.getSource() == eliminarFornecedorItem)
            new EliminarFornecedor();
        else if(event.getSource() == listarFornecedorItem)
            FornecedorFile.listarFornecedores();
        else if(event.getSource() == pesquisarFornecedorItem)
            new PesquisarFornecedor();
        else if(event.getSource() == novaPecaItem)
            new PecaVisao(false, new PecaModelo());
        else if(event.getSource() == editarPecaItem)
            new EditarPeca();
        else if(event.getSource() == eliminarPecaItem)
            new EliminarPeca();
        else if(event.getSource() == pesquisarPecaItem)
            new PesquisarPeca();
        else if(event.getSource() == listarPecaItem)
            PecaFile.listarPecas();
        else if(event.getSource() == novaVendaItem)
            new VendaVisao(false, new VendaModelo());
        else if(event.getSource() == editarVendaItem)
            new EditarVenda();
        else if(event.getSource() == eliminarVendaItem)
            new EliminarVenda();
        else if(event.getSource() == pesquisarVendaItem)
            new PesquisarVenda();
        else if(event.getSource() == listarVendaItem)
            VendaFile.listarVendas();
        else if(event.getSource() == novaDefesaItem)
            new DefesaVisao();
        else if(event.getSource() == pesquisarDefesaItem)
            new PesquisarDefesa();
        else if(event.getSource() == listarDefesaItem)
            DefesaFile.listarDefesa();
        else if(event.getSource() == nacionalidadeItem)
            Tabela2.editarNovosItems("Nacionalidades.tab", "Nova Nacionalidade");
        else if(event.getSource() == categoriaItem)
            Tabela2.editarNovosItems("CategoriaPeca.tab", "Nova Categoria");
        else if(event.getSource()  == estadoPecaItem)
            Tabela2.editarNovosItems("EstadoPeca.tab", "Novo Estado da Peca");
        else if(event.getSource() == localizacaoItem)
            Tabela2.editarNovosItems("Localizacao.tab", "Nova Localizacao");
        else if(event.getSource() == nomeFuncionarioItem)
            Tabela2.editarNovosItems("NomeFuncionario.tab", "Novo Nome do Funcionario");
        else if(event.getSource() == tipoPagamentoItem)
            Tabela2.editarNovosItems("TiposPagamento.tab", "Novo Tipo de Pagamento");
        else if(event.getSource() == condicaoVendaItem)
            Tabela2.editarNovosItems("CondicoesVenda.tab", "Nova Condicao");
        else if(event.getSource() == marcasAutomoveisItem)
            Tabela3_2.editarNovosItems("CategoriaPeca.tab", "MarcasAutomoveis.tab", 
            "Categoria", "Marca", "Nova Marca de Automoveis");
        else if(event.getSource() == modeloAutomovelItem)
            Tabela3_3.editarNovosItems("CategoriaPeca.tab", "MarcasAutomoveis.tab", "ModelosAutomoveis.tab",
            "Categoria de Peca", "Marca de Automoveis", "Modelos de Automoveis", "Novo Modelo de Automovel");
        else if(event.getSource() == provinciaItem)
            Tabela2.editarNovosItems("Provincias.tab", "Nova Provincia");
        else if(event.getSource() == municipioItem)
            Tabela3_2.editarNovosItems("Provincias.tab", "Municipios.tab", "Provincia", 
            "Municipio", "Novo Municpio");
        else if(event.getSource() == comunaItem)
            Tabela3_3.editarNovosItems("Provincias.tab", "Municipios.tab", "Comunas.tab", "Provincia", 
            "Municipio", "Comuna", "Nova Comuna");
        else if(event.getSource() == conferencia)
            Tabela2.editarNovosItems("Conferencia.tab", "Nova Conferencia");
        else if(event.getSource() == diocese)
            Tabela3_2.editarNovosItems("Conferencia.tab","Diocese.tab", "Conferencia", "Diocese", 
            "Nova Diocese");
        else if(event.getSource() == paroquia)
            Tabela3_3.editarNovosItems("Conferencia.tab", "Diocese.tab", "Paroquia.tab", 
            "Conferencia", "Diocese", "Paroquia", "Nova Paroquia");
        else if(event.getSource() == sairFornecedorItem)
            dispose();
        else if(event.getSource() == sairFornecedorItem)
            dispose();
        else if(event.getSource() == sairVendaItem)
            dispose();
    }	

    public static void main(String[] args)
    {
        Vector_Tabelas.inic();
        new MenuPrincipal("");
    }
}