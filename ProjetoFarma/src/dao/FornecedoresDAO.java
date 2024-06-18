/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author vitor
 */
public class FornecedoresDAO {
    private Connection conexao;

    /**
     * Construtor 'ClienteDAO'. Conecta-se ao banco de dados ao ser instanciado.
     */
    public FornecedoresDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }

    /**
     * Método 'Salvar'. Insere um novo cliente no banco de dados.
     */
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

            JOptionPane.showMessageDialog(null, "Fornecedores salvo com sucesso!!");

        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o fornecedor!!" + erro);
        }
    }

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

    /**
     * Método 'BuscaCliente'. Busca um cliente pelo nome no banco de dados.
     */
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
            return obj;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o fornecedor!!" + erro);
        }
        return null;
    }

    public void Excluir(Fornecedores obj) {
        try {
            String sql = "DELETE FROM fornecedores WHERE id = ?";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, obj.getId());
            
            stmt.execute();
            
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Fornecedor exluido!!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao exluir fornecedor!!" + erro);
        }
    }

    /**
     * Método 'Listar'. Retorna uma lista de todos os clientes do banco de
     * dados.
     */
    public List<Fornecedores> Listar() {
        List<Fornecedores> lista = new ArrayList<>();

        try {

            String sql = "SELECt * FROM fornecedores";

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
    public List<Fornecedores> Filtrar(String nome) {
        List<Fornecedores> lista = new ArrayList<>();

        try {

            String sql = "SELECT * FROM fornecedores WHERE nome LIKE ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, nome);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Fornecedores obj = new Fornecedores();

                obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setRg(resultado.getString("cnpj"));
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
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista!!" + erro);
        }
        return null;
    }
}
