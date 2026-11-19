package ec.edu.uce.pa.grupo.u2.pedidos.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity 
@Table (name = "detalle_pedido")
public class DetallePedido {

    @Id //Primary key para el id
    @SequenceGenerator (name="detalle_pedido_seq", sequenceName = "detalle_pedido_seq_db", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "detalle_pedido_seq") //generar el id de manera automatica
    @Column (name = "dtll_id")//nombre de la columna de la bdd
    private Integer id;

    @Column (name ="dtll_cantidad")
    private Integer cantidad;

    @Column (name = "dtll_precio_unitario")
    private Double precioUnitario;

    @Column (name = "dtll_pais")
    private String pais;

    @Column (name = "dtll_ciudad")
    private String ciudad;


    public DetallePedido(){
        
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }



}
