package dao;

import java.sql.Connection;
import model.ItensVendas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import model.Produtos;

public class ItensVendasDAO {

    private Connection conexao;

    public ItensVendasDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }

    public void salvar(ItensVendas obj) {
        try {
            String sql = "INSERT INTO itensVenda (venda_id,produto_id,qtd,subtotal) "
                    + "VALUES (?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, obj.getVendas().getId());
            stmt.setInt(2, obj.getProdutos().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubTotal());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar os itens da mihha venda" + e);
        }
    }

    public List<ItensVendas> listaItens(int venda_id) {
        try {
            List<ItensVendas> lista = new ArrayList<>();

            String sql = "SELECT p.id, p.descricao, i.qtd, p.preco, i.subtotal "
                    + "FROM itensVenda AS i "
                    + "INNER JOIN produtos AS p "
                    + "ON (i.produto_id = p.id) "
                    + "WHERE i.venda_id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, venda_id);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                ItensVendas item = new ItensVendas();
                Produtos p = new Produtos();

                p.setId(resultado.getInt("p.id"));
                item.setProdutos(p);
                p.setDescricao(resultado.getString("p.descricao"));
                item.setProdutos(p);
                item.setQtd(resultado.getInt("i.qtd"));
                p.setPreco(resultado.getDouble("p.preco"));
                item.setProdutos(p);
                item.setSubTotal(resultado.getDouble("i.subtotal"));

                lista.add(item);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a lista de itens" + e);
        }
    }
}
