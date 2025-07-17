import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import SwingComponents.*;

public class MenuPrincipal extends JFrame implements ActionListener {
    
    private JMenu ficheiroMenu, operacoesMenu, listagensMenu, tabelasMenu, ajudaMenu;
    private JMenuItem novoPecaItem, alterarPecaItem, eliminarPecaItem, sairItem;
    private JMenuItem novaVendaItem, listarVendasItem;
    private JMenuItem listarPecasItem;
    private JMenuItem ajudaSobreAutorItem, ajudaSobreAplicacaoItem;
    private JMenuBar menuBar;
    
    public MenuPrincipal() {        
        super("Menu Principal");
        
        menuBar = new JMenuBar();
        
        adicionarComponentes();
        
        setJMenuBar(menuBar);
        
        setSize(800, 700);
        setLocationRelativeTo(null);    // Alinhar ao centro
        setVisible(true);
    }
    
    public void adicionarComponentes() {
        menuBar.add(ficheiroMenu = new JMenu("Ficheiro"));
        ficheiroMenu.setMnemonic('F');
        menuBar.add(operacoesMenu = new JMenu("Operações"));
        operacoesMenu.setMnemonic('O');
        menuBar.add(listagensMenu = new JMenu("Listagens"));
        listagensMenu.setMnemonic('L');
        menuBar.add(tabelasMenu = new JMenu("Tabelas"));
        tabelasMenu.setMnemonic('T');
        menuBar.add(ajudaMenu = new JMenu("Ajuda"));
        ajudaMenu.setMnemonic('A');
        
        ficheiroMenu.add(novoPecaItem = new JMenuItem("Novo Peca"));
        ficheiroMenu.add(alterarPecaItem = new JMenuItem("Alterar Peca"));
        ficheiroMenu.add(eliminarPecaItem = new JMenuItem("Eliminar Peca"));
        ficheiroMenu.addSeparator();
        ficheiroMenu.add(sairItem = new JMenuItem("Sair"));
        
        operacoesMenu.add(novaVendaItem = new JMenuItem("Nova Venda"));
        
        listagensMenu.add(listarPecasItem = new JMenuItem("Listar Pecas"));
        listagensMenu.add(listarVendasItem = new JMenuItem("Listar Vendas"));
        
        ajudaMenu.add(ajudaSobreAutorItem = new JMenuItem("Sobre o Autor"));
        ajudaMenu.add(ajudaSobreAplicacaoItem = new JMenuItem("Sobre a Aplicação"));
        
        // Adicionar eventos aos menus
        novoPecaItem.addActionListener(this);
        alterarPecaItem.addActionListener(this);
        eliminarPecaItem.addActionListener(this);
        listarPecasItem.addActionListener(this);
        novaVendaItem.addActionListener(this);
        listarVendasItem.addActionListener(this);
        sairItem.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == novoPecaItem) {
            new PecaVisao();
        } else if (evt.getSource() == alterarPecaItem) {
            // Implementar a lógica de alteração de peça
            JOptionPane.showMessageDialog(this, "Funcionalidade de alterar peça não implementada ainda.");
        } else if (evt.getSource() == eliminarPecaItem) {
            // Implementar a lógica de eliminação de peça
            JOptionPane.showMessageDialog(this, "Funcionalidade de eliminar peça não implementada ainda.");
        } else if (evt.getSource() == listarPecasItem) {
            // Listar as peças carregadas do arquivo
            List<PecaModelo> pecas = Persistencia.carregarPecas();
            StringBuilder pecasListadas = new StringBuilder("Pecas Disponíveis:\n");
            for (PecaModelo peca : pecas) {
                pecasListadas.append(peca.getId()).append(" - ").append(peca.getNome()).append(" - ").append(peca.getPreco()).append("\n");
            }
            JOptionPane.showMessageDialog(this, pecasListadas.toString());
        } else if (evt.getSource() == novaVendaItem) {
            new VendaVisao();
        } else if (evt.getSource() == listarVendasItem) {
            // Listar as vendas carregadas do arquivo
            List<VendaModelo> vendas = Persistencia.carregarVendas();
            StringBuilder vendasListadas = new StringBuilder("Vendas Realizadas:\n");
            for (VendaModelo venda : vendas) {
                vendasListadas.append("ID: ").append(venda.getId()).append(" - ")
                    .append(venda.getPeca().getNome()).append(" - Quantidade: ").append(venda.getQuantidadeVendida())
                    .append(" - Valor Total: ").append(venda.getValorTotal()).append("\n");
            }
            JOptionPane.showMessageDialog(this, vendasListadas.toString());
        } else if (evt.getSource() == sairItem) {
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(this, "Opção não implementada.");
        }
    }

    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
