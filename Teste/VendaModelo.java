import java.io.Serializable;

public class VendaModelo implements Serializable {
    private int id;
    private PecaModelo peca;
    private int quantidadeVendida;
    private double valorTotal;

    public VendaModelo(int id, PecaModelo peca, int quantidadeVendida, double valorTotal) {
        this.id = id;
        this.peca = peca;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PecaModelo getPeca() {
        return peca;
    }

    public void setPeca(PecaModelo peca) {
        this.peca = peca;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Venda ID: " + id + " - Peça: " + peca.getNome() + " - Quantidade: " + quantidadeVendida + " - Total: " + valorTotal;
    }
}
