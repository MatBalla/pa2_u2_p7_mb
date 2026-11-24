package ec.edu.uce.pa.grupo.u2;

import java.time.LocalDateTime;
import java.util.Optional;

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

        
        

        //READ(buscar)
        Optional<Pedido> pedido = this.pedidoService.buscarPorId(3);
        if(pedido.isPresent()){
            System.out.println("Pedido encontrado por número:" + pedido.get());
        }else{
            System.out.println("Pedido no enconrtado por número");
        }
        
        //READ BY NUMBER
        Optional<Pedido> pedidoByNumber = this.pedidoService.buscarPorNumero("PEDD-0001");
        if(pedidoByNumber.isPresent()){
            System.out.println("Pedido encontrado por número:" + pedidoByNumber.get());
        }else{
            System.out.println("Pedido no enconrtado por número");
        }

        //pedidoByNumber.setPrecio(400.0);
        //this.pedidoService.actualizar(pedido);

        return 0;
    }

}
