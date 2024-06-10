package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBanco {

    final private String url = "jdbc:mysql://200.195.171.122/grupo11_vitor";
    final private String usuario = "grupo11";
    final private String senha = "9agmsegriCatwXLH";

    public Connection conectarComBanco() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco" + e);
        }
        return null;
    }
}
