package ec.edu.uce.pa.grupo.u2;

import java.time.LocalDateTime;
import java.util.List;
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
        Optional<Pedido> pedido = this.pedidoService.buscarPorId(5);
        if(pedido.isPresent()){
            System.out.println("Pedido encontrado por número:" + pedido.get());
            //Dentro de aqui se hacen las operaciones crud
            //this.pedidoService.eliminar(6); //eliminar por id
            
            //Actualizar un dato
            //Pedido pedidoEncontrado = pedido.get();
            //pedidoEncontrado.setNumero("5");
            //this.pedidoService.actualizar(pedidoEncontrado);
        }else{
            System.out.println("Pedido no enconrtado por número");
        }
        
        //READ BY NUMBER
        Optional<Pedido> pedidoByNumber = this.pedidoService.buscarPorNumero("5");
        if(pedidoByNumber.isPresent()){
            System.out.println("Pedido encontrado por número:" + pedidoByNumber.get());
        }else{
            System.out.println("Pedido no enconrtado por número");
        }

        //READ ALL
        List<Pedido> pedidoTotal = this.pedidoService.todo();
        System.out.println(pedidoTotal.toString());


        //READ BY NUMBER -> NATIVE
        Optional<Pedido> pedidoNumberN = this.pedidoService.readNativeNumber("5");
        if(pedidoNumberN.isPresent()){
            System.out.println("Pedido nativo encontrado por número:" + pedidoNumberN.get());
        }else{
            System.out.println("Pedido no enconrtado por número");
        }


        //READ ALL -> NATIVE
        List<Pedido> pedidoN = this.pedidoService.readNativeAll();
        System.out.println(pedidoN.toString());


        

        return 0;
    }

}
