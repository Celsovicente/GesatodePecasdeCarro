/*------------------------------------
Tema: Gestão de Peças Auto
Nome: Emanuel F. Shekiná
Número: 2817
Ficheiro: VendaModelo.java
Data: 19.07.2025
--------------------------------------*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;
import java.io.*;

public class VendaModelo implements RegistGeneric
{
    private int id,  quantidade;
    private StringBufferModelo nomeCliente, telefoneCliente, nomeFuncionario, tipoPagamento, 
    condicaoVenda;
    private float precoUnitario, totalVenda; 
    private boolean status;
    private DataModelo dataVenda;

    public VendaModelo()
    {
       id = 0;
       quantidade = 0;
       precoUnitario = 0;
       nomeCliente = new StringBufferModelo("", 20);
       telefoneCliente = new StringBufferModelo("", 20);
       nomeFuncionario = new StringBufferModelo("", 20);
       tipoPagamento = new StringBufferModelo("", 20);
       condicaoVenda = new StringBufferModelo("", 20);
       dataVenda = new DataModelo();
       totalVenda = 0;
       status = false;
    }

    public VendaModelo(int id, int quantidade, float precoUnitario, String nomeCliente,
    String telefoneCliente, String nomeFuncionario, String tipoPagamento, String condicaoVenda,
    String dataVenda, float totalVenda,boolean status)
    {
       this.id = id;
       this.quantidade = quantidade;
       this.precoUnitario = precoUnitario;
       this.nomeCliente = new StringBufferModelo(nomeCliente, 20);
       this.telefoneCliente = new StringBufferModelo(telefoneCliente, 20);
       this.nomeFuncionario = new StringBufferModelo(nomeFuncionario, 20);
       this.tipoPagamento = new StringBufferModelo(tipoPagamento, 20);
       this.condicaoVenda = new StringBufferModelo(condicaoVenda, 20);
       this.dataVenda = new DataModelo(dataVenda);
       this.totalVenda = totalVenda;
       this.status = status;
    }   

    // metodos getters
    public int getId()
    {
        return id;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public float getPreco()
    {
        return precoUnitario;
    }

    public String getNomeCliente()
    {
       return nomeCliente.toStringEliminatingSpaces();
    }

    public String getTelefoneCliente()
    {
        return telefoneCliente.toStringEliminatingSpaces();
    }

    public String getNomeFuncionario()
    {
        return nomeFuncionario.toStringEliminatingSpaces();
    }
    
    public String getTipoPagamento()
    {
        return tipoPagamento.toStringEliminatingSpaces();
    }

    public String getCondicaoVenda()
    {
        return condicaoVenda.toStringEliminatingSpaces();
    }

    public String getDataVenda()
    {
        return dataVenda.toString();
    }

    public float getTotalVenda()
    {
        return totalVenda;
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

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public void setPrco(float precoUnitario)
    {
        this.precoUnitario = precoUnitario;
    }

    public void setNomeCliente(String nomeCliente)
    {
        this.nomeCliente = new StringBufferModelo(nomeCliente, 20);
    }

    public void setTelefoneCliente(String telefoneCliente)
    {
        this.telefoneCliente = new StringBufferModelo(telefoneCliente, 20);
    }
    
    public void setNomeFuncionario(String nomeFuncionario)
    {
        this.nomeFuncionario = new StringBufferModelo(nomeFuncionario, 20);
    }

    public void setTipoPagamento(String tipoPagamento)
    {
        this.tipoPagamento = new StringBufferModelo(tipoPagamento, 20);
    }

    public void setCondicaoVenda(String condicaoVenda)
    {
        this.condicaoVenda = new StringBufferModelo(condicaoVenda, 20);
    }

    public void setDataVenda(String dataVenda)
    {
        this.dataVenda = new DataModelo(dataVenda);
    }

    public void setTotalVenda(float totalVenda)
    {
        this.totalVenda = totalVenda;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }
    
    // metodo toString
    public String toString()
    {
        String dados = "Dados da Venda: \n\n";
        dados += "Id: " + getId() + "\n";
        dados += "Quantidade: " + getQuantidade() + "\n";
        dados += "Preco: " + getPreco() + "\n";
        dados += "Nome do Cliente: " + getNomeCliente() + "\n";
        dados += "Telefone do Cliente: " + getTelefoneCliente() + "\n";
        dados += "Nome do Funcionario: " + getNomeFuncionario() + "\n";
        dados += "Tipo de Pagamento: " + getTipoPagamento() + "\n";
        dados += "Condicao de Venda: " + getCondicaoVenda() + "\n";
        dados += "Data de Venda: " + getDataVenda() + "\n";
        dados += "Total de VEndas: " + getTotalVenda() + "\n";
        dados += "Estado: " + getStatus() + "\n";
    
        return dados;
    }

    // calcular o tamanho dos bytes
    public long sizeof()
    {
        try
        {
            return 100 * 2 + 4 * 4 + 12 + 1;
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
            stream.writeInt(quantidade);
            stream.writeFloat(precoUnitario);
            nomeCliente.write(stream);
            telefoneCliente.write(stream);
            nomeFuncionario.write(stream);
            tipoPagamento.write(stream);
            condicaoVenda.write(stream);
            dataVenda.write(stream);
            stream.writeFloat(totalVenda);
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
            quantidade =  stream.readInt();
            precoUnitario =  stream.readFloat();
            nomeCliente.read(stream);
            telefoneCliente.read(stream);
            nomeFuncionario.read(stream);
            tipoPagamento.read(stream);
            condicaoVenda.read(stream);
            dataVenda.read(stream);
            totalVenda =  stream.readFloat();
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
        VendaFile file = new VendaFile();
        file.salvarDados(this);
    }

    public void salvarDados()
    {
        VendaFile file = new VendaFile();
        file.alterarDados(this);
    }
}
