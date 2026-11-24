package ec.edu.uce.pa.grupo.u2.pedidos.application;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.DetallePedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.DetallePedidoRepository;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped 
@Transactional // Se indica que los métodos de esta clase se ejecutarán dentro de una transacción
public class DetallePedidoService {

    @Inject 
    private DetallePedidoRepository detallePedidoRepository;

    public void guardar(DetallePedido detallePedido){
        this.detallePedidoRepository.create(detallePedido);
    }

    public Pedido buscarPorId(Integer id){
        return this.detallePedidoRepository.read(id);
    }

    public void actualizar(DetallePedido detallePedido){
        this.detallePedidoRepository.update(detallePedido);
    }

    public void eliminar(Integer id){
        this.detallePedidoRepository.delete(id);
    }

}
