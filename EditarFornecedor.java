/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 35217
Ficheiro: EditarFornecedor.java
Data: 16.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class EditarFornecedor extends JFrame
{
    private PainelCentro centro;
    private PainelSul sul;
    
    public EditarFornecedor()
    {
        super("Pesquisas do Fornecedor Para Edicao");

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel implements ActionListener
    {

        private JTextField  idJTF;
        private JComboBox nomeJCB;
        private JRadioButton pesquisarPorId, pesquisarPorNome;
        private ButtonGroup grupo;
    
        public PainelCentro()
        {
            setLayout(new GridLayout(3 , 2));
            
            grupo = new ButtonGroup();

            add(pesquisarPorId = new JRadioButton("Pesquisa Por Id"));
            add(pesquisarPorNome = new JRadioButton("Pesquisa Por Nome"));

            grupo.add(pesquisarPorId);
            grupo.add(pesquisarPorNome);
            
            add(new JLabel("Digite o Id Procurado"));
            add(idJTF = new JTextField());
            idJTF.setEnabled(false);
            
            add(new JLabel("Escolha o Nome Procurado"));
            add(nomeJCB = new JComboBox(FornecedorFile.getAllNomes()));
            nomeJCB.setEnabled(false);
            
            pesquisarPorId.addActionListener(this);
            pesquisarPorNome.addActionListener(this);
        }

        public int getIdProcurado() 
        {
            return Integer.parseInt(idJTF.getText().trim());
        }

        public String getNomeProcurado()
        {
            return String.valueOf(nomeJCB.getSelectedItem());
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
                nomeJCB.setEnabled(false);
            }
            else if(event.getSource() == pesquisarPorNome)
            {
                idJTF.setEnabled(false);
                nomeJCB.setEnabled(true);
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
                FornecedorModelo modelo; 
                if(centro.getTipoPesquisa() == 1)
                {    
                    modelo = FornecedorFile.getPesquisaPorId(centro.getIdProcurado());
                    new FornecedorVisao(true, modelo);
                }
                else if(centro.getTipoPesquisa() == 2)
                {
                    modelo = FornecedorFile.getPesquisarPorNome(centro.getNomeProcurado());
                    new FornecedorVisao(true, modelo);
                }
            }
            else 
                dispose();
        }
    }
}
