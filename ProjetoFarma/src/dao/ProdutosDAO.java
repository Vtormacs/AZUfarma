package dao;

import java.awt.HeadlessException;
import java.util.List;
import java.sql.Connection;
import model.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Fornecedores;
import model.Produtos;

public class ProdutosDAO {

    private Connection conexao;

    /**
     * Construtor 'ClienteDAO'. Conecta-se ao banco de dados ao ser instanciado.
     */
    public ProdutosDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }

    /**
     * Método 'Salvar'. Insere um novo cliente no banco de dados.
     */
    public void Salvar(Produtos obj) {
        try {
            String sql = "INSERT INTO produtos (descricao,preco,qtd_estoque,for_id,classe_id ) "
                    + "VALUES (?,?,?,?,(SELECT id FROM classeProduto WHERE nome = ?))";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.setString(5, obj.getNomeClasse());

            stmt.execute();

            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!!");

        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o Produto!!" + erro);
        }
    }

    public void Editar(Produtos obj) {
        try {
            String sql = "UPDATE produtos SET descricao= ?,preco = ?,qtd_estoque = ?,for_id = ?,classe_id =(SELECT id FROM classeProduto WHERE nome = ?) "
                    + "WHERE id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());
            stmt.setString(5, obj.getNomeClasse());
            stmt.setInt(6, obj.getId());

            stmt.execute();

            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto editado com sucesso!!");

        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o produto!!" + erro);
        }
    }

    /**
     * Método 'BuscaCliente'. Busca um cliente pelo nome no banco de dados.
     */
    public Produtos Buscar(String descricao) {
        try {

            String sql = "SELECT p.id,p.descricao,p.preco,p.qtd_estoque,f.nome,c.nome "
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

                JOptionPane.showMessageDialog(null, "Produto encontrado!!");
            }
            return obj;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o produto!!" + erro);
        }
        return null;
    }

    public void Excluir(Produtos obj) {
        try {
            String sql = "DELETE FROM produtos WHERE id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setInt(1, obj.getId());

            stmt.execute();

            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto exluido!!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao exluir preduto!!" + erro);
        }
    }

    /**
     * Método 'Listar'. Retorna uma lista de todos os clientes do banco de
     * dados.
     */
    public List<Produtos> Listar() {
        List<Produtos> lista = new ArrayList<>();

        try {

            String sql = "SELECT p.id,p.descricao,p.preco,p.qtd_estoque,f.nome,c.nome "
                    + "FROM produtos AS p "
                    + "INNER JOIN fornecedores AS f "
                    + "ON (p.for_id = f.id) "
                    + "LEFT JOIN classeProduto AS c "
                    + "ON (c.id = p.classe_id)";

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

                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista!!" + erro);
        }
        return null;
    }

    /**
     * Método 'Filtrar'. Retorna uma lista de clientes cujo nome corresponde ao
     * parâmetro.
     */
    public List<Produtos> Filtrar(String descricao) {
        List<Produtos> lista = new ArrayList<>();

        try {

             String sql = "SELECT p.id,p.descricao,p.preco,p.qtd_estoque,f.nome,c.nome "
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

                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista!!" + erro);
        }
        return null;
    }

    public void AdicionarEstoque(int qtd_nova, int id){
        try {
            String sql = "UPDATE produtos SET qtd_estoque = ? ";
            
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
    
    public void BaixaEstoque(int qtd_nova, int id){
        try {
            String sql = "UPDATE produtos SET qtd_estoque = ? ";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Baixa com sucesso no estoque");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao dar baixa no estoque!!" + erro);
        }
    }
}
