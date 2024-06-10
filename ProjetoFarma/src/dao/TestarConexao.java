package dao;

import dao.ConexaoBanco;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class TestarConexao {

    public static void main(String[] args) {
        try {
            new ConexaoBanco().conectarComBanco();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso ao banco de dados");
        } catch (HeadlessException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar conextar ao banco de dados" + erro.getMessage());
        }
    }
    
}
