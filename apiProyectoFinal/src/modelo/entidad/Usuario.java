package modelo.entidad;
// Generated May 4, 2023 2:34:16 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,catalog="farmacia"
)
public class Usuario  implements java.io.Serializable {


     private Integer idUsuario;
     private String nombre;
     private String apellido;
     private String username;
     private String password;
     private Set<Receta> recetas = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String nombre, String apellido, String username, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
    }
    public Usuario(String nombre, String apellido, String username, String password, Set recetas) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.username = username;
       this.password = password;
       this.recetas = recetas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idUsuario", unique=true, nullable=false)
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    @Column(name="nombre", nullable=false)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido", nullable=false)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="username", nullable=false)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set<Receta> getRecetas() {
        return this.recetas;
    }
    
    public void setRecetas(Set<Receta> recetas) {
        this.recetas = recetas;
    }




}


