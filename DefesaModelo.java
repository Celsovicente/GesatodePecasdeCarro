/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 35217
Ficheiro: DefesaModelo.java
Data: 16.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class DefesaModelo implements RegistGeneric
{
    private int id;
    private StringBufferModelo nome, telefone, email, contatoResponsavel, nacionalidade, 
    provincia, comuna, municipio, conferencia, diocese, paroquia;
    private DataModelo dataFundacao;
    private boolean status;

    public DefesaModelo()
    {
        id = 0;
        nome = new StringBufferModelo("", 20);
        telefone = new StringBufferModelo("", 20);
        email = new StringBufferModelo("", 20);
        contatoResponsavel = new StringBufferModelo("", 20);
        nacionalidade = new StringBufferModelo("", 20);
        provincia = new StringBufferModelo("", 20);
        municipio = new StringBufferModelo("", 20);
        comuna = new StringBufferModelo("", 20);
        conferencia = new StringBufferModelo("", 20);
        diocese = new StringBufferModelo("", 20);
        paroquia = new StringBufferModelo("", 20);
        dataFundacao = new DataModelo();
        status = false;
    }

    public DefesaModelo(int id, String nome, String telefone, String email, String contatoResponsavel,
    String nacionalidade, String provincia, String municipio, String comuna, String conferencia, 
    String diocese, String paroquia, String dataFundacao,boolean status)
    {
        this.id = id;
        this.nome = new StringBufferModelo(nome, 20);
        this.telefone = new StringBufferModelo(telefone, 20);
        this.email = new StringBufferModelo(email, 20);
        this.contatoResponsavel = new StringBufferModelo(contatoResponsavel, 20);
        this.nacionalidade = new StringBufferModelo(nacionalidade, 20);
        this.provincia = new StringBufferModelo(provincia, 20);
        this.municipio = new StringBufferModelo(municipio, 20);
        this.comuna = new StringBufferModelo(comuna, 20);
        this.conferencia = new StringBufferModelo(conferencia, 20);
        this.diocese = new StringBufferModelo(diocese, 20);
        this.paroquia = new StringBufferModelo(paroquia, 20);
        this.dataFundacao = new DataModelo(dataFundacao);
        this.status = status;
    }   

    // metodos getters
    public int getId()
    {
        return id;
    }

    public String getNome()
    {
        return nome.toStringEliminatingSpaces();
    }

    public String getTelefone()
    {
        return telefone.toStringEliminatingSpaces();
    }

    public String getEmail()
    {
       return email.toStringEliminatingSpaces();
    }

    public String getContatoResponsavel()
    {
        return contatoResponsavel.toStringEliminatingSpaces();
    }

    public String getNacionalidade()
    {
        return nacionalidade.toStringEliminatingSpaces();
    }

    public String getProvincia()
    {
        return provincia.toStringEliminatingSpaces();
    }

    public String getMunicipio()
    {
        return municipio.toStringEliminatingSpaces();
    }

    public String getComuna()
    {
        return comuna.toStringEliminatingSpaces();
    }

    public String getConferencia()
    {
        return conferencia.toStringEliminatingSpaces();
    }

    public String getDiocese()
    {
        return diocese.toStringEliminatingSpaces();
    }

    public String getParoquia()
    {
        return paroquia.toStringEliminatingSpaces();
    }

    public String getDataFundacao()
    {
        return dataFundacao.toString();
    }

    public boolean getStatus()
    {
        return status;
    }

    // metodos setters
    public void setId(int id)
    {
        this.id = id;
    }

    public void setNome(String nome)
    {
        this.nome = new StringBufferModelo(nome, 20);
    }

    public void setTelefone(String telefone)
    {
        this.telefone = new StringBufferModelo(telefone, 20);
    }

    public void setEmail(String email)
    {
        this.email = new StringBufferModelo(email, 20);
    }

    public void setContatoReponsavel(String contatoResponsavel)
    {
        this.contatoResponsavel = new StringBufferModelo(contatoResponsavel, 20);
    }

    public void setNacionalidade(String nacionalidade)
    {
        this.nacionalidade = new StringBufferModelo(nacionalidade, 20);
    }

    public void setProvincia(String provincia)
    {
        this.provincia = new StringBufferModelo(provincia, 20);
    }

    public void setMunicipio(String municipio)
    {
        this.municipio = new StringBufferModelo(municipio, 20);
    }

    public void setComuna(String comuna)
    {
        this.comuna = new StringBufferModelo(comuna, 20);
    }

    public void setConferencia(String conferencia)
    {
        this.conferencia = new StringBufferModelo(conferencia, 20);
    }

    public void setDiocese(String diocese)
    {
        this.diocese = new StringBufferModelo(diocese, 20);
    }

    public void setParoquia(String paroquia)
    {
        this.paroquia = new StringBufferModelo(paroquia, 20);
    }

    public void setDataFundacao(String dataFundacao)
    {
        this.dataFundacao = new DataModelo(dataFundacao);
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }
    
    // metodo toString
    public String toString()
    {
        String dados = "Dados da Defesa: \n\n";
        dados += "Id: " + getId() + "\n";
        dados += "Nome: " + getNome() + "\n";
        dados += "Telefone: " + getTelefone() + "\n";
        dados += "Email: " + getEmail() + "\n";
        dados += "Contato Responsavel: " + getContatoResponsavel() + "\n";
        dados += "Nacionalidade: " + getNacionalidade() + "\n";
        dados += "Provincia: " + getProvincia() + "\n";
        dados += "Municipio: " + getMunicipio() + "\n";
        dados += "Comuna: " + getComuna() + "\n";
        dados += "Conferencia: " + getConferencia() + "\n";
        dados += "Diocese: " + getDiocese() + "\n";
        dados += "Paroquia: " + getParoquia() + "\n";
        dados += "Data de Fundacao: " + getDataFundacao() + "\n";
        dados += "Estado: " + getStatus() + "\n";
 
        return dados;
    }

    // calcular o tamanho dos bytes
    public long sizeof()
    {
        try
        {
            return 220 * 2 + 4 + 12 + 1;
        }
        catch(Exception ex)
        {
            return 0;
        }
    }

    // metodo write
    public void write(RandomAccessFile stream)
    {
        try
        {
            stream.writeInt(id);
            nome.write(stream);
            telefone.write(stream);
            email.write(stream);
            contatoResponsavel.write(stream);
            nacionalidade.write(stream);
            provincia.write(stream);
            municipio.write(stream);
            comuna.write(stream);
            conferencia.write(stream);
            diocese.write(stream);
            paroquia.write(stream);
            dataFundacao.write(stream);
            stream.writeBoolean(status);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao escrever no Ficheiro");
        }
    }

    // metodo read
    public void read(RandomAccessFile stream)
    {
        try
        {
            id = stream.readInt();
            nome.read(stream);
            telefone.read(stream);
            email.read(stream);
            contatoResponsavel.read(stream);
            nacionalidade.read(stream);
            provincia.read(stream);
            municipio.read(stream);
            comuna.read(stream);
            conferencia.read(stream);
            diocese.read(stream);
            paroquia.read(stream);
            dataFundacao.read(stream);
            status = stream.readBoolean();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao ler no ficheiro");
        }
    }

    public void salvar()
    {
        DefesaFile file = new DefesaFile();
        file.salvarDados(this);
    }
}
