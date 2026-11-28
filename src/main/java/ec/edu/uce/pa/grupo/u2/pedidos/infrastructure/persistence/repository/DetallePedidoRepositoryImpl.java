package ec.edu.uce.pa.grupo.u2.pedidos.infrastructure.persistence.repository;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.DetallePedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.DetallePedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped 
public class DetallePedidoRepositoryImpl implements  DetallePedidoRepository{

   @Inject 
    private EntityManager entityManager; // Inyección de la instancia de EntityManager para interactuar con la base de datos

    //Create
    public void create(DetallePedido detallePedido) {
        // Implementación de la lógica para crear un pedido en la base de datos
        this.entityManager.persist(detallePedido); // persist = insertar un registro en la base de datos

    }

    //Read por id
    public Pedido read(Integer id) {
        // Implementación de la lógica para leer un pedido por su ID desde la base de datos
        
        return this.entityManager.find(Pedido.class, id); // find = buscar un registro en la base de datos por su ID
    }

    //Update
    public void update(DetallePedido detallePedido) {
        // Implementación de la lógica para actualizar un pedido en la base de datos

        this.entityManager.merge(detallePedido); // merge = actualizar un registro en la base de datos 

    }

    //Delete
    public void delete(Integer id) {
        // Implementación de la lógica para eliminar un pedido por su ID desde la base de datos
        
        Pedido pedido = this.read(id); //se llama al metodom read para obtener el pedido a eliminar
        this.entityManager.remove(pedido); // remove = eliminar un registro en la base de datos por su ID

    }

}
