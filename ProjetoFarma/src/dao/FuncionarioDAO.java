package dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;
import view.Login;
import view.TelaPrincipal;

public class FuncionarioDAO implements DAOInterface<Funcionario> {

    private Connection conexao;

    public FuncionarioDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }

    @Override
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

    @Override
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

            JOptionPane.showMessageDialog(null, "Funcionario editado com sucesso!!");

        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o funcionario!!" + erro);
        }
    }

    @Override
    public Funcionario Buscar(String nome) {
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
            stmt.close();
            return obj;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o funcionario!!" + erro);
        }
        return null;
    }

    @Override
    public void Excluir(Funcionario obj) {
        try {
            String sql = "DELETE FROM funcionarios WHERE id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionario excluído!!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir funcionario!!" + erro);
        }
    }

    @Override
    public ArrayList<Funcionario> Listar() {
        ArrayList<Funcionario> lista = new ArrayList<>();

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
            stmt.close();
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista!!" + erro);
        }
        return null;
    }

    @Override
    public ArrayList<Funcionario> Filtrar(String nome) {
        ArrayList<Funcionario> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM funcionarios WHERE nome LIKE ?";

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
            stmt.close();
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista!!" + erro);
        }
        return null;
    }

    public void Login(String email, String senha) {
        try {
            String sql = "SELECT * FROM funcionarios WHERE email=? and senha=?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                JOptionPane.showMessageDialog(null, "Seja bem vindo(a) ao sistema!!");
                new TelaPrincipal().setVisible(true);
            } else {
                Login login = new Login();
                JOptionPane.showMessageDialog(null, "Dados inválidos!!");
                login.setVisible(true);
            }
            stmt.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no funcionarioDAO " + erro);
        }
    }
}
