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
import model.Funcionario;

public class FuncionarioDAO {

    private Connection conexao;

    /**
     * Construtor 'ClienteDAO'. Conecta-se ao banco de dados ao ser instanciado.
     */
    public FuncionarioDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }

    /**
     * Método 'Salvar'. Insere um novo cliente no banco de dados.
     */
    public void Salvar(Funcionario obj) {
        try {
            String sql = "INSERT INTO funcionarios(nome,rg,cpf,email,senha,cargo,nivel_acesso,celular) "
                    + "VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivelAcesso());
            stmt.setString(8, obj.getCelular());

            stmt.execute();

            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionario salvo com sucesso!!");

        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o funcionario!!" + erro);
        }
    }

    public void Editar(Funcionario obj) {
        try {
            String sql = "UPDATE funcionarios SET nome =?,rg = ?, cpf = ?,email = ?,senha = ?,cargo = ?,nivel_acesso = ?,celular = ? "
                    + "WHERE id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivelAcesso());
            stmt.setString(8, obj.getCelular());
            stmt.setInt(9, obj.getId());

            stmt.execute();

            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcioanrio editado com sucesso!!");

        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o Funcionario!!" + erro);
        }
    }

    /**
     * Método 'BuscaCliente'. Busca um cliente pelo nome no banco de dados.
     */
    public Funcionario BuscaFuncionario(String nome) {
        try {

            String sql = "SELECT * FROM funcionarios WHERE nome = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nome);

            ResultSet resultado = stmt.executeQuery();

            Funcionario obj = new Funcionario();

            if (resultado.next()) {
                obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setRg(resultado.getString("rg"));
                obj.setCpf(resultado.getString("cpf"));
                obj.setEmail(resultado.getString("email"));
                obj.setSenha(resultado.getString("senha"));
                obj.setCargo(resultado.getString("cargo"));
                obj.setNivelAcesso(resultado.getString("nivel_acesso"));
                obj.setCelular(resultado.getString("celular"));

                JOptionPane.showMessageDialog(null, "Funcionario encontrado!!");
            }
            return obj;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o cliente!!" + erro);
        }
        return null;
    }

    public void Excluir(Funcionario obj) {
        try {
            String sql = "DELETE FROM funcionarios WHERE id = ?";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, obj.getId());
            
            stmt.execute();
            
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Funcionario exluido!!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao exluir funcionario!!" + erro);
        }
    }

    /**
     * Método 'Listar'. Retorna uma lista de todos os clientes do banco de
     * dados.
     */
    public List<Funcionario> Listar() {
        List<Funcionario> lista = new ArrayList<>();

        try {

            String sql = "SELECT * FROM funcionarios";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Funcionario obj = new Funcionario();

                obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setRg(resultado.getString("rg"));
                obj.setCpf(resultado.getString("cpf"));
                obj.setEmail(resultado.getString("email"));
                obj.setSenha(resultado.getString("senha"));
                obj.setCargo(resultado.getString("cargo"));
                obj.setNivelAcesso(resultado.getString("nivel_acesso"));
                obj.setCelular(resultado.getString("celular"));

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
    public List<Funcionario> Filtrar(String nome) {
        List<Funcionario> lista = new ArrayList<>();

        try {

            String sql = "SELECT * FROM funcionarios "
                    + "WHERE nome LIKE ?";


            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nome);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Funcionario obj = new Funcionario();

               obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setRg(resultado.getString("rg"));
                obj.setCpf(resultado.getString("cpf"));
                obj.setEmail(resultado.getString("email"));
                obj.setSenha(resultado.getString("senha"));
                obj.setCargo(resultado.getString("cargo"));
                obj.setNivelAcesso(resultado.getString("nivel_acesso"));
                obj.setCelular(resultado.getString("celular"));

                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista!!" + erro);
        }
        return null;
    }

}
