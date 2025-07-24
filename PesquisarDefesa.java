/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 35217
Ficheiro: PesquisarDefesa.java
Data: 20.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class PesquisarDefesa extends JFrame
{
    private PainelCentro centro;
    private PainelSul sul;
    
    public PesquisarDefesa()
    {
        super("Pesquisa da Defesa");

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel
    {
        private JTextFieldData dataFundacaoJTF;
        private JComboBox conferenciaJCB, dioceseJCB, paroquiaJCB;
        private JRadioButton pesquisarConferencia, pesquisarDiocese, pesquisarParoquia, pesquisarData;
        private ButtonGroup grupo;

        public PainelCentro()
        {
            setLayout(new GridLayout(4 , 2));
            
            add(new JLabel("Escolha a Conferencia Procurada"));
            add(conferenciaJCB = new JComboBox(DefesaFile.getAllConferencia()));
            
            add(new JLabel("Escolha a Diocese Procurada"));
            add(dioceseJCB = new JComboBox(DefesaFile.getAllDiocese()));

            add(new JLabel("Escolha Paroquia Procurada"));
            add(paroquiaJCB = new JComboBox(DefesaFile.getAllParoquia()));

            add(new JLabel("Data de Fundacao:"));
            dataFundacaoJTF = new JTextFieldData("Data?");
            JPanel painelData = new JPanel(new GridLayout(1, 2));
            painelData.add(dataFundacaoJTF.getDTestField());
            painelData.add(dataFundacaoJTF.getDButton());
            add(painelData);
        }

        public String getConferenciaProcurada() 
        {
            return String.valueOf(conferenciaJCB.getSelectedItem());
        }

        public String getDioceseProcurada()
        {
            return String.valueOf(dioceseJCB.getSelectedItem());
        }

        public String getParoquiaProcurada()
        {
            return String.valueOf(paroquiaJCB.getSelectedItem());
        }

        public String getDataProcurada()
        {
            return dataFundacaoJTF.toString();
        }
    }

    class PainelSul extends JPanel implements ActionListener
    {
        private JButton pesquisarJB, cancelarJB;

        public PainelSul()
        {
            add(pesquisarJB = new JButton("Pesquisar", new ImageIcon("image/search32.PNG")));
            add(cancelarJB = new JButton("Cancelar", new ImageIcon("image/cancel24.PNG")));

            pesquisarJB.addActionListener(this);
            cancelarJB.addActionListener(this);
        }

        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == pesquisarJB)
            {    
                String paroquia = centro.getParoquiaProcurada();
                String dataFundacao = centro.dataFundacaoJTF.getDTestField().getText();
                DefesaFile.pesquisa(paroquia, dataFundacao);
            }
            else 
                dispose();
        }
    }
}
