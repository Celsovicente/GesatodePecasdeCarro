/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 2817
Ficheiro: PecaModelo.java
Data: 17.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class PecaModelo implements RegistGeneric
{
    private int id,  quantidade;
    private StringBufferModelo nome, referencia, categoria, estado, marcaAutomovel, modeloAutomovel, 
    localizacao, disponibilidade;
    private float preco; 
    private boolean status;

    public PecaModelo()
    {
        id = 0;
        nome = new StringBufferModelo("", 20);
        referencia = new StringBufferModelo("", 20);
        categoria = new StringBufferModelo("", 20);
        estado = new StringBufferModelo("", 20);
        marcaAutomovel = new StringBufferModelo("",20);
        modeloAutomovel = new StringBufferModelo("", 20);
        localizacao = new StringBufferModelo("", 20);
        preco = 0;
        quantidade = 0;
        disponibilidade = new StringBufferModelo("", 20);
        status = false;
    }

    public PecaModelo(int id, String nome, String referencia, String categoria, String estado, 
    String marcaAutomovel, String modeloAutomovel, String localizacao, float preco, int quantidade, 
    String disponibilidade, boolean status)
    {
        this.id = id;
        this.nome = new StringBufferModelo(nome, 20);
        this.referencia = new StringBufferModelo(referencia, 20);
        this.categoria = new StringBufferModelo(categoria, 20);
        this.estado = new StringBufferModelo(estado, 20);
        this.marcaAutomovel = new StringBufferModelo(marcaAutomovel,20);
        this.modeloAutomovel = new StringBufferModelo(modeloAutomovel, 20);
        this.localizacao = new StringBufferModelo(localizacao, 20);
        this.preco = preco;
        this.quantidade = quantidade;
        this.disponibilidade = new StringBufferModelo(disponibilidade, 20);
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

    public String getReferencia()
    {
        return referencia.toStringEliminatingSpaces();
    }

    public String getCategoria()
    {
       return categoria.toStringEliminatingSpaces();
    }

    public String getEstado()
    {
        return estado.toStringEliminatingSpaces();
    }

    public String getMarcaAutomovel()
    {
        return marcaAutomovel.toStringEliminatingSpaces();
    }

    public String getModeloAutomovel()
    {
        return modeloAutomovel.toStringEliminatingSpaces();
    }

    public String getLocalizacao()
    {
        return localizacao.toStringEliminatingSpaces();
    }

    public float getPreco()
    {
        return preco;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public String getDisponibilidade()
    {
        return disponibilidade.toStringEliminatingSpaces();
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

    public void setReferencia(String referencia)
    {
        this.referencia = new StringBufferModelo(referencia, 20);
    }

    public void setCategoria(String categoria)
    {
        this.categoria = new StringBufferModelo(categoria, 20);
    }

    public void setEstado(String estado)
    {
        this.estado = new StringBufferModelo(estado, 20);
    }

    public void setMarcaAutomovel(String marcaAutomovel)
    {
        this.marcaAutomovel = new StringBufferModelo(marcaAutomovel, 20);
    }

    public void setModeloAutomovel(String modeloAutomovel)
    {
        this.modeloAutomovel = new StringBufferModelo(modeloAutomovel, 20);
    }

    public void setLocalizacao(String localizacao)
    {
        this.localizacao = new StringBufferModelo(localizacao, 20);
    }

    public void setPrco(float preco)
    {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public void setDisponibilidade(String disponibilidade)
    {
        this.disponibilidade = new StringBufferModelo(disponibilidade, 20);
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
        dados += "Referencia: " + getReferencia() + "\n";
        dados += "Categoria: " + getCategoria() + "\n";
        dados += "Estado: " + getEstado() + "\n";
        dados += "Marca de Automovel: " + getMarcaAutomovel() + "\n";
        dados += "Modelo de Automovel: " + getModeloAutomovel() + "\n";
        dados += "Localizacao: " + getLocalizacao() + "\n";
        dados += "Preco: " + getPreco() + "\n";
        dados += "Quantidade: " + getQuantidade() + "\n";
        dados += "Disponibilidade: " + getDisponibilidade() + "\n";
        dados += "Status: " + getStatus() + "\n";
 
        return dados;
    }

    // calcular o tamanho dos bytes
    public long sizeof()
    {
        try
        {
            return 160 * 2 + 4 * 3 + 1;
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
            referencia.write(stream);
            categoria.write(stream);
            estado.write(stream);
            marcaAutomovel.write(stream);
            modeloAutomovel.write(stream);
            localizacao.write(stream);
            stream.writeFloat(preco);
            stream.writeInt(quantidade);
            disponibilidade.write(stream);
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
            referencia.read(stream);
            categoria.read(stream);
            estado.read(stream);
            marcaAutomovel.read(stream);
            modeloAutomovel.read(stream);
            localizacao.read(stream);
            preco = stream.readFloat();
            quantidade = stream.readInt();
            disponibilidade.read(stream);
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
        PecaFile file = new PecaFile();
        file.salvarDados(this);
    }

    public void salvarDados()
    {
        PecaFile file = new PecaFile();
        file.alterarDados(this);
    }
}
