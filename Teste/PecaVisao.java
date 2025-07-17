import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List; // Importação correta da interface List


public class PecaVisao extends JFrame implements ActionListener {

    private JTextField nomeField, precoField, quantidadeField;
    private JButton salvarButton;
    private List<PecaModelo> pecas;

    public PecaVisao() {
        setTitle("Cadastro de Peça");
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Preço:"));
        precoField = new JTextField();
        add(precoField);

        add(new JLabel("Quantidade:"));
        quantidadeField = new JTextField();
        add(quantidadeField);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(this);
        add(salvarButton);

        pecas = Persistencia.carregarPecas();

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = nomeField.getText();
        double preco = Double.parseDouble(precoField.getText());
        int quantidade = Integer.parseInt(quantidadeField.getText());

        PecaModelo peca = new PecaModelo(pecas.size() + 1, nome, preco, quantidade);
        pecas.add(peca);
        Persistencia.salvarPecas(pecas);

        JOptionPane.showMessageDialog(this, "Peça salva com sucesso!");
        nomeField.setText("");
        precoField.setText("");
        quantidadeField.setText("");
    }

    public static void main(String[] args) {
        new PecaVisao();
    }
}
