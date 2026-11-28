package ec.edu.uce.pa.grupo.u2.pedidos.domain.repository;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Producto;

public interface ProductoRepository {
//Create
    public void create(Producto producto);

    //Read por id
    public Pedido read(Integer id);

    //Update
    public void update(Producto producto);

    //Delete
    public void delete(Integer id);
}
