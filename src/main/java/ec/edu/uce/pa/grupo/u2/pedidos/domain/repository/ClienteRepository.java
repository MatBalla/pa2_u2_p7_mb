package ec.edu.uce.pa.grupo.u2.pedidos.domain.repository;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Cliente;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;

public interface ClienteRepository {
    //Create
    public void create(Cliente cliente);

    //Read por id
    public Pedido read(Integer id);

    //Update
    public void update(Cliente cliente);

    //Delete
    public void delete(Integer id);
}
