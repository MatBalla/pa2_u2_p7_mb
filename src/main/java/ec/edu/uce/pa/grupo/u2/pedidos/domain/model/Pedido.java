package ec.edu.uce.pa.grupo.u2.pedidos.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity //la enmtidad es administrada por Jakarta Persistence Api
@Table (name = "pedidos") //nombre de la tabla en la bdd
public class Pedido {


    @Id //Primary key para el id
    @SequenceGenerator (name="pedido_seq", sequenceName = "pedido_seq_db", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "pedido_seq") //generar el id de manera automatica
    @Column (name = "pedd_id")//nombre de la columna de la bdd
    private Integer id;

    @Column (name ="pedd_producto")
    private String producto;

    @Column (name = "pedd_precio")
    private Double precio;

    @Column (name = "pedd_fecha")
    private LocalDateTime fecha;


    public Pedido(){
        
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
