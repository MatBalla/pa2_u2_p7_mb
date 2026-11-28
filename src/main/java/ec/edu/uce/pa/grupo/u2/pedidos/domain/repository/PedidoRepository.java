package ec.edu.uce.pa.grupo.u2.pedidos.domain.repository;
//Define los métodos para interctuar con la Entidad
//Por cada entidad un repositorio

import java.util.List;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;

public interface PedidoRepository {
    
    //Create
    public void create(Pedido pedido);

    //Read por id
    public Optional<Pedido> read(Integer id);

    public Optional<Pedido> readByNumber(String numero);

    public List<Pedido> readAll();

    //Update
    public void update(Pedido pedido);

    //Delete
    public void delete(Integer id);

    //Native
    public Optional<Pedido> readNativeNumber(String numero);

    public List<Pedido> readNativeAll();

    


}
