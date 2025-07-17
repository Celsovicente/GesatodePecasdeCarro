import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FornecedorVisao extends JFrame implements ActionListener {
    private JTextField nomeField, enderecoField, telefoneField, emailField;
    private JButton salvarButton, cancelarButton;

    public FornecedorVisao() {
        setTitle("Cadastro de Fornecedor");
        setLayout(new GridLayout(6, 2));

        // Criando os componentes
        add(new JLabel("Nome:"));
        nomeField = new JTextField(20);
        add(nomeField);

        add(new JLabel("Endereço:"));
        enderecoField = new JTextField(20);
        add(enderecoField);

        add(new JLabel("Telefone:"));
        telefoneField = new JTextField(20);
        add(telefoneField);

        add(new JLabel("Email:"));
        emailField = new JTextField(20);
        add(emailField);

        // Botões
        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Cancelar");

        salvarButton.addActionListener(this);
        cancelarButton.addActionListener(this);

        add(salvarButton);
        add(cancelarButton);

        // Configurações do JFrame
        setSize(400, 250);
        setLocationRelativeTo(null);  // Alinhar ao centro
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == salvarButton) {
            // Coleta os dados do fornecedor
            String nome = nomeField.getText();
            String endereco = enderecoField.getText();
            String telefone = telefoneField.getText();
            String email = emailField.getText();

            // Cria um objeto de fornecedor (em um modelo ou banco de dados)
            FornecedorModelo fornecedor = new FornecedorModelo(0, nome, endereco, telefone, email);

            JOptionPane.showMessageDialog(this, "Fornecedor cadastrado com sucesso!", "Fornecedor", JOptionPane.INFORMATION_MESSAGE);
            dispose();  // Fecha a janela
        } else if (evt.getSource() == cancelarButton) {
            dispose();  // Fecha a janela
        }
    }

    public static void main(String[] args) {
        new FornecedorVisao();
    }
}
