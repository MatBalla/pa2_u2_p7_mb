package ec.edu.uce.pa.grupo.u2;

import java.time.LocalDateTime;

import ec.edu.uce.pa.grupo.u2.pedidos.application.PedidoService;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class Main implements QuarkusApplication{
    @Inject 
    private PedidoService pedidoService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Quarkus creado");

        //CREATE(guardar)
        Pedido pedido = new Pedido();
        pedido.setProducto("Producto de prueba");
        pedido.setPrecio(500.0);
        pedido.setFecha(LocalDateTime.now());
        this.pedidoService.guardar(pedido);

        //READ(buscar)
        Pedido pedido1 = this.pedidoService.buscarPorId(4);
        System.out.println("Pedido encontrado: " + pedido1);

        //UPDATE (actualizar)
        pedido1.setPrecio(400.0);
        this.pedidoService.actualizar(pedido);

        //DELETE(borrar)
        this.pedidoService.eliminar(pedido.getId());

        return 0;
    }

}
