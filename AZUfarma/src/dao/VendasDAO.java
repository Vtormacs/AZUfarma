package dao;

import java.sql.Connection;
import model.Vendas;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class VendasDAO {
    private Connection conexao;

    public VendasDAO() {
        this.conexao = new ConexaoBanco().conectarComBanco();
    }
    
    public void salvar (Vendas obj){
        try {
            String sql = "INSERT INTO vendas (cliente_id,data_venda,total_venda,observacoes) "
                    + "VALUES (?,?,?,?)";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getDataVenda());
            stmt.setDouble(3, obj.getTotalVenda());
            stmt.setString(4, obj.getObservacoes());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao realizar a venda" + e);
        }
    }
    
    public int retornaUltimoIdVenda(){
        try {
            int ultimoId = 0;
            
            String sql = "SELECT id FROM vendas "
                    + "ORDER BY vendas.id ASC";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                ResultSet resultado = stmt.executeQuery();
                
                while(resultado.next()){
                    Vendas v = new Vendas();
                    v.setId(resultado.getInt("id"));
                    ultimoId = v.getId();
                    
                }
                return ultimoId;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao retornar o ultimo id da venda" + e);
        }
    }
    
    public List<Vendas>historicoVendas(LocalDate dataInicio, LocalDate dataFim){
        try {
            List<Vendas> lista = new ArrayList<>();
            
            String sql = "SELECT v.id, c.nome, date_format(v.data_venda, '%d/%m/%Y') AS data_formatada, v.total_venda, v.observacoes "
                    + "FROM vendas AS v "
                    + "INNER JOIN clientes AS c "
                    + "ON (v.cliente_id = c.id) "
                    + "WHERE v.data_venda BETWEEN ? AND ?";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, dataInicio.toString());
            stmt.setString(2, dataFim.toString());
            ResultSet resultado = stmt.executeQuery();
            
            while (resultado.next()) {
                Vendas v =  new Vendas();
                Cliente c = new Cliente();
                
                v.setId(resultado.getInt("v.id"));
                c.setNome(resultado.getString("c.nome"));
                v.setCliente(c);
                v.setDataVenda(resultado.getString("data_formatada"));
                v.setTotalVenda(resultado.getDouble("v.total_venda"));
                v.setObservacoes(resultado.getString("v.observacoes"));
                
                lista.add(v);

            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar historico de vendas!!!" + e);
        }
    }
    
    public double posicaoDoCaixaDoDia(LocalDate dataVenda){
        
        try {
            double totalDoDia = 0.0;
            
            String sql = "SELECT SUM(total_venda)AS total "
                    + "FROM vendas "
                    + "WHERE data_venda = ? ";
            
             PreparedStatement stmt = conexao.prepareStatement(sql);
             stmt.setString(1, dataVenda.toString());
             ResultSet resultado = stmt.executeQuery();
             
             if(resultado.next()){
                 totalDoDia = resultado.getDouble("total");
             }
             return totalDoDia;     
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao retornar a pocição do dia!!!" + e);
        }
        
    }
    
}
