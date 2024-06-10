package dao;

import java.sql.Connection;
import model.Cliente;

public class ClienteDAO {
    private Connection conectar;

    public ClienteDAO() {
        this.conectar = new ConexaoBanco().conectarComBanco();
    }
    
    public void Salvar(Cliente obj){
        try {
            String sql = "INSERT INTO tb_clientes (nome,rb,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado,sexo_id)";
        } catch (Exception e) {
        }
    }
}
