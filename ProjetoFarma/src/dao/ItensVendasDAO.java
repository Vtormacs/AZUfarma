package dao;

import java.sql.Connection;
import model.ItensVendas;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItensVendasDAO {
     private Connection conexao;

    public ItensVendasDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }
    public void salvar (ItensVendas obj){
        try {
            String sql = "INSERT INTO itensVenda (venda_id,produto_id,qtd,subtotal) "
                    + "VALUES (?,?,?,?)";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1,obj.getVendas().getId());
            stmt.setInt(2,obj.getProdutos().getId());
            stmt.setInt(3,obj.getQtd());
            stmt.setDouble(4,obj.getSubTotal());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
             throw new RuntimeException("Erro ao salvar os itens da mihha venda" + e);
        }
    }
}
