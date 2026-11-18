package ec.edu.uce.pa.grupo.u2.pedidos.domain.model;

public class Pago {
    private Integer id;
    private String metodoPago;
    private Double monto;
    private String estado;
    private Pedido pedido;

    public Pago(){
        
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
    public Double getMonto() {
        return monto;
    }
    public void setMonto(Double monto) {
        this.monto = monto;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }



}
