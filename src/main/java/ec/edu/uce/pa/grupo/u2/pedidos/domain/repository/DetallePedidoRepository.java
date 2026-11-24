package ec.edu.uce.pa.grupo.u2.pedidos.domain.repository;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.DetallePedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;

public interface DetallePedidoRepository {
//Create
    public void create(DetallePedido detallePedido);

    //Read por id
    public Pedido read(Integer id);

    //Update
    public void update(DetallePedido detallePedido);

    //Delete
    public void delete(Integer id);
}
