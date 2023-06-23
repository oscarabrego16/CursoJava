/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasecurso1.poo;

/**
 *
 * @author oara1
 */
public class Trabajador {
   private int codigo;
   private String nombre;
   private String apellido;
   private float sueldoMensual;
   private float descuentoIsss;
   private float descuentoAfp;
   private float descuentoIsr;
   private float totalDescuentos;
   private float totalPagar;

    public Trabajador() {
        this.sueldoMensual=0;
        this.descuentoAfp=0;
        this.descuentoIsr=0;
        this.descuentoIsss=0;
        this.totalDescuentos=0;
        this.totalPagar=0;
    }

    public Trabajador(int codigo, String nombre, String apellido, float sueldoMensual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldoMensual = sueldoMensual;
        this.calcular();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public float getSueldoMensual() {
        return sueldoMensual;
    }

    public float getDescuentoIsss() {
        return descuentoIsss;
    }

    public float getDescuentoAfp() {
        return descuentoAfp;
    }

    public float getDescuentoIsr() {
        return descuentoIsr;
    }

    public float getTotalDescuentos() {
        return totalDescuentos;
    }

    public float getTotalPagar() {
        return totalPagar;
    }
    
    public void calcular(){
        if(this.sueldoMensual >= 0 && this.sueldoMensual <=CONSTANTES.TECHOISS){
        this.descuentoIsss = this.sueldoMensual* 0.03f;
    }else{
            this.descuentoIsss=30;
        }
        
        if(this.sueldoMensual >=0 && this.sueldoMensual <=CONSTANTES.TECHOAFP){
            this.descuentoAfp = this.sueldoMensual *0.0725f;
        }else{
            //aplicado directo sobre el limite
            this.descuentoAfp= 510.77f;
        }
        
        //renta
        float ri = this.sueldoMensual - (this.descuentoAfp + this.descuentoIsss);
        if(ri >0 && ri <=472){
            this.descuentoIsr=0;
        }else{
            if(ri > 472 && ri<=895.24){
                this.descuentoIsr = (ri - 472)*0.1f + 17.67f;
            }else{
                if(ri > 895.24 && ri <= 2038.1){
                    this.descuentoIsr= (ri - 895.24f)*0.2f + 60;
                }else{
                    this.descuentoIsr= (ri - 2038.1f)*0.3f + 288.57f;
                }
            }
        }
        
        this.totalDescuentos = this.descuentoAfp+this.descuentoIsr+this.descuentoIsss;
        this.totalPagar= this.sueldoMensual - this.totalDescuentos;
    }
   
}
