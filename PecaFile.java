/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 35217
Ficheiro: PecaFile.java
Data: 17.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import SwingComponents.*;
import Calendario.*;

public class PecaFile extends ObjectsFile
{
    public PecaFile()
    {
        super("PecaFile.dat", new PecaModelo());
    }  

    public void salvarDados(PecaModelo modelo)
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

    public void alterarDados(PecaModelo modelo_novo)
	{
		PecaModelo modelo_antigo = new PecaModelo();
		
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

    public void eliminarDados(PecaModelo modelo_novo)
	{
		PecaModelo modelo_antigo = new PecaModelo();
		
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

    public static void listarPecas()
    {
        PecaFile file = new PecaFile();
        PecaModelo modelo = new PecaModelo();
        String dados = "Listagem dos Dados da Peca Modelo:\n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getStatus() == true)
                {
                    dados += "==============================\n";
                    dados += modelo.toString() + "\n\n";
                }
            }

            JTextArea area = new JTextArea(40 , 60);
            area.setText(dados);
            area.setFocusable(false);
            JOptionPane.showMessageDialog(null, new JScrollPane(area),
            "Gestao de Pecas de Automoveis", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static int pesquisarPorId(int idProcurado)
    {
        PecaFile file = new PecaFile();
        PecaModelo modelo = new PecaModelo();
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
                return 0;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return idProcurado;
    }

    public static void pesquisarPorRefencia(String referenciaProcurada)
    {
        PecaFile file = new PecaFile();
        PecaModelo modelo = new PecaModelo();
        boolean encontrado = false;
        String dados = "Listagem de Dados do Ficheiro \n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getReferencia().equalsIgnoreCase(referenciaProcurada) && modelo.getStatus() == true)
                {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    encontrado = true;
                    return;
                }
            }
            if(!encontrado)
            {
                JOptionPane.showMessageDialog(null, "Erro, referencia nao encontrada", 
                "File Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    // metodo de pesquisa para edicao
    public static PecaModelo getPesquisaPorId(int idProcurado)
    {
        PecaFile file = new PecaFile();
        PecaModelo modelo = new PecaModelo();   
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

    // getPesquisarPorRefencia
    public static PecaModelo getPesquisarPorRefencia(String referenciaProcurada)
    {
        PecaFile file = new PecaFile();
        PecaModelo modelo = new PecaModelo();
        boolean encontrado = false;
        String dados = "Listagem de Dados do Ficheiro \n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getReferencia().equalsIgnoreCase(referenciaProcurada) && modelo.getStatus() == true)
                {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    encontrado = true;
                    return modelo;
                }
            }
            if(!encontrado)
            {
                JOptionPane.showMessageDialog(null, "Erro, nome nao encontrado", 
                "File Not Found", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return modelo;
    }

    public static StringVector getAllReferencias()
    {
        PecaFile file = new PecaFile();
        PecaModelo modelo = new PecaModelo();
        StringVector vetor = new StringVector();

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getStatus() == true)
                    vetor.add(modelo.getReferencia());
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