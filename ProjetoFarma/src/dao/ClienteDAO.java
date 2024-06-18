package dao;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import model.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ClienteDAO implements DAOInterface<Cliente> {

    private Connection conexao;

    public ClienteDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }

    @Override
    public void Salvar(Cliente obj) {
        try {
            String sql = "INSERT INTO clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado,sexo_id) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,(select id from sexo where nome = ?))";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            stmt.setString(14, obj.getNomeSexo());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!!");

        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente!!" + erro);
        }
    }

    @Override
    public void Editar(Cliente obj) {
        try {
            String sql = "UPDATE clientes SET nome =?,rg = ?, cpf = ?,email = ?,telefone = ?,celular = ?,cep = ?,endereco = ?,numero = ?,complemento = ?,bairro = ?,cidade = ?,estado = ?, sexo_id = (SELECT id FROM sexo WHERE nome = ?) "
                    + "WHERE id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            stmt.setString(14, obj.getNomeSexo());
            stmt.setInt(15, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!!");

        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o cliente!!" + erro);
        }
    }

    @Override
    public Cliente Buscar(String nome) {
        try {
            String sql = "SELECT c.id, c.nome,c.rg,c.cpf,c.email,c.telefone,c.celular,c.cep,c.endereco,c.numero,c.complemento,c.bairro,c.cidade,c.estado,s.nome as nome_sexo "
                    + "FROM clientes AS c "
                    + "LEFT JOIN sexo AS s ON (s.id = c.sexo_id) "
                    + "WHERE c.nome = ? ";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet resultado = stmt.executeQuery();
            Cliente obj = new Cliente();

            if (resultado.next()) {
                obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setRg(resultado.getString("rg"));
                obj.setCpf(resultado.getString("cpf"));
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
                obj.setNomeSexo(resultado.getString("nome_sexo"));

                JOptionPane.showMessageDialog(null, "Cliente encontrado!!");
            }
            stmt.close();
            return obj;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o cliente!!" + erro);
        }
        return null;
    }

    @Override
    public void Excluir(Cliente obj) {
        try {
            String sql = "DELETE FROM clientes WHERE id = ?";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente excluído!!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente!!" + erro);
        }
    }

    @Override
    public ArrayList<Cliente> Listar() {
        ArrayList<Cliente> lista = new ArrayList<>();

        try {
            String sql = """
                         SELECT c.id, c.nome, c.rg, c.cpf,s.nome AS nome_sexo, c.email, c.telefone, c.celular, c.cep, c.endereco, c.numero, c.complemento, c.bairro, c.cidade, c.estado
                         FROM clientes AS c
                         LEFT JOIN sexo AS s ON (s.id = c.sexo_id)""";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Cliente obj = new Cliente();

                obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setRg(resultado.getString("rg"));
                obj.setCpf(resultado.getString("cpf"));
                obj.setNomeSexo(resultado.getString("nome_sexo"));
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
    public ArrayList<Cliente> Filtrar(String nome) {
        ArrayList<Cliente> lista = new ArrayList<>();

        try {
            String sql = """
                         SELECT c.id, c.nome, c.rg, c.cpf,s.nome AS nome_sexo, c.email, c.telefone, c.celular, c.cep, c.endereco, c.numero, c.complemento, c.bairro, c.cidade, c.estado
                         FROM clientes AS c
                         LEFT JOIN sexo AS s ON (s.id = c.sexo_id)
                         WHERE c.nome LIKE ?""";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Cliente obj = new Cliente();

                obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setRg(resultado.getString("rg"));
                obj.setCpf(resultado.getString("cpf"));
                obj.setNomeSexo(resultado.getString("nome_sexo"));
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
}
