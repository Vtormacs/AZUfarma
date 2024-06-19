package dao;

import java.util.ArrayList;

public interface DAOInterface<ObjetoGenerico> {
    
    void Salvar(ObjetoGenerico obj);
    
    void Editar(ObjetoGenerico obj);
    
    void Excluir(ObjetoGenerico obj);
    
    ObjetoGenerico Buscar(String descricao);
    
    ObjetoGenerico BuscarCpf(String cpf);

    ArrayList<ObjetoGenerico> Listar();

    ArrayList<ObjetoGenerico> Filtrar(String descricao);    
}
