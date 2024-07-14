package dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Fornecedores;

public class FornecedoresDAO implements DAOInterface<Fornecedores> {
    private Connection conexao;

    public FornecedoresDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }

    @Override
    public void Salvar(Fornecedores obj) {
        try {
            String sql = "INSERT INTO fornecedores (nome,cnpj,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor salvo com sucesso!!");

        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o fornecedor!!" + erro);
        }
    }

    @Override
    public void Editar(Fornecedores obj) {
        try {
            String sql = "UPDATE fornecedores SET nome =?,cnpj = ?,email = ?,telefone = ?,celular = ?,cep = ?,endereco = ?,numero = ?,complemento = ?,bairro = ?,cidade = ?,estado = ? "
                    + "WHERE id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCnpj());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCelular());
            stmt.setString(6, obj.getCep());
            stmt.setString(7, obj.getEndereco());
            stmt.setInt(8, obj.getNumero());
            stmt.setString(9, obj.getComplemento());
            stmt.setString(10, obj.getBairro());
            stmt.setString(11, obj.getCidade());
            stmt.setString(12, obj.getEstado());
            stmt.setInt(13, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor editado com sucesso!!");

        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o fornecedor!!" + erro);
        }
    }

    @Override
    public Fornecedores Buscar(String nome) {
        try {
            String sql = "SELECT * FROM fornecedores WHERE nome = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet resultado = stmt.executeQuery();
            Fornecedores obj = new Fornecedores();

            if (resultado.next()) {
                obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setCnpj(resultado.getString("cnpj"));
                obj.setEmail(resultado.getString("email"));
                obj.setTelefone(resultado.getString("telefone"));
                obj.setCelular(resultado.getString("celular"));
                obj.setCep(resultado.getString("cep"));
                obj.setEndereco(resultado.getString("endereco"));
                obj.setNumero(resultado.getInt("numero"));
                obj.setComplemento(resultado.getString("complemento"));
                obj.setBairro(resultado.getString("bairro"));
                obj.setCidade(resultado.getString("cidade"));
                obj.setEstado(resultado.getString("estado"));
            }
            stmt.close();
            return obj;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o fornecedor!!" + erro);
        }
        return null;
    }

    @Override
    public void Excluir(Fornecedores obj) {
        try {
            String sql = "DELETE FROM fornecedores WHERE id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor excluído!!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir fornecedor!!" + erro);
        }
    }

    @Override
    public ArrayList<Fornecedores> Listar() {
        ArrayList<Fornecedores> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM fornecedores";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Fornecedores obj = new Fornecedores();

                obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setCnpj(resultado.getString("cnpj"));
                obj.setEmail(resultado.getString("email"));
                obj.setTelefone(resultado.getString("telefone"));
                obj.setCelular(resultado.getString("celular"));
                obj.setCep(resultado.getString("cep"));
                obj.setEndereco(resultado.getString("endereco"));
                obj.setNumero(resultado.getInt("numero"));
                obj.setComplemento(resultado.getString("complemento"));
                obj.setBairro(resultado.getString("bairro"));
                obj.setCidade(resultado.getString("cidade"));
                obj.setEstado(resultado.getString("estado"));

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
    public ArrayList<Fornecedores> Filtrar(String nome) {
        ArrayList<Fornecedores> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM fornecedores WHERE nome LIKE ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Fornecedores obj = new Fornecedores();

                obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setCnpj(resultado.getString("cnpj"));
                obj.setEmail(resultado.getString("email"));
                obj.setTelefone(resultado.getString("telefone"));
                obj.setCelular(resultado.getString("celular"));
                obj.setCep(resultado.getString("cep"));
                obj.setEndereco(resultado.getString("endereco"));
                obj.setNumero(resultado.getInt("numero"));
                obj.setComplemento(resultado.getString("complemento"));
                obj.setBairro(resultado.getString("bairro"));
                obj.setCidade(resultado.getString("cidade"));
                obj.setEstado(resultado.getString("estado"));

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
    public Fornecedores BuscarCpf(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
