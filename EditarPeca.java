/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 35217
Ficheiro: EditarPeca.java
Data: 17.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class EditarPeca extends JFrame
{
    private PainelCentro centro;
    private PainelSul sul;
    
    public EditarPeca()
    {
        super("Pesquisas das Pecas Para Edicao");

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel implements ActionListener
    {

        private JTextField  idJTF;
        private JComboBox referenciaJCB;
        private JRadioButton pesquisarPorId, pesquisarPorRefencia;
        private ButtonGroup grupo;
    
        public PainelCentro()
        {
            setLayout(new GridLayout(3 , 2));
            
            grupo = new ButtonGroup();

            add(pesquisarPorId = new JRadioButton("Pesquisa Por Id"));
            add(pesquisarPorRefencia = new JRadioButton("Pesquisa Por Referencia"));

            grupo.add(pesquisarPorId);
            grupo.add(pesquisarPorRefencia);
            
            add(new JLabel("Digite o Id Procurado"));
            add(idJTF = new JTextField());
            idJTF.setEnabled(false);
            
            add(new JLabel("Escolha a Referencia Procurado"));
            add(referenciaJCB = new JComboBox(PecaFile.getAllReferencias()));
            referenciaJCB.setEnabled(false);
            
            pesquisarPorId.addActionListener(this);
            pesquisarPorRefencia.addActionListener(this);
        }

        public int getIdProcurado() 
        {
            return Integer.parseInt(idJTF.getText().trim());
        }

        public String getReferenciaProcurada()
        {
            return String.valueOf(referenciaJCB.getSelectedItem());
        }

        public int getTipoPesquisa()
        {
            if(pesquisarPorId.isSelected())
                return 1;
            else 
                return 2;
        }

        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == pesquisarPorId)
            {
                idJTF.setEnabled(true);
                referenciaJCB.setEnabled(false);
            }
            else if(event.getSource() == pesquisarPorRefencia)
            {
                idJTF.setEnabled(false);
                referenciaJCB.setEnabled(true);
            }
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
                PecaModelo modelo;
                if(centro.getTipoPesquisa() == 1)
                {
                    modelo = PecaFile.getPesquisaPorId(centro.getIdProcurado());
                    new PecaVisao(true, modelo);
                }
                else if(centro.getTipoPesquisa() == 2)
                {
                    modelo = PecaFile.getPesquisarPorRefencia(centro.getReferenciaProcurada());
                    new PecaVisao(true, modelo);
                }
            }
            else 
                dispose();
        }
    }
}
