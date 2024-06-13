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

public class ClienteDAO {

    private Connection conexao;

    /**
     * Construtor 'ClienteDAO'. Conecta-se ao banco de dados ao ser instanciado.
     */
    public ClienteDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }

    /**
     * Método 'Salvar'. Insere um novo cliente no banco de dados.
     */
    public void Salvar(Cliente obj) {
        try {
            String sql = "INSERT INTO clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado,sexo_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
            stmt.setInt(14, obj.getSexo_id());

            stmt.execute();

            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!!");

        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o cliente!!" + erro);
        }
    }

    /**
     * Método 'BuscaCliente'. Busca um cliente pelo nome no banco de dados.
     */
    public Cliente BuscaCliente(String nome) {
        try {

            String sql = "SELECT * FROM clientes WHERE nome = ?";

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
                obj.setSexo_id(resultado.getInt("sexo_id"));

                JOptionPane.showMessageDialog(null, "Cliente encontrado!!");
            }
            return obj;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o cliente!!" + erro);
        }
        return null;
    }

    /**
     * Método 'Listar'. Retorna uma lista de todos os clientes do banco de
     * dados.
     */
    public List<Cliente> Listar() {
        List<Cliente> lista = new ArrayList<>();

        try {

            String sql = "SELECT * FROM clientes";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Cliente obj = new Cliente();

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
                obj.setSexo_id(resultado.getInt("sexo_id"));

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
    public List<Cliente> Filtrar(String nome) {
        List<Cliente> lista = new ArrayList<>();

        try {

            String sql = "SELECT * FROM clientes WHERE nome LIKE ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nome);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Cliente obj = new Cliente();

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
                obj.setSexo_id(resultado.getInt("sexo_id"));

                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista!!" + erro);
        }
        return null;
    }

}
