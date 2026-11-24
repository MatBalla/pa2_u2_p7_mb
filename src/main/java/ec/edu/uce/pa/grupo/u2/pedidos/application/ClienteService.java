package ec.edu.uce.pa.grupo.u2.pedidos.application;

import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Cliente;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.ClienteRepository;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped 
@Transactional // Se indica que los métodos de esta clase se ejecutarán dentro de una transacción
public class ClienteService {

    @Inject 
    private ClienteRepository clienteRepository;

    public void guardar(Cliente cliente){
        this.clienteRepository.create(cliente);
    }

    public Pedido buscarPorId(Integer id){
        return this.clienteRepository.read(id);
    }

    public void actualizar(Cliente cliente){
        this.clienteRepository.update(cliente);
    }

    public void eliminar(Integer id){
        this.clienteRepository.delete(id);
    }

}

