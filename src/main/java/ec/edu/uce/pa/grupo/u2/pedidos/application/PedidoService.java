package ec.edu.uce.pa.grupo.u2.pedidos.application;
//Se crea una clase por cada entidad

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped 
@Transactional // Se indica que los métodos de esta clase se ejecutarán dentro de una transacción
public class PedidoService {

    @Inject 
    private PedidoRepository pedidoRepository;

    public void guardar(Pedido pedido){
        this.pedidoRepository.create(pedido);
    }

    public Pedido buscarPorId(Integer id){
        return this.pedidoRepository.read(id);
    }

    public void actualizar(Pedido pedido){
        this.pedidoRepository.update(pedido);
    }

    public void eliminar(Integer id){
        this.pedidoRepository.delete(id);
    }

}
