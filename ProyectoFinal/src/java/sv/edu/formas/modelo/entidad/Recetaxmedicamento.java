package sv.edu.formas.modelo.entidad;
// Generated May 3, 2023 9:58:32 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Recetaxmedicamento generated by hbm2java
 */
@Entity
@Table(name="recetaxmedicamento"
    ,catalog="farmacia"
)
public class Recetaxmedicamento  implements java.io.Serializable {


     private Integer idDetalle;
     private Medicamento medicamento;
     private Receta receta;
     private int cantidad;

    public Recetaxmedicamento() {
    }

    public Recetaxmedicamento(Medicamento medicamento, Receta receta, int cantidad) {
       this.medicamento = medicamento;
       this.receta = receta;
       this.cantidad = cantidad;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idDetalle", unique=true, nullable=false)
    public Integer getIdDetalle() {
        return this.idDetalle;
    }
    
    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idMedicamento", nullable=false)
    public Medicamento getMedicamento() {
        return this.medicamento;
    }
    
    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idReceta", nullable=false)
    public Receta getReceta() {
        return this.receta;
    }
    
    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    
    @Column(name="cantidad", nullable=false)
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }




}


