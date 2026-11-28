package ec.edu.uce.pa.grupo.u2.pedidos.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
        //createQuery(Consulta, Objeto)
        TypedQuery<Pedido> query = this.entityManager.createQuery("SELECT p FROM Pedido p WHERE p.numero = :numeroVariable", Pedido.class);
        //setParameter(nombre_variable, valorVariable);
        //permite reeemplazar en mi jpql una variable que he declarado por una variable que he declarado en el método
        query.setParameter("numeroVariable", numero);
        //return query.getSingleResult();
        //return query.getResultList().stream().findFirst();
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Pedido> readAll() {
        TypedQuery<Pedido> query = this.entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class);

        //devuelve todo
        return query.getResultList();
    }

    @Override
    public Optional<Pedido> readNativeNumber(String numero) {
        //Query se usa porque no se sabe con que se va a trabajkar
        Query mQuery = this.entityManager.createNativeQuery("SELECT * FROM Pedidos p WHERE p.pedd_numero = :numeroVariable", Pedido.class);
        mQuery.setParameter("numeroVariable", numero);
        return Optional.ofNullable((Pedido)mQuery.getSingleResult());
    }

    @Override
    public List<Pedido> readNativeAll() {
        Query Mquery = this.entityManager.createNativeQuery("SELECT * FROM Pedidos", Pedido.class);

        //devuelve todo
        return Mquery.getResultList();
    }

}
