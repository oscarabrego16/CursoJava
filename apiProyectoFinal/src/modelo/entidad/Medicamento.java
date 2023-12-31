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
 * Medicamento generated by hbm2java
 */
@Entity
@Table(name="medicamento"
    ,catalog="farmacia"
)
public class Medicamento  implements java.io.Serializable {


     private Integer idMedicamento;
     private String nombre;
     private String laboratorio;
     private String activo;
     
     private Set<Recetaxmedicamento> recetaxmedicamentos = new HashSet(0);

    public Medicamento() {
    }

	
    public Medicamento(String nombre, String laboratorio, String activo) {
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.activo = activo;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idMedicamento", unique=true, nullable=false)
    public Integer getIdMedicamento() {
        return this.idMedicamento;
    }
    
    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    
    @Column(name="nombre", nullable=false)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="laboratorio", nullable=false)
    public String getLaboratorio() {
        return this.laboratorio;
    }
    
    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    
    @Column(name="activo", nullable=false)
    public String getActivo() {
        return this.activo;
    }
    
    public void setActivo(String activo) {
        this.activo = activo;
    }

    

@OneToMany(fetch=FetchType.LAZY, mappedBy="medicamento")
    public Set<Recetaxmedicamento> getRecetaxmedicamentos() {
        return this.recetaxmedicamentos;
    }
    
    public void setRecetaxmedicamentos(Set<Recetaxmedicamento> recetaxmedicamentos) {
        this.recetaxmedicamentos = recetaxmedicamentos;
    }




}


