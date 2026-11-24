package ec.edu.uce.pa.grupo.u2.pedidos.domain.repository;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pago;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;

public interface PagoRepository {
    //Create
    public void create(Pago pago);

    //Read por id
    public Pedido read(Integer id);

    //Update
    public void update(Pago pago);

    //Delete
    public void delete(Integer id);
}
