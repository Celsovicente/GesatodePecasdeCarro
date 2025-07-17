/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 2817
Ficheiro: PecaVisao.java
Data: 16.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class PecaVisao extends JFrame 
{
    private PainelCentro centro;
    private PainelSul sul;
    private boolean editar;

    public PecaVisao(boolean alterar, PecaModelo modelo)
    {
        super("Peca Visao");
        
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
        private JTextField idJTF, nomeJTF, referenciaJTF, precoJTF, quantidadeJTF;
        private JComboBox estadoJCB, categoriaJCB, marcaAutomovelJCB, modeloAutomovelJCB, localizacaoJCB, 
        disponibilidadeJCB;
        private String[] arrayDis = {"Disponivel", "Indisponivel", "Esgotada"}; 
        private JComboBoxTabela3_Tabela3 categoriaMarcaModelo;
        private PecaFile file;

        // construtor sem parametros
        public PainelCentro()
        {
            setLayout(new GridLayout(11, 2));
            categoriaMarcaModelo = new JComboBoxTabela3_Tabela3("CategoriaPeca.tab", "MarcasAutomoveis.tab", "ModelosAutomoveis.tab");
            file = new PecaFile();

            // 1º linha
            add(new JLabel("Id"));
            add(idJTF = new JTextField());
            idJTF.setText("000" + file.getProximoCodigo());
            idJTF.setFocusable(false);

            // 2º linha
            add(new JLabel("Nome"));
            add(nomeJTF = new JTextField());

            // 3º linha
            add(new JLabel("Referencia"));
            add(referenciaJTF = new JTextField());

            // 4º linha
            add(new JLabel("Estado"));
            add(estadoJCB = UInterfaceBox.createJComboBoxsTabela2("EstadoPeca.tab "));

            // 5º linha
            add(new JLabel("Categoria"));
            add(categoriaJCB = categoriaMarcaModelo.getComboBoxFather());
            
            // 6º linha
            add(new JLabel("Marca de Automovel"));
            add(marcaAutomovelJCB = categoriaMarcaModelo.getComboBoxSun());

            // 7º linha
            add(new JLabel("Modelo de Automovel"));
            add(modeloAutomovelJCB = categoriaMarcaModelo.getComboBoxNeto());

            // 8º linha
            add(new JLabel("Localizacao"));
            add(localizacaoJCB = UInterfaceBox.createJComboBoxsTabela2("Localizacao.tab"));

            // 9º linha
            add(new JLabel("Preco"));
            add(precoJTF = new JTextField());

            // 10º linha
            add(new JLabel("Quantidade"));
            add(quantidadeJTF = new JTextField());

            // 11º linha
            add(new JLabel("Disponibilidade"));
            add(disponibilidadeJCB = new JComboBox(arrayDis));
        }

        // construtor com parametros
        public PainelCentro(PecaModelo modelo)
        {
            setLayout(new GridLayout(11, 2));
            categoriaMarcaModelo = new JComboBoxTabela3_Tabela3("CategoriaPeca.tab", "MarcasAutomoveis.tab", "ModelosAutomoveis.tab");
            file = new PecaFile();

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
            add(new JLabel("Referencia"));
            add(referenciaJTF = new JTextField());
            referenciaJTF.setText(modelo.getReferencia());

            // 4º linha
            add(new JLabel("Estado"));
            add(estadoJCB = UInterfaceBox.createJComboBoxsTabela2("EstadoPeca.tab "));
            estadoJCB.setSelectedItem(modelo.getEstado());

            // 5º linha
            add(new JLabel("Categoria"));
            add(categoriaJCB = categoriaMarcaModelo.getComboBoxFather());
            categoriaJCB.setSelectedItem(modelo.getCategoria());
            
            // 6º linha
            add(new JLabel("Marca de Automovel"));
            add(marcaAutomovelJCB = categoriaMarcaModelo.getComboBoxSun());
            marcaAutomovelJCB.setSelectedItem(modelo.getMarcaAutomovel());

            // 7º linha
            add(new JLabel("Modelo de Automovel"));
            add(modeloAutomovelJCB = categoriaMarcaModelo.getComboBoxNeto());
            modeloAutomovelJCB.setSelectedItem(modelo.getModeloAutomovel());

            // 8º linha
            add(new JLabel("Localizacao"));
            add(localizacaoJCB = UInterfaceBox.createJComboBoxsTabela2("Localizacao.tab"));
            localizacaoJCB.setSelectedItem(modelo.getLocalizacao());

            // 9º linha
            add(new JLabel("Preco"));
            add(precoJTF = new JTextField());
            precoJTF.setText("" + modelo.getPreco());

            // 10º linha
            add(new JLabel("Quantidade"));
            add(quantidadeJTF = new JTextField());
            quantidadeJTF.setText("" + modelo.getQuantidade());

            // 11º linha
            add(new JLabel("Disponibilidade"));
            add(disponibilidadeJCB = new JComboBox(arrayDis));
            disponibilidadeJCB.setSelectedItem(modelo.getDisponibilidade());
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

        public String getReferencia()
        {
            return referenciaJTF.getText().trim();
        }

        public String getCategoria()
        {
            return String.valueOf(categoriaJCB.getSelectedItem());
        }

        public String getEstado()
        {
            return  String.valueOf(estadoJCB.getSelectedItem());
        }

        public String getMarcaAutomovel()
        {
            return String.valueOf(marcaAutomovelJCB.getSelectedItem());
        }

        public String getModeloAutomovel()
        {
            return String.valueOf(modeloAutomovelJCB.getSelectedItem());
        }

        public String getLocalizacao()
        {
            return String.valueOf(localizacaoJCB.getSelectedItem());
        }
        
        public float getPreco()
        {
            return Float.parseFloat(precoJTF.getText().trim());
        }

        public int getQuantidade()
        {
            return Integer.parseInt(quantidadeJTF.getText().trim());
        }

        public String getDisponibilidade()
        {
            return String.valueOf(disponibilidadeJCB.getSelectedItem());
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

        public void setReferencia(String referencia)
        {
            referenciaJTF.setText(referencia);
        }

        public void setCategoria(String categoria)
        {
            categoriaJCB.setSelectedItem(categoria);
        }

        public void setEstado(String estado)
        {
            estadoJCB.setSelectedItem(estado);
        }

        public void setMarcaAutomovel(String marcaAutomovel)
        {
            marcaAutomovelJCB.setSelectedItem(marcaAutomovel);
        }

        public void setModeloAutomovel(String modeloAutomovel)
        {
            modeloAutomovelJCB.setSelectedItem(modeloAutomovel);
        }

        public void setLocalizacao(String localizacao)
        {
            localizacaoJCB.setSelectedItem(localizacao);
        }

        public void setPreco(float preco)
        {
            precoJTF.setText("" + preco);
        }

        public void setQuantidade(int quantidade)
        {
            quantidadeJTF.setText("" + quantidade);
        }

        public void setDisponibilidade(String disponibilidade)
        {
            disponibilidadeJCB.setSelectedItem(disponibilidade);
        }

        // metod salvar
        public void salvar()
        {
            PecaModelo modelo = new PecaModelo(
            getId(),
            getNome(),
            getReferencia(),
            getCategoria(),
            getEstado(),
            getMarcaAutomovel(),
            getModeloAutomovel(),
            getLocalizacao(), 
            getPreco(),
            getQuantidade(),
            getDisponibilidade(),
            true);

            JOptionPane.showMessageDialog(null, modelo.toString());
            modelo.salvar();
            dispose();
        }

        // metodo alterar
        public void alterar()
        {
            PecaModelo modelo = new PecaModelo(
            getId(),
            getNome(),
            getReferencia(),
            getCategoria(),
            getEstado(),
            getMarcaAutomovel(),
            getModeloAutomovel(),
            getLocalizacao(), 
            getPreco(),
            getQuantidade(),
            getDisponibilidade(),
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
        new PecaVisao(false, new PecaModelo());
    }
}