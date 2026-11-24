package ec.edu.uce.pa.grupo.u2;

import java.time.LocalDateTime;

import ec.edu.uce.pa.grupo.u2.pedidos.application.ClienteService;
import ec.edu.uce.pa.grupo.u2.pedidos.application.DetallePedidoService;
import ec.edu.uce.pa.grupo.u2.pedidos.application.PagoService;
import ec.edu.uce.pa.grupo.u2.pedidos.application.PedidoService;
import ec.edu.uce.pa.grupo.u2.pedidos.application.ProductoService;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Cliente;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.DetallePedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pago;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Pedido;
import ec.edu.uce.pa.grupo.u2.pedidos.domain.model.Producto;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain 
public class Main implements QuarkusApplication{
    @Inject 
    private PedidoService pedidoService;

    @Inject 
    private ClienteService clienteService;

    @Inject 
    private DetallePedidoService detallePedidoService;

    @Inject 
    private PagoService pagoService;

    @Inject 
    private ProductoService productoService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Quarkus creado");

        Pedido pedido = new Pedido();
        pedido.setProducto("Producto de prueba");
        pedido.setPrecio(100.0);
        pedido.setFecha(LocalDateTime.now());

        this.pedidoService.guardar(pedido);
        ///////////////////////////////////////////////
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setCorreo("juan@gmail.com");
        cliente.setDireccion("Calderon");
        cliente.setTelefono("091231313");

        this.clienteService.guardar(cliente);
        /////////////////////////////////////////////
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setPais("Ecuador");
        detallePedido.setCiudad("Tabacundo");
        detallePedido.setCantidad(4);
        detallePedido.setPrecioUnitario(10.0);

        this.detallePedidoService.guardar(detallePedido);
        ///////////////////////////////////////////////
        Pago pago = new Pago();
        pago.setEstado("Pagado");
        pago.setFechaPago("22/11/2026");
        pago.setMetodoPago("Paypal");
        pago.setMonto(400.0);

        this.pagoService.guardar(pago);
        ////////////////////////////////////////////
        Producto producto = new Producto();
        producto.setNombre("Play Station 5");
        producto.setCantidad(2);
        producto.setPrecio(1600.0);
        producto.setDescripcion("Consola de videojuegos");

        this.productoService.guardar(producto);

        
        return 0;
    }

}
