/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 2817
Ficheiro: FornecedorVisao.java
Data: 16.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class FornecedorVisao extends JFrame 
{
    private PainelCentro centro;
    private PainelSul sul;
    private boolean editar;

    public FornecedorVisao(boolean alterar, FornecedorModelo modelo)
    {
        super("Fornecedor Visao");
        
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
        private JTextField idJTF, nomeJTF, telefoneJTF, emailJTF, contatoResponsavelJTF;
        private JComboBox nacionalidadeJCB, provinciaJCB, municipioJCB, comunaJCB;
        private JComboBoxTabela3_Tabela3 provinciaMuniComuna;
        private FornecedorFile file;

        // construtor sem parametros
        public PainelCentro()
        {
            setLayout(new GridLayout(9, 2));
            provinciaMuniComuna = new JComboBoxTabela3_Tabela3("Provincias.tab", "Municipios.tab", "Comunas.tab");
            file = new FornecedorFile();

            // 1º linha
            add(new JLabel("Id"));
            add(idJTF = new JTextField());
            idJTF.setText("000" + file.getProximoCodigo());
            idJTF.setFocusable(false);

            // 2º linha
            add(new JLabel("Nome"));
            add(nomeJTF = new JTextField());

            // 3º linha
            add(new JLabel("Telefone"));
            add(telefoneJTF = new JTextField());

            // 4º linha
            add(new JLabel("Email"));
            add(emailJTF = new JTextField());

            // 5º linha
            add(new JLabel("Contato Responsavel"));
            add(contatoResponsavelJTF = new JTextField());

            // 6º linha
            add(new JLabel("Nacionalidade"));
            add(nacionalidadeJCB = UInterfaceBox.createJComboBoxsTabela2("Nacionalidades.tab"));

            // 7º linha
            add(new JLabel("Provincia"));
            add(provinciaJCB = provinciaMuniComuna.getComboBoxFather());

            // 8º linha
            add(new JLabel("Municipio"));
            add(municipioJCB = provinciaMuniComuna.getComboBoxSun());

            // 9º linha
            add(new JLabel("Comuna"));
            add(comunaJCB = provinciaMuniComuna.getComboBoxNeto());
        }

        // construtor com parametros
        public PainelCentro(FornecedorModelo modelo)
        {
            setLayout(new GridLayout(9, 2));
            provinciaMuniComuna = new JComboBoxTabela3_Tabela3("Provincias.tab", "Municipios.tab", "Comunas.tab");
            file = new FornecedorFile();

            // 1º linha
            add(new JLabel("Id"));
            add(idJTF = new JTextField());
            idJTF.setText("000" + file.getProximoCodigo());
            idJTF.setText("" + modelo.getId());
            idJTF.setFocusable(false);

            // 2º linha
            add(new JLabel("Nome"));
            add(nomeJTF = new JTextField());
            nomeJTF.setText(modelo.getNome());

            // 3º linha
            add(new JLabel("Telefone"));
            add(telefoneJTF = new JTextField());
            telefoneJTF.setText(modelo.getTelefone());

            // 4º linha
            add(new JLabel("Email"));
            add(emailJTF = new JTextField());
            emailJTF.setText(modelo.getEmail());

            // 5º linha
            add(new JLabel("Contato Responsavel"));
            add(contatoResponsavelJTF = new JTextField());
            contatoResponsavelJTF.setText(modelo.getContatoResponsavel());

            // 6º linha
            add(new JLabel("Nacionalidade"));
            add(nacionalidadeJCB = UInterfaceBox.createJComboBoxsTabela2("Nacionalidades.tab"));
            nacionalidadeJCB.setSelectedItem(modelo.getNacionalidade());

            // 7º linha
            add(new JLabel("Provincia"));
            add(provinciaJCB = provinciaMuniComuna.getComboBoxFather());
            provinciaJCB.setSelectedItem(modelo.getProvincia());

            // 8º linha
            add(new JLabel("Municipio"));
            add(municipioJCB = provinciaMuniComuna.getComboBoxSun());
            municipioJCB.setSelectedItem(modelo.getMunicipio());

            // 9º linha
            add(new JLabel("Comuna"));
            add(comunaJCB = provinciaMuniComuna.getComboBoxNeto());
            comunaJCB.setSelectedItem(modelo.getComuna());
        }

        // metodos getters
        public int getId()
        {
            return Integer.parseInt(idJTF.getText().trim());
        }

        public String getNome()
        {
            return nomeJTF.getText().trim();
        }

        public String getTelefone()
        {
            return telefoneJTF.getText().trim();
        }

        public String getEmail()
        {
            return emailJTF.getText().trim();
        }

        public String getContatoResponsavel()
        {
            return  contatoResponsavelJTF.getText().trim();
        }

        public String getNacionalidade()
        {
            return String.valueOf(nacionalidadeJCB.getSelectedItem());
        }

        public String getProvincia()
        {
            return String.valueOf(provinciaJCB.getSelectedItem());
        }

        public String getMunicipio()
        {
            return String.valueOf(municipioJCB.getSelectedItem());
        }

        public String getComuna()
        {
            return String.valueOf(comunaJCB.getSelectedItem());
        }

        // metodos setters
        public void setId(int id)
        {
            idJTF.setText("" + id);
        }

        public void setNome(String nome)
        {
            nomeJTF.setText(nome);
        }

        public void setTelefone(String telefone)
        {
            telefoneJTF.setText(telefone);
        }

        public void setEmail(String email)
        {
            emailJTF.setText(email);
        }

        public void setContatoReponsavel(String contatoResponsavel)
        {
            contatoResponsavelJTF.setText(contatoResponsavel);
        }

        public void setNacionalidade(String nacionalidade)
        {
            nacionalidadeJCB.setSelectedItem(nacionalidade);
        }

        public void setProvincia(String provincia)
        {
            provinciaJCB.setSelectedItem(provincia);
        }

        public void setMunicipio(String municipio)
        {
            municipioJCB.setSelectedItem(municipio);
        }

        public void setComuna(String comuna)
        {
            comunaJCB.setSelectedItem(comuna);
        }

        // metod salvar
        public void salvar()
        {
            FornecedorModelo modelo = new FornecedorModelo(
            getId(),
            getNome(),
            getTelefone(),
            getEmail(),
            getContatoResponsavel(),
            getNacionalidade(),
            getProvincia(),
            getMunicipio(),
            getComuna(),
            true);

            JOptionPane.showMessageDialog(null, modelo.toString());
            modelo.salvar();
            dispose();
        }

        // metodo alterar
        public void alterar()
        {
            FornecedorModelo modelo = new FornecedorModelo(
            getId(),
            getNome(),
            getTelefone(),
            getEmail(),
            getContatoResponsavel(),
            getNacionalidade(),
            getProvincia(),
            getMunicipio(),
            getComuna(),
            true);

            JOptionPane.showMessageDialog(null, modelo.toString());
            modelo.salvarDados();
            dispose();
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
        new FornecedorVisao(false, new FornecedorModelo());
    }
}