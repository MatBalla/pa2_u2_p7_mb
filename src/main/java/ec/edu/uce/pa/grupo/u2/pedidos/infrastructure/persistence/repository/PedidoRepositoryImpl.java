package ec.edu.uce.pa.grupo.u2.pedidos.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

//Se prgorama el CRUD, a travez de una interfaz
@ApplicationScoped 
public class PedidoRepositoryImpl implements PedidoRepository {

    @Inject 
    private EntityManager entityManager; // Inyección de la instancia de EntityManager para interactuar con la base de datos

    //Create
    public void create(Pedido pedido) {
        // Implementación de la lógica para crear un pedido en la base de datos
        this.entityManager.persist(pedido); // persist = insertar un registro en la base de datos

    }

    //Read por id
    public Optional<Pedido> read(Integer id) {
        // Implementación de la lógica para leer un pedido por su ID desde la base de datos
        Pedido pedido = this.entityManager.find(Pedido.class, id); 
        return  Optional.ofNullable(pedido);// find = buscar un registro en la base de datos por su ID
    }

    //Update
    public void update(Pedido pedido) {
        // Implementación de la lógica para actualizar un pedido en la base de datos

        this.entityManager.merge(pedido); // merge = actualizar un registro en la base de datos 

    }

    //Delete
    public void delete(Integer id) {
        // Implementación de la lógica para eliminar un pedido por su ID desde la base de datos
        
        Optional<Pedido> pedido = this.read(id); //se llama al metodom read para obtener el pedido a eliminar
        pedido.ifPresent(this.entityManager::remove);// remove = eliminar un registro en la base de datos por su ID

    }

     @Override
    public Optional<Pedido> readByNumber(String numero) {
        //Consulta jpql
        TypedQuery<Pedido> query = this.entityManager.createQuery("SELECT p FROM Pedido p WHERE p.numero = :numeroVariable", Pedido.class);
        query.setParameter("numeroVariable", numero);
        return Optional.ofNullable(query.getSingleResult());

    }

    @Override
    public List<Pedido> readAll() {
        return null;
    }

}
