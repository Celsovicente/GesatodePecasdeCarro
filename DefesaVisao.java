/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 35217
Ficheiro: DefesaVisao.java
Data: 16.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class DefesaVisao extends JFrame 
{
    private PainelCentro centro;
    private PainelSul sul;

    public DefesaVisao()
    {
        super("Registrar Defesa");
        

        definirTema();
       
        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel
    {
        private JTextField idJTF, nomeJTF, telefoneJTF, emailJTF, contatoResponsavelJTF, dataFundacaoJTF;
        private JComboBox nacionalidadeJCB, provinciaJCB, municipioJCB, comunaJCB, 
        conferenciaJCB, dioceseJCB, paroquiaJCB;
        private JComboBoxTabela3_Tabela3 provinciaMuniComuna, conferenciaDiocParoquia;
        private JTextFieldData txtData;
        private DefesaFile file;

        public PainelCentro()
        {
            setLayout(new GridLayout(13, 2));
            provinciaMuniComuna = new JComboBoxTabela3_Tabela3("Provincias.tab", "Municipios.tab", "Comunas.tab");
            conferenciaDiocParoquia = new JComboBoxTabela3_Tabela3("Conferencia.tab", "Diocese.tab", "Paroquia.tab");
            file = new DefesaFile();

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

            // 10º linha
            add(new JLabel("Conferencia"));
            add(conferenciaJCB = conferenciaDiocParoquia.getComboBoxFather());

            // 11ºlinha
            add(new JLabel("Diocese"));
            add(dioceseJCB = conferenciaDiocParoquia.getComboBoxSun());

            // 12º linha
            add(new JLabel("Paroquia"));
            add(paroquiaJCB = conferenciaDiocParoquia.getComboBoxNeto());

            // 13º linha
            add(new JLabel("Data de Fundacao"));
            JPanel painelData = new JPanel( new GridLayout(1, 1) );
			txtData = new JTextFieldData("Data ?");
			painelData.add( txtData.getDTestField());
			painelData.add( txtData.getDButton());
			add(painelData);
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

        public String getConferencia()
        {
            return String.valueOf(conferenciaJCB.getSelectedItem());
        }

        public String getDiocese()
        {
            return String.valueOf(dioceseJCB.getSelectedItem());
        }

        public String getParoquia()
        {
            return String.valueOf(paroquiaJCB.getSelectedItem());
        }

        public String getDataFundacao()
        {
            return txtData.getDTestField().getText();
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

        public void setConferencia(String conferencia)
        {
            conferenciaJCB.setSelectedItem(conferencia);
        }

        public void setDiocese(String diocese)
        {
            dioceseJCB.setSelectedItem(diocese);
        }

        public void setParoquia(String paroquia)
        {
            paroquiaJCB.setSelectedItem(paroquia);
        }

        public void setDataFundacao(String data)
        {
            txtData.getDTestField().setText(data);
        }
        // metod salvar
        public void salvar()
        {
            DefesaModelo modelo = new DefesaModelo(
            getId(),
            getNome(),
            getTelefone(),
            getEmail(),
            getContatoResponsavel(),
            getNacionalidade(),
            getProvincia(),
            getMunicipio(),
            getComuna(),
            getConferencia(),
            getDiocese(),
            getParoquia(),
            getDataFundacao(),
            true);

            JOptionPane.showMessageDialog(null, modelo.toString());
            modelo.salvar();
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
                centro.salvar();
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
        new DefesaVisao();
    }
}