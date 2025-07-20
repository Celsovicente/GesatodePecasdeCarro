/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 2817
Ficheiro: FornecedorVisao.java
Data: 16.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class FornecedorModelo implements RegistGeneric
{
    private int id;
    private StringBufferModelo nome, telefone, email, contatoResponsavel, nacionalidade, 
    provincia, comuna, municipio;
    private boolean status;

    public FornecedorModelo()
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
        status = false;
    }

    public FornecedorModelo(int id, String nome, String telefone, String email, String contatoResponsavel,
    String nacionalidade, String provincia, String municipio, String comuna, boolean status)
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

    public void setStatus(boolean status)
    {
        this.status = status;
    }
    
    // metodo toString
    public String toString()
    {
        String dados = "Dados do Fornecedor: \n\n";
        dados += "Id: " + getId() + "\n";
        dados += "Nome: " + getNome() + "\n";
        dados += "Telefone: " + getTelefone() + "\n";
        dados += "Email: " + getEmail() + "\n";
        dados += "Contato Responsavel: " + getContatoResponsavel() + "\n";
        dados += "Nacionalidade: " + getNacionalidade() + "\n";
        dados += "Provincia: " + getProvincia() + "\n";
        dados += "Municipio: " + getMunicipio() + "\n";
        dados += "Comuna: " + getComuna() + "\n";
        dados += "Estado: " + getStatus() + "\n";
 
        return dados;
    }

    // calcular o tamanho dos bytes
    public long sizeof()
    {
        try
        {
            return 160 * 2 + 4 + 1;
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
        FornecedorFile file = new FornecedorFile();
        file.salvarDados(this);
    }

    public void salvarDados()
    {
        FornecedorFile file = new FornecedorFile();
        file.alterarDados(this);
    }
}
