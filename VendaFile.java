/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 2817
Ficheiro: VendaFile.java
Data: 19.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import SwingComponents.*;
import Calendario.*;

public class VendaFile extends ObjectsFile
{
    public VendaFile()
    {
        super("VendaFile.dat", new VendaModelo());
    }  

    public void salvarDados(VendaModelo modelo)
    {
        try
        {
            // colocar o file pointer no final do ficheiro
            stream.seek(stream.length());

            // escrever no modelo
            modelo.write(stream);

            incrementarProximoCodigo();
            JOptionPane.showMessageDialog(null,  "Dados Salvos com Sucessso");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao Salvar os Dados");
        }
    }

    public void alterarDados(VendaModelo modelo_novo)
	{
		VendaModelo modelo_antigo = new VendaModelo();
		
		try
		{
			stream.seek(4);
			
			for(int i = 0; i < getNregistos(); ++i)
			{
				modelo_antigo.read( stream );
				
				if (i == 0 && modelo_antigo.getId() == modelo_novo.getId())
				{
					stream.seek(4); 
					modelo_novo.write( stream );
					JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
					return;
				}	
				else
				{
					if (modelo_antigo.getId() + 1 == modelo_novo.getId())
					{
						modelo_novo.write( stream);
						return;
					}
							
				}			
			}			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

    public void eliminarDados(VendaModelo modelo_novo)
	{
		VendaModelo modelo_antigo = new VendaModelo();
		
		try
		{
			stream.seek(4);
			
			for(int i = 0; i < getNregistos(); ++i)
			{
				modelo_antigo.read( stream );
				
				if (i == 0 && modelo_antigo.getId() == modelo_novo.getId())
				{
					stream.seek(4); 
					modelo_novo.write( stream );
					JOptionPane.showMessageDialog(null, "Dados eliminados com sucesso!");
					return;
				}	
				else
				{
					if (modelo_antigo.getId() + 1 == modelo_novo.getId())
					{
						modelo_novo.write(stream);
						return;
					}							
				}			
			}			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

    public static void listarVendas()
    {
        VendaFile file = new VendaFile();
        VendaModelo modelo = new VendaModelo();

        // Cabeçalhos da tabela
        String[] colunas = {"Id", "Quantidade", "Preco", "Nome do Cliente", 
        "Telefone do Cliente", "Nome do Funcionario", "Tipo de Pagamento", 
        "Condicao de Venda", "Total de Venda", "Estado"};

        // lista para aramazenar temporariamente os dados
        java.util.List<Object[]>linhas = new java.util.ArrayList<>();

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getStatus() == true)
                {
                    Object[] linha = 
                    {
                        modelo.getId(),
                        modelo.getQuantidade(),
                        modelo.getPreco(),
                        modelo.getNomeCliente(),
                        modelo.getTelefoneCliente(),
                        modelo.getNomeFuncionario(),
                        modelo.getTipoPagamento(),
                        modelo.getCondicaoVenda(),
                        modelo.getTotalVenda(),
                        modelo.getStatus()
                    };
                    linhas.add(linha);
                }
            }

            Object[][] dados = new Object[linhas.size()][colunas.length];
            for (int i = 0; i < linhas.size(); i++) 
            {
                dados[i] = linhas.get(i);
            }

            JTable tabela = new JTable(dados, colunas);
            tabela.setFillsViewportHeight(true);

            // ESSENCIAL: desativa redimensiona
            // mento automático para permitir scroll horizontal
            tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            // Você pode definir larguras mínimas para cada coluna se quiser
            for (int i = 0; i < colunas.length; i++) {
                tabela.getColumnModel().getColumn(i).setPreferredWidth(150);
            }


            JScrollPane scroll = new JScrollPane(tabela,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            JDialog dialogo = new JDialog();
            dialogo.setTitle("Gestao de Pecas de Automoveis");
            dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialogo.setLayout(new BorderLayout());
            dialogo.add(scroll, BorderLayout.CENTER);
            dialogo.setSize(1000, 500); 
            dialogo.setLocationRelativeTo(null);
            dialogo.setVisible(true);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int pesquisarPorId(int idProcurado)
    {
        VendaFile file = new VendaFile();
        VendaModelo modelo = new VendaModelo();
        boolean encontrado = false;
        String dados = "Listagem de Dados do Ficheiro \n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getId() == idProcurado && modelo.getStatus() == true)
                {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    encontrado = true;
                    return 0;
                }
            }
            if(!encontrado)
            {
                JOptionPane.showMessageDialog(null, "Erro, id nao encontrado", 
                    "File Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return idProcurado;
    }

    public static void pesquisarPorNomeCliente(String nomeProcurado)
    {
        VendaFile file = new VendaFile();
        VendaModelo modelo = new VendaModelo();
        boolean encontrado = false;
        String dados = "Listagem de Dados do Ficheiro \n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getNomeCliente().equalsIgnoreCase(nomeProcurado) && modelo.getStatus() == true)
                {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    encontrado = true;
                    return;
                }
            }
            if(!encontrado)
            {
                JOptionPane.showMessageDialog(null, "Erro, nome do cliente nao encontrado", 
                "File Not Found", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // metodo de pesquisa para edicao
    public static VendaModelo getPesquisaPorId(int idProcurado)
    {
        VendaFile file = new VendaFile();
        VendaModelo modelo = new VendaModelo();
        boolean encontrado = false;

        String dados = "Listagem de Dados do Ficheiro \n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getId() == idProcurado && modelo.getStatus() == true)
                {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    encontrado = true;
                    return modelo;
                }
            }
            if(!encontrado)
            {
                JOptionPane.showMessageDialog(null, "Erro, id nao encontrado", 
                    "File Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return modelo;
    }

    // getPesquisarPorNome
    public static VendaModelo getPesquisarPorNomeCliente(String nomeProcurado)
    {
        VendaFile file = new VendaFile();
        VendaModelo modelo = new VendaModelo();
        boolean encontrado = false;
        String dados = "Listagem de Dados do Ficheiro \n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getNomeCliente().equalsIgnoreCase(nomeProcurado) && modelo.getStatus() == true)
                {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    encontrado = true;
                    return modelo;
                }
            }
            if(!encontrado)
            {
                JOptionPane.showMessageDialog(null, "Erro, nome do cliente nao encontrado", 
                "File Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return modelo;
    }

    
    public static StringVector getAllNomesClientes()
    {
        VendaFile file = new VendaFile();
        VendaModelo modelo = new VendaModelo();
        StringVector vetor = new StringVector();

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getStatus() == true)
                    vetor.add(modelo.getNomeCliente());
            }
            
            vetor.sort();    
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return vetor;
    }
}