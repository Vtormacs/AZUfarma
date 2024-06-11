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

    public ClienteDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }
    
    
    public void Salvar(Cliente obj){
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
    
    public Cliente BuscaCliente(String nome){
        try {
            
            String sql = "SELECT * FROM clientes WHERE nome = ?";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, nome);
            
            ResultSet resultado = stmt.executeQuery();
            
            Cliente obj = new Cliente();
            
            if(resultado.next()){
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
    
    public List<Cliente>Listar(){
        List<Cliente> lista = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM clientes";
            
            /*String sql = "SELECT c.id, c.nome  "
                    + "FROM clientes c "
                    + "INNER JOIN sexo s "
                    + "ON c.sexo_id = s.id "
                    + "WHERE c.id  LIKE ? OR c.nome LIKE ? OR c.rg LIKE ? OR c.cpf LIKE ? OR s.nome LIKE ? OR c.endereco LIKE ? OR c.cep LIKE ? OR c.telefone LIKE ? OR c.email LIKE ?"
            
            String sql = "SELECT c.*, sexo.nome AS sexo_nome "
                    + "FROM clientes c "
                    + "INNER JOIN sexo s "
                    + "ON c.sexo_id = sexo.id";
            
            String sql = "SELECT c.id, c.nome, c.cpf, s.descricao AS sexo_nome, c.endereco, c.cep, c.telefone, c.email "
                   + "FROM clientes c "
                   + "JOIN sexo s ON c.sexo_id = s.id "
                   + "WHERE c.id  LIKE ? OR c.nome LIKE ? OR c.cpf LIKE ? OR s.descricao LIKE ? OR c.endereco LIKE ? OR c.cep LIKE ? OR c.telefone LIKE ? OR c.email LIKE ?";*/

            
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
    
    public List<Cliente>Filtrar(String nome){
        List<Cliente> lista = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM clientes WHERE nome LIKE ?";
            
            /*String sql = "SELECT c.id, c.nome  "
                    + "FROM clientes c "
                    + "INNER JOIN sexo s "
                    + "ON c.sexo_id = s.id "
                    + "WHERE c.id  LIKE ? OR c.nome LIKE ? OR c.rg LIKE ? OR c.cpf LIKE ? OR s.nome LIKE ? OR c.endereco LIKE ? OR c.cep LIKE ? OR c.telefone LIKE ? OR c.email LIKE ?"
            
            String sql = "SELECT c.*, sexo.nome AS sexo_nome "
                    + "FROM clientes c "
                    + "INNER JOIN sexo s "
                    + "ON c.sexo_id = sexo.id";
            
            String sql = "SELECT c.id, c.nome, c.cpf, s.descricao AS sexo_nome, c.endereco, c.cep, c.telefone, c.email "
                   + "FROM clientes c "
                   + "JOIN sexo s ON c.sexo_id = s.id "
                   + "WHERE c.id  LIKE ? OR c.nome LIKE ? OR c.cpf LIKE ? OR s.descricao LIKE ? OR c.endereco LIKE ? OR c.cep LIKE ? OR c.telefone LIKE ? OR c.email LIKE ?";*/

            
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
