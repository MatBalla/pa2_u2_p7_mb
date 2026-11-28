package ec.edu.uce.pa.grupo.u2.pedidos.application;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pago;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.PagoRepository;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped 
@Transactional // Se indica que los métodos de esta clase se ejecutarán dentro de una transacción
public class PagoService {

    @Inject 
    private PagoRepository pagoRepository;

    public void guardar(Pago pago){
        this.pagoRepository.create(pago);
    }

    public Pedido buscarPorId(Integer id){
        return this.pagoRepository.read(id);
    }

    public void actualizar(Pago pago){
        this.pagoRepository.update(pago);
    }

    public void eliminar(Integer id){
        this.pagoRepository.delete(id);
    }

}
