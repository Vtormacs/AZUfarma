package dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Funcionario;
import view.Login;
import view.TelaPrincipal;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO implements DAOInterface<Funcionario> {

    private Connection conexao;

    public FuncionarioDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }

    public static String geradorSalt() {
        // Cria um array de bytes para armazenar o salt
        byte[] salt = new byte[16];

        // Cria uma instância de SecureRandom para gerar valores aleatórios
        SecureRandom secureRandom = new SecureRandom();
        // Gera bytes aleatórios e os armazena no array de salt
        secureRandom.nextBytes(salt);

        // Codifica o array de bytes em Base64 e retorna como uma string
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String senhaCriptografada(String senha, String salt) throws Exception {
        // Define o número de iterações e o comprimento da chave
        int iteracoes = 10000; // Você pode ajustar o número de iterações conforme necessário 
        int comprimento = 256; // Você pode ajustar o comprimento da chave conforme necessário

        // Cria um KeySpec com a senha, salt, número de iterações e comprimento da chave
        KeySpec keySpec = new PBEKeySpec(senha.toCharArray(), Base64.getDecoder().decode(salt), iteracoes, comprimento);
        // Obtém uma instância de SecretKeyFactory para o algoritmo PBKDF2WithHmacSHA256
        SecretKeyFactory gerandoSenhaCrip = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

        // Gera a chave secreta a partir do KeySpec e a codifica em um array de bytes
        byte[] chave = gerandoSenhaCrip.generateSecret(keySpec).getEncoded();

        // Codifica o array de bytes resultante em Base64 e retorna como uma string
        return Base64.getEncoder().encodeToString(chave);
    }

    public static boolean autenticacao(String senhaFornecida, String senhaArmazenada, String salt) throws Exception {
        // Criptografa a senha fornecida usando o salt armazenado
        String senhaNovaCriptografada = senhaCriptografada(senhaFornecida, salt);
        // Compara a senha criptografada recém-gerada com a senha armazenada
        return senhaNovaCriptografada.equals(senhaArmazenada);
    }

    @Override
    public void Salvar(Funcionario obj) {
        try {
            String sql = "INSERT INTO funcionarios(nome,rg,cpf,email,senha,cargo,nivel_acesso,celular,salt) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            String senhaNormal = obj.getSenha();
            String salt = geradorSalt();
            String senhaCrip = senhaCriptografada(senhaNormal, salt);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, senhaCrip);
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivelAcesso());
            stmt.setString(8, obj.getCelular());
            stmt.setString(9, salt);

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionario salvo com sucesso!!");
        } catch (HeadlessException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o funcionario!!" + erro);
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Editar(Funcionario obj) {
        try {
            String sql = "UPDATE funcionarios SET nome =?,rg = ?, cpf = ?,email = ?,cargo = ?,nivel_acesso = ?,celular = ? "
                    + "WHERE id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getCargo());
            stmt.setString(6, obj.getNivelAcesso());
            stmt.setString(7, obj.getCelular());
            stmt.setInt(8, obj.getId());

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
            String sql = "SELECT * FROM funcionarios "
                    + "ORDER BY `funcionarios`.`id` DESC ";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Funcionario obj = new Funcionario();

                obj.setId(resultado.getInt("id"));
                obj.setNome(resultado.getString("nome"));
                obj.setRg(resultado.getString("rg"));
                obj.setCpf(resultado.getString("cpf"));
                obj.setEmail(resultado.getString("email"));
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

    public void Login(String email, String senha) throws Exception {
        try {
            String sql = "SELECT senha, salt FROM funcionarios WHERE email = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);

            // Definir o valor do parâmetro de email na declaração preparada
            stmt.setString(1, email);

            // Executar a consulta e armazenar o resultado no ResultSet
            ResultSet resultado = stmt.executeQuery();

            // Verificar se a consulta retornou algum resultado
            if (resultado.next()) {
                // Recuperar a senha criptografada e o salt armazenados no banco de dados
                String senhaArmazenada = resultado.getString("senha");
                String saltArmazenado = resultado.getString("salt");

                // Verificar se a senha fornecida corresponde à senha armazenada usando o salt
                if (autenticacao(senha, senhaArmazenada, saltArmazenado)) {
                    // Se a autenticação for bem-sucedida, exibir mensagem de boas-vindas e abrir a tela principal
                    new TelaPrincipal().setVisible(true);
                    JOptionPane.showMessageDialog(null, "Seja bem vindo(a) ao sistema!!");
                } else {
                    // Se a autenticação falhar, exibir mensagem de erro e abrir a tela de login novamente
                    JOptionPane.showMessageDialog(null, "Dados inválidos!!");
                    new Login().setVisible(true);
                }
            } else {
                // Se nenhum resultado for retornado, exibir mensagem de erro e abrir a tela de login novamente
                JOptionPane.showMessageDialog(null, "Dados inválidos!!");
                new Login().setVisible(true);
            }

            // Fechar a declaração preparada
            stmt.close();
        } catch (SQLException erro) {
            // Se ocorrer um erro SQL, exibir mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro no funcionarioDAO " + erro);
        }
    }

    @Override
    public Funcionario BuscarCpf(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
