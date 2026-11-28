package ec.edu.uce.pa.grupo.u2.pedidos.application;
//Se crea una clase por cada entidad

import java.util.List;
import java.util.Optional;

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

    public Optional<Pedido> buscarPorId(Integer id){
        return this.pedidoRepository.read(id);
    }

    public Optional<Pedido> buscarPorNumero(String numero){
        return this.pedidoRepository.readByNumber(numero);
    }

    public void actualizar(Pedido pedido){
        this.pedidoRepository.update(pedido);
    }

    public void eliminar(Integer id){
        this.pedidoRepository.delete(id);
    }

    public List<Pedido> todo(){
        return this.pedidoRepository.readAll();
    }

    public Optional<Pedido> readNativeNumber(String numero){
        return this.pedidoRepository.readNativeNumber(numero);
    }

    public List<Pedido> readNativeAll() {
        return this.pedidoRepository.readNativeAll();
    }

}
