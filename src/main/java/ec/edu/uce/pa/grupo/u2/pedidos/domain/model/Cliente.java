package ec.edu.uce.pa.grupo.u2.pedidos.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity 
@Table (name = "cliente")
public class Cliente {

    @Id //Primary key para el id
    @SequenceGenerator (name="cliente_seq", sequenceName = "cliente_seq_db", allocationSize = 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "cliente_seq") //generar el id de manera automatica
    @Column (name = "cli_id")//nombre de la columna de la bdd
    private Integer id;

    @Column (name ="cli_nombre")
    private String nombre;

    @Column (name = "cli_correo")
    private String correo;

    @Column (name = "cli_telefono")
    private String telefono;

    @Column (name = "cli_direccion")
    private String direccion;

    
    public Cliente (){

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
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
