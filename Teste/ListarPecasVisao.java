import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListarPecasVisao extends JFrame {
    private JTable tabela;
    private JScrollPane scrollPane;

    public ListarPecasVisao() {
        setTitle("Listar Peças");
        setLayout(new BorderLayout());

        // Simulação de uma lista de peças - isso deve vir de seu arquivo ou banco de dados
        List<PecaModelo> pecas = Persistencia.carregarPecas(); // Supondo que a Persistencia tem esse método

        // Colunas da tabela
        String[] colunas = {"ID", "Nome", "Categoria", "Fornecedor", "Referência", "Preço", "Quantidade", "Disponibilidade"};

        // Dados para a tabela
        Object[][] dados = new Object[pecas.size()][colunas.length];
        for (int i = 0; i < pecas.size(); i++) {
            PecaModelo peca = pecas.get(i);
            dados[i][0] = peca.getId();
            dados[i][1] = peca.getNome();
            dados[i][2] = peca.getCategoria();
            dados[i][3] = peca.getFornecedor();
            dados[i][4] = peca.getReferencia();
            dados[i][5] = peca.getPreco();
            dados[i][6] = peca.getQuantidade();
            dados[i][7] = peca.isDisponibilidade() ? "Disponível" : "Indisponível";
        }

        // Criar a tabela com os dados
        tabela = new JTable(dados, colunas);
        tabela.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(tabela);
        
        // Adicionar o scrollPane à tela
        add(scrollPane, BorderLayout.CENTER);

        // Configurações do JFrame
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ListarPecasVisao();
    }
}
