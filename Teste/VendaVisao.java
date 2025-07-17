import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List; // Importação correta da interface List


public class VendaVisao extends JFrame implements ActionListener {

    private JComboBox<PecaModelo> pecaComboBox;
    private JTextField quantidadeField;
    private JButton venderButton;
    private List<PecaModelo> pecas;
    private List<VendaModelo> vendas;

    public VendaVisao() {
        setTitle("Registrar Venda");
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Peça:"));
        pecaComboBox = new JComboBox<>();
        pecas = Persistencia.carregarPecas();
        for (PecaModelo peca : pecas) {
            pecaComboBox.addItem(peca);
        }
        add(pecaComboBox);

        add(new JLabel("Quantidade:"));
        quantidadeField = new JTextField();
        add(quantidadeField);

        venderButton = new JButton("Vender");
        venderButton.addActionListener(this);
        add(venderButton);

        vendas = Persistencia.carregarVendas();

        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PecaModelo peca = (PecaModelo) pecaComboBox.getSelectedItem();
        int quantidade = Integer.parseInt(quantidadeField.getText());

        if (peca.getQuantidade() < quantidade) {
            JOptionPane.showMessageDialog(this, "Quantidade insuficiente no estoque!");
            return;
        }

        peca.setQuantidade(peca.getQuantidade() - quantidade);
        Persistencia.salvarPecas(pecas);

        double valorTotal = peca.getPreco() * quantidade;
        VendaModelo venda = new VendaModelo(vendas.size() + 1, peca, quantidade, valorTotal);
        vendas.add(venda);
        Persistencia.salvarVendas(vendas);

        JOptionPane.showMessageDialog(this, "Venda registrada com sucesso!");
    }

    public static void main(String[] args) {
        new VendaVisao();
    }
}
