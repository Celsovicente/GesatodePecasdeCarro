/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 2817
Ficheiro: ApresentacaoVisao.java
Data: 17.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import SwingComponents.*;
import Calendario.*;

public class ApresentacaoVisao extends JFrame 
{
    
    private PainelCentro centro;
    private PainelSul sul;

    public ApresentacaoVisao()
    {
        super("Tela de Boas Vindas");

        JPanel painelNorte = new JPanel();
        ImageIcon iconOriginal = new ImageIcon("image/apresentacao.png");
        Image imagemRedimensionada = iconOriginal.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);

        JLabel lbImagem = new JLabel(iconRedimensionado);

        painelNorte.add(lbImagem);
        getContentPane().add(painelNorte, BorderLayout.NORTH);
        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
        
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel implements ActionListener
    {
            JTextArea areaPrincipal;
            JCheckBox concordarJCB;
            public PainelCentro()
            {
                setLayout(new GridLayout(2, 1));
                
                add(new JScrollPane(areaPrincipal = new JTextArea(80 , 60)));
                areaPrincipal.setFocusable(false);
                areaPrincipal.setText(
                "\tTema: Gestao de Pecas de Automoveis\n\n" +
                "Objetivo\n" +
                "Este projeto tem como objetivo gerir o stock de pecas automoveis, incluindo\n" +
                "o registo de fornecedores, vendas e consulta da localizacao das pecas dentro do armazem.\n\n" +
                "Desenvolvido no ambito da cadeira de Fundamentos de Programacao II,\n" +
                "no curso de Engenharia Informatica da UCAN, este sistema e de uso exclusivo dos Recursos Humanos.\n\n" +
                "Foi concebido para facilitar o controlo e a gestao das informacoes de pecas no estoque,\n" +
                "permitindo localizar os dados de forma rapida, precisa e segura.\n\n" +
                "Desenvolvido por Emanuel F. Shekina, estudante do 1º ano, ID: 2817.\n\n" +
                "Se concorda com os termos e condicoes, clique em Concordar para continuar."
            );


                add(concordarJCB = new JCheckBox("Concordo com os termos a seguir"));

                concordarJCB.addActionListener(this);
            }

            public void actionPerformed(ActionEvent event)
            {
                if(event.getSource() == concordarJCB)
                    if(concordarJCB.isSelected())
                        sul.ativarBotao(true);
                    else
                        sul.ativarBotao(false);
            }
    }

    
    class PainelSul extends JPanel implements ActionListener
    {
        JButton entrarJB, sairJB;
        public PainelSul()
        {
            add(entrarJB = new JButton("Entrar", new ImageIcon("image/next24.png")));
            add(sairJB = new JButton("Sair", new ImageIcon("image/logout24.png")));

            ativarBotao( false );

            entrarJB.addActionListener(this);
            sairJB.addActionListener(this);
        }

        public void ativarBotao(boolean status)
        {
            entrarJB.setEnabled(status);
        }

        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == entrarJB)
            {
                dispose();
                new LoginVisao();
            }
            else
                dispose();
        }
    }

    public static void main(String[] args)
    {
        Vector_Tabelas.inic();
        new ApresentacaoVisao();       
    }
}