/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 35217
Ficheiro: DefesaFile.java
Data: 16.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import SwingComponents.*;
import Calendario.*;

public class DefesaFile extends ObjectsFile
{
    public DefesaFile()
    {
        super("DefesaFile.dat", new DefesaModelo());
    }  

    public void salvarDados(DefesaModelo modelo)
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

    public void alterarDados(DefesaModelo modelo_novo)
	{
		DefesaModelo modelo_antigo = new DefesaModelo();
		
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

    public static void listarDefesa()
    {
        DefesaFile file = new DefesaFile();
        DefesaModelo modelo = new DefesaModelo();
        String dados = "Listagem dos Dados da Defesa Modelo:\n\n";

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
   
    public static StringVector getAllConferencia()
    {
        DefesaFile file = new DefesaFile();
        DefesaModelo modelo = new DefesaModelo();
        StringVector vetor = new StringVector();

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getStatus() == true)
                    vetor.add(modelo.getConferencia());
            }
            
            vetor.sort();    
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return vetor;
    }

    public static StringVector getAllDiocese()
    {
        DefesaFile file = new DefesaFile();
        DefesaModelo modelo = new DefesaModelo();
        StringVector vetor = new StringVector();

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getStatus() == true)
                    vetor.add(modelo.getDiocese());
            }
            
            vetor.sort();    
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return vetor;
    }

    public static StringVector getAllParoquia()
    {
        DefesaFile file = new DefesaFile();
        DefesaModelo modelo = new DefesaModelo();
        StringVector vetor = new StringVector();

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                if(modelo.getStatus() == true)
                    vetor.add(modelo.getParoquia());
            }
            
            vetor.sort();    
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return vetor;
    }

    // pesquisa por filtro
    public static void pesquisa(String paroquia, String dataFundacao)
    {
        DefesaFile file = new DefesaFile();
        DefesaModelo modelo = new DefesaModelo();
        boolean status = false;

        String dados = "Listagem de Dados do Ficheiro \n\n";

        try
        {
            file.stream.seek(4);

            for(int i = 0; i < file.getNregistos(); i++)
            {
                modelo.read(file.stream);

                // conversao da data
                String dataConvertida = new DataModelo(dataFundacao).toString();
                
                if(modelo.getStatus() && modelo.getParoquia().equalsIgnoreCase(paroquia) &&  
                modelo.getDataFundacao().equals(dataConvertida))
                {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    status = true;
                    break;
                }
            }
            if(!status)
            {
                JOptionPane.showMessageDialog(null, "Erro, paroquia e a data de fundacao nao encontradas", 
                    "File Not Found", JOptionPane.ERROR_MESSAGE);
            }

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}