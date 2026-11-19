package ec.edu.uce.pa.grupo.u2.pedidos.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity 
@Table (name = "producto")
public class Producto {
    
    @Id //Primary key para el id
    @SequenceGenerator (name="producto_seq", sequenceName = "producto_seq_db", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "producto_seq") //generar el id de manera automatica
    @Column (name = "producto_id")//nombre de la columna de la bdd
    private Integer id;

    @Column (name ="producto_nombre")
    private String nombre;

    @Column (name = "producto_descripcion")
    private String descripcion;

    @Column (name = "producto_precio")
    private Double precio;

    @Column (name = "producto_cantidad")
    private Integer cantidad;

    public Producto(){

    }

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    

}
