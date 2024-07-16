package dao;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import model.Fornecedores;
import model.Produtos;

public class ProdutosDAO implements DAOInterface<Produtos> {

    private Connection conexao;

    public ProdutosDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }

    @Override
    public void Salvar(Produtos obj) {
        try {
            String sql = "INSERT INTO produtos (descricao,preco,qtd_estoque,for_id,classe_id,precisa_de_receita,validade) "
                    + "VALUES (?,?,?,?,(SELECT id FROM classeProduto WHERE nome = ?),?,?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.setString(5, obj.getNomeClasse());
            stmt.setBoolean(6, obj.isPrecisa_de_receita());
            stmt.setString(7, obj.getDataValidade());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!!");
        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o Produto!!" + erro);
        }
    }

    @Override
    public void Editar(Produtos obj) {
        try {
            String sql = "UPDATE produtos SET descricao= ?,preco = ?,qtd_estoque = ?,for_id = ?,classe_id =(SELECT id FROM classeProduto WHERE nome = ?), precisa_de_receita = ?, validade = ? "
                    + "WHERE id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.setString(5, obj.getNomeClasse());
            stmt.setBoolean(6, obj.isPrecisa_de_receita());
            stmt.setString(7, obj.getDataValidade());
            stmt.setInt(8, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto editado com sucesso!!");
        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o produto!!" + erro);
        }
    }

    @Override
    public Produtos Buscar(String descricao) {
        try {
            String sql = "SELECT p.id,p.descricao,p.preco,p.qtd_estoque,f.nome,c.nome,p.precisa_de_receita "
                    + "FROM produtos AS p "
                    + "INNER JOIN fornecedores AS f "
                    + "ON (p.for_id = f.id) "
                    + "LEFT JOIN classeProduto AS c "
                    + "ON (c.id = p.classe_id) "
                    + "WHERE p.descricao = ? ";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, descricao);
            ResultSet resultado = stmt.executeQuery();

            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();

            if (resultado.next()) {
                obj.setId(resultado.getInt("p.id"));
                obj.setDescricao(resultado.getString("p.descricao"));
                obj.setPreco(resultado.getDouble("p.preco"));
                obj.setQtd_estoque(resultado.getInt("p.qtd_estoque"));
                f.setNome(resultado.getString("f.nome"));
                obj.setFornecedor(f);
                obj.setNomeClasse(resultado.getString("c.nome"));
                obj.setPrecisa_de_receita(resultado.getBoolean("p.precisa_de_receita"));
            }
            stmt.close();
            return obj;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o produto!!" + erro);
        }
        return null;
    }

    public Produtos BuscarCodigoProduto(int id) {
        try {
            String sql = "SELECT p.id,p.descricao,p.preco,p.qtd_estoque,f.nome,c.nome "
                    + "FROM produtos AS p "
                    + "INNER JOIN fornecedores AS f "
                    + "ON (p.for_id = f.id) "
                    + "LEFT JOIN classeProduto AS c "
                    + "ON (c.id = p.classe_id) "
                    + "WHERE p.id = ? ";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();

            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();

            if (resultado.next()) {
                obj.setId(resultado.getInt("p.id"));
                obj.setDescricao(resultado.getString("p.descricao"));
                obj.setPreco(resultado.getDouble("p.preco"));
                obj.setQtd_estoque(resultado.getInt("p.qtd_estoque"));
                f.setNome(resultado.getString("f.nome"));
                obj.setFornecedor(f);
                obj.setNomeClasse(resultado.getString("c.nome"));
            }
            stmt.close();
            return obj;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o produto!!" + erro);
        }
        return null;
    }

    @Override
    public void Excluir(Produtos obj) {
        try {
            String sql = "DELETE FROM produtos WHERE id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto excluído!!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto!!" + erro);
        }
    }

    @Override
    public ArrayList<Produtos> Listar() {
        ArrayList<Produtos> lista = new ArrayList<>();
        try {
            String sql = "SELECT p.id,p.descricao,p.preco,p.qtd_estoque,f.nome,c.nome,p.precisa_de_receita, date_format(p.validade, '%d/%m/%Y') AS data_formatada "
                    + "FROM produtos AS p "
                    + "INNER JOIN fornecedores AS f "
                    + "ON (p.for_id = f.id) "
                    + "LEFT JOIN classeProduto AS c "
                    + "ON (c.id = p.classe_id) "
                    + "ORDER BY `p`.`id` DESC";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();

                obj.setId(resultado.getInt("p.id"));
                obj.setDescricao(resultado.getString("p.descricao"));
                obj.setPreco(resultado.getDouble("p.preco"));
                obj.setQtd_estoque(resultado.getInt("p.qtd_estoque"));
                f.setNome(resultado.getString("f.nome"));
                obj.setFornecedor(f);
                obj.setNomeClasse(resultado.getString("c.nome"));
                obj.setPrecisa_de_receita(resultado.getBoolean("p.precisa_de_receita"));
                obj.setDataValidade(resultado.getString("data_formatada"));

                lista.add(obj);
            }
            stmt.close();
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista!!" + erro);
        }
        return null;
    }

    @Override
    public ArrayList<Produtos> Filtrar(String descricao) {
        ArrayList<Produtos> lista = new ArrayList<>();
        try {
            String sql = "SELECT p.id,p.descricao,p.preco,p.qtd_estoque,f.nome,c.nome,p.precisa_de_receita, date_format(p.validade, '%d/%m/%Y') AS data_formatada "
                    + "FROM produtos AS p "
                    + "INNER JOIN fornecedores AS f "
                    + "ON (p.for_id = f.id) "
                    + "LEFT JOIN classeProduto AS c "
                    + "ON (c.id = p.classe_id) "
                    + "WHERE p.descricao LIKE ? ";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, descricao);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();

                obj.setId(resultado.getInt("p.id"));
                obj.setDescricao(resultado.getString("p.descricao"));
                obj.setPreco(resultado.getDouble("p.preco"));
                obj.setQtd_estoque(resultado.getInt("p.qtd_estoque"));
                f.setNome(resultado.getString("f.nome"));
                obj.setFornecedor(f);
                obj.setNomeClasse(resultado.getString("c.nome"));
                obj.setPrecisa_de_receita(resultado.getBoolean("p.precisa_de_receita"));
                obj.setDataValidade(resultado.getString("data_formatada"));

                lista.add(obj);
            }
            stmt.close();
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista!!" + erro);
        }
        return null;
    }

    public void AdicionarEstoque(int id, int qtd_nova) {
        try {
            String sql = "UPDATE produtos SET qtd_estoque = ? WHERE id = ? ";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso ao estoque");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no estoque!!" + erro);
        }
    }

    public void BaixaEstoque(int id, int qtd_nova) {
        try {
            String sql = "UPDATE produtos SET qtd_estoque = ? WHERE id = ? ";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao dar baixa no estoque!!" + erro);
        }
    }

    @Override
    public Produtos BuscarCpf(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int retornaQtdAtualEstoque(int id) {
        try {
            int qtdAtualEstoque = 0;

            String sql = "SELECT qtd_estoque FROM produtos WHERE id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                qtdAtualEstoque = (resultado.getInt("qtd_estoque"));
            }
            return qtdAtualEstoque;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao retornar a quantidade atual do estoque" + e);
        }
    }
}
