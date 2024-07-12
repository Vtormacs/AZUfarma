package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBanco {

    final private String url = "jdbc:mysql://localhost:3306/azufarma";
    final private String usuario = "root";
    final private String senha = "12345";

    public Connection conectarComBanco() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco" + e);
        }
        return null;
    }
}
