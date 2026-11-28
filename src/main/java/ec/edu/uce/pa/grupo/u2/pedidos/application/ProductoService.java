package ec.edu.uce.pa.grupo.u2.pedidos.application;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Producto;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.PedidoRepository;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.ProductoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped 
@Transactional // Se indica que los métodos de esta clase se ejecutarán dentro de una transacción
public class ProductoService {

    @Inject 
    private ProductoRepository productoRepository;

    public void guardar(Producto producto){
        this.productoRepository.create(producto);
    }

    public Pedido buscarPorId(Integer id){
        return this.productoRepository.read(id);
    }

    public void actualizar(Producto producto){
        this.productoRepository.update(producto);
    }

    public void eliminar(Integer id){
        this.productoRepository.delete(id);
    }

}