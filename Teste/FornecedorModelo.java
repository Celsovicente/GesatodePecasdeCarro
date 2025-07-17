import java.io.Serializable;

public class FornecedorModelo implements Serializable {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;

    public FornecedorModelo(int id, String nome, String endereco, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
}
