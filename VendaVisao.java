/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 35217
Ficheiro: VendaVisao.java
Data: 20.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;


public class VendaVisao extends JFrame 
{
    private PainelCentro centro;
    private PainelSul sul;
    private boolean editar;

    public VendaVisao(boolean alterar, VendaModelo modelo)
    {
        super("Registrar Venda");
        
        editar = alterar;

        definirTema();
        if(!alterar)
        {
            getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        }
        else
            getContentPane().add(centro = new PainelCentro(modelo), BorderLayout.CENTER);
         getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel
    {
        private JTextField idJTF, quantidadeJTF, nomeClienteJTF, telefoneClienteJTF, dataVendaJTF,
        precoUnitarioJTF, totalvendaJTF;
        private JComboBox tipoPagamentoJCB, nomeFuncionarioJCB, condicaoVendaJCB;
        private JTextFieldData txtData;
        private VendaFile file;

        // construtor sem parametros
        public PainelCentro()
        {
            setLayout(new GridLayout(10, 2));
            file = new VendaFile();

            // 1º linha
            add(new JLabel("Id"));
            add(idJTF = new JTextField());
            idJTF.setText("000" + file.getProximoCodigo());
            idJTF.setFocusable(false);

            // 2º linha
            add(new JLabel("Quantidade"));
            add(quantidadeJTF = new JTextField());
            
            // eventos do teclado para capturar os dados diretamente
            quantidadeJTF.getDocument().addDocumentListener(new DocumentListener() {
                public void insertUpdate(DocumentEvent e) { calcular(); }
                public void removeUpdate(DocumentEvent e) { calcular(); }
                public void changedUpdate(DocumentEvent e) { calcular(); }
            });

            // 3º linha
            add(new JLabel("Preco"));
            add(precoUnitarioJTF = new JTextField());
            
            // capturar os eventos de teclado diretamente
            precoUnitarioJTF.getDocument().addDocumentListener(new DocumentListener() {
                public void insertUpdate(DocumentEvent e) { calcular(); }
                public void removeUpdate(DocumentEvent e) { calcular(); }
                public void changedUpdate(DocumentEvent e) { calcular(); }
            });

            // 4º linha
            add(new JLabel("Nome do Cliente"));
            add(nomeClienteJTF = new JTextField());

            // 5º linha
            add(new JLabel("Telefone do Cliente"));
            add(telefoneClienteJTF = new JTextField());

            // 6º linha
            add(new JLabel("Nome do Funcionario"));
            add(nomeFuncionarioJCB = UInterfaceBox.createJComboBoxsTabela2("NomeFuncionario.tab"));

            // 7º linha
            add(new JLabel("Tipo de Pagamento"));
            add(tipoPagamentoJCB = UInterfaceBox.createJComboBoxsTabela2("TiposPagamento.tab"));

            // 8º linha
            add(new JLabel("Condicao de Venda"));
            add(condicaoVendaJCB = UInterfaceBox.createJComboBoxsTabela2("CondicoesVenda.tab"));

            // 9º linha
            add(new JLabel("Data da Venda"));
            JPanel painelData = new JPanel( new GridLayout(1, 1) );
			txtData = new JTextFieldData("Data ?");
			painelData.add( txtData.getDTestField());
			painelData.add( txtData.getDButton());
			add(painelData);

            // 10º linha
            add(new JLabel("Total de Venda"));
            add(totalvendaJTF = new JTextField());
            totalvendaJTF.setFocusable(false);
        }

        // construtor com parametros
        public PainelCentro(VendaModelo modelo)
        {
            setLayout(new GridLayout(10, 2));
            file = new VendaFile();

            // 1º linha
            add(new JLabel("Id"));
            add(idJTF = new JTextField());
            idJTF.setText("000" + file.getProximoCodigo());
            idJTF.setText("" + modelo.getId());
            idJTF.setFocusable(false);

            // 2º linha
            add(new JLabel("Quantidade"));
            add(quantidadeJTF = new JTextField());
            quantidadeJTF.setText("" + modelo.getQuantidade());

            // eventos do teclado para capturar os dados diretamente
            quantidadeJTF.getDocument().addDocumentListener(new DocumentListener() {
                public void insertUpdate(DocumentEvent e) { calcular(); }
                public void removeUpdate(DocumentEvent e) { calcular(); }
                public void changedUpdate(DocumentEvent e) { calcular(); }
            });

            // 3º linha
            add(new JLabel("Preco"));
            add(precoUnitarioJTF = new JTextField());
            precoUnitarioJTF.setText("" + modelo.getPreco());

            precoUnitarioJTF.getDocument().addDocumentListener(new DocumentListener() {
                public void insertUpdate(DocumentEvent e) { calcular(); }
                public void removeUpdate(DocumentEvent e) { calcular(); }
                public void changedUpdate(DocumentEvent e) { calcular(); }
            });


            // 4º linha
            add(new JLabel("Nome do Cliente"));
            add(nomeClienteJTF = new JTextField());
            nomeClienteJTF.setText(modelo.getNomeCliente());

            // 5º linha
            add(new JLabel("Telefone do Cliente"));
            add(telefoneClienteJTF = new JTextField());
            telefoneClienteJTF.setText(modelo.getTelefoneCliente());

            // 6º linha
            add(new JLabel("Nome do Funcionario"));
            add(nomeFuncionarioJCB = UInterfaceBox.createJComboBoxsTabela2("NomeFuncionario.tab"));
            nomeFuncionarioJCB.setSelectedItem(modelo.getNomeFuncionario());

            // 7º linha
            add(new JLabel("Tipo de Pagamento"));
            add(tipoPagamentoJCB = UInterfaceBox.createJComboBoxsTabela2("TiposPagamento.tab"));
            tipoPagamentoJCB.setSelectedItem(modelo.getTipoPagamento());

            // 8º linha
            add(new JLabel("Condicao de Venda"));
            add(condicaoVendaJCB = UInterfaceBox.createJComboBoxsTabela2("CondicoesVenda.tab"));
            condicaoVendaJCB.setSelectedItem(modelo.getCondicaoVenda());

            // 9º linha
            add(new JLabel("Data da Venda"));
            JPanel painelData = new JPanel( new GridLayout(1, 1) );
			txtData = new JTextFieldData("Data ?");
			painelData.add( txtData.getDTestField());
			painelData.add( txtData.getDButton());
			add(painelData);
            txtData.getDTestField().setText(modelo.getDataVenda());

            // 10º linha
            add(new JLabel("Total de Venda"));
            add(totalvendaJTF = new JTextField());
            totalvendaJTF.setFocusable(false);
            totalvendaJTF.setText("" + modelo.getTotalVenda());
        }

        // metodos getters
        public int getId()
        {
            return Integer.parseInt(idJTF.getText().trim());
        }

        public int getQuantidade()
        {
            return Integer.parseInt(quantidadeJTF.getText().trim());
        }

       public float getPreco()
       {
            return Float.parseFloat(precoUnitarioJTF.getText().trim().replace(",", "."));
       }

        public String getNomeCliente()
        {
            return nomeClienteJTF.getText().trim();
        }

        public String getTelefoneCliente()
        {
            return telefoneClienteJTF.getText().trim();
        }

        public String getNomeFuncionario()
        {
            return String.valueOf(nomeFuncionarioJCB.getSelectedItem());
        }

        public String getTipoPagamento()
        {
            return String.valueOf(tipoPagamentoJCB.getSelectedItem());
        }

        public String getCondicaoVenda()
        {
            return String.valueOf(condicaoVendaJCB.getSelectedItem());
        }

        public String getDataVenda()
        {
            return txtData.getDTestField().getText();
        }

        public float getTotalVenda()
        {
            return Float.parseFloat(totalvendaJTF.getText().trim().replace(",", "."));
        }

        // metodos setters
        public void setId(int id)
        {
            idJTF.setText("" + id);
        }

        public void setQuantidade(int quantidade)
        {
            quantidadeJTF.setText("" + quantidade);
        }

        public void setPrco(float preco)
        {
            precoUnitarioJTF.setText("" + preco);
        }

        public void setNomeCliente(String nomeCliente)
        {
            nomeClienteJTF.setText(nomeCliente);
        }

        public void setTelefoneCliente(String telefoneCliente)
        {
            telefoneClienteJTF.setText(telefoneCliente);
        }

        public void setNomeFuncionario(String nomeFuncionario)
        {
            nomeFuncionarioJCB.setSelectedItem(nomeFuncionario);
        }

        public void setTipoPagamento(String tipoPagamento)
        {
            tipoPagamentoJCB.setSelectedItem(tipoPagamento);
        }

        public void setCondicaoVenda(String condicaoVenda)
        {
            condicaoVendaJCB.setSelectedItem(condicaoVenda);
        }

        public void setDataVenda(String dataVenda)
        {
            txtData.getDTestField().setText(dataVenda);
        }

        public void setTotalVenda(float totalVenda)
        {
            totalvendaJTF.setText("" + totalVenda);
        }

        // metodo para validar os campos
        public boolean validar()
        {
            if(quantidadeJTF.getText().trim().isEmpty() || precoUnitarioJTF.getText().trim().isEmpty() ||
            nomeClienteJTF.getText().trim().isEmpty() || telefoneClienteJTF.getText().trim().isEmpty() ||
            txtData.getDTestField().getText().trim().isEmpty() || nomeFuncionarioJCB.getSelectedItem() == null ||
            tipoPagamentoJCB.getSelectedItem() == null || condicaoVendaJCB.getSelectedItem() == null) 
            {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatorios.", 
                "Campos Vazios", JOptionPane.ERROR_MESSAGE);
                     return false; 
            }
            try 
            {
                Integer.parseInt(quantidadeJTF.getText().trim());
                Float.parseFloat(precoUnitarioJTF.getText().trim());
            } 
            catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(null, "Quantidade e Preço devem ser numéricos válidos.",
                "Erro de Formato", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }

        // metodo para calcular o total de vendas
        public void calcular()
        {
            String qtidadeStr = quantidadeJTF.getText().trim();
            String precoStr = precoUnitarioJTF.getText().trim().replace(",", ".");

            if (!qtidadeStr.isEmpty() && !precoStr.isEmpty()) {
                try {
                    int quantidade = Integer.parseInt(qtidadeStr);
                    float preco = Float.parseFloat(precoStr);
                    float total = quantidade * preco;

                    // Garante que sempre apareça com ponto decimal
                    totalvendaJTF.setText(String.format("%.2f", total));
                } catch(NumberFormatException e) {
                    totalvendaJTF.setText("");
                }
            } else {
                totalvendaJTF.setText("");
            }
        }


        // metod salvar
        public void salvar()
        {
            if(validar())
            {
                VendaModelo modelo = new VendaModelo(
                getId(),
                getQuantidade(),
                getPreco(), 
                getNomeCliente(),
                getTelefoneCliente(),
                getNomeFuncionario(),
                getTipoPagamento(),
                getCondicaoVenda(),
                getDataVenda(),
                getTotalVenda(),
                true);

                JOptionPane.showMessageDialog(null, modelo.toString());
                modelo.salvar();
                dispose();
            }
            else
                return;
        }

        // metodo alterar
        public void alterar()
        {
            if(validar())
            {
                VendaModelo modelo = new VendaModelo(
                getId(),
                getQuantidade(),
                getPreco(), 
                getNomeCliente(),
                getTelefoneCliente(),
                getNomeFuncionario(),
                getTipoPagamento(),
                getCondicaoVenda(),
                getDataVenda(),
                getTotalVenda(),
                true);

                JOptionPane.showMessageDialog(null, modelo.toString());
                modelo.salvarDados();
                dispose();
            }
            else 
                return;
        }
    }

    class PainelSul extends JPanel implements ActionListener
    {
        private JButton salvarJBT, cancelarJBT;
        
        public PainelSul()
        {
           setLayout(new FlowLayout());

            add(salvarJBT = new JButton("Salvar", new ImageIcon("image/save24.png")));
            add(cancelarJBT = new JButton("Cancelar", new ImageIcon("image/cancel24.png")));

            salvarJBT.setBackground(Color.GREEN);
            cancelarJBT.setBackground(Color.RED);

            salvarJBT.setForeground(Color.WHITE);
            cancelarJBT.setForeground(Color.WHITE);
            
            salvarJBT.addActionListener(this);
            cancelarJBT.addActionListener(this);
        }

        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == salvarJBT)
            {
                if(editar)
                    centro.alterar();
                else    
                    centro.salvar();
            }
            else
                dispose();
        }
    }

    public void definirTema() 
    {
        try 
        {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
                {
                    if ("Nimbus".equals(info.getName())) 
                    {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) 
        {
        }
    }

    public static void main(String[] args)
    {
        Vector_Tabelas.inic();
        new VendaVisao(false, new VendaModelo());
    }
}