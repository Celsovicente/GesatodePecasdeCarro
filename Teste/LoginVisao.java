import javax.swing.*;
import java.awt.*;

public class LoginVisao {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginVisao() {
        frame = new JFrame("Sistema de Gestão de Peças Auto");
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Usuário:");
        usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Senha:");
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginVisao();
    }
}
