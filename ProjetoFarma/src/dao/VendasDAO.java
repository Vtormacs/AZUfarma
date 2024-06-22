package dao;

import java.sql.Connection;
import model.Vendas;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendasDAO {
    private Connection conexao;

    public VendasDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }
    
    public void salvar (Vendas obj){
        try {
            String sql = "INSERT INTO vendas (cliente_id,data_venda,total_venda,observacoes) "
                    + "VALUES (?,?,?,?)";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getDataVenda());
            stmt.setDouble(3, obj.getTotalVenda());
            stmt.setString(4, obj.getObservacoes());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao realizar a venda" + e);
        }
    }
    
    public int retornaUltimoIdVenda(){
        try {
            int ultimoId = 0;
            
            String sql = "SELECT max(id) FROM vendas";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet resultado = stmt.executeQuery();
                
                while(resultado.next()){
                    Vendas v = new Vendas();
                    v.setId(resultado.getInt("id"));
                    ultimoId = v.getId();
                    
                }
                return ultimoId;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao retornar o ultimo id da venda" + e);
        }
    }
    
}
