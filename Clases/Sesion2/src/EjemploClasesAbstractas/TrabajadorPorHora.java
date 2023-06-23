/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploClasesAbstractas;

public class TrabajadorPorHora extends Trabajador{

    private float sueldoPorHora;
    private int numHorasTrab;
    
    public TrabajadorPorHora(int c, String n, String a, float sh, int nht) {
        super(c, n, a);
        this.sueldoPorHora=sh;
        this.numHorasTrab=nht;
        this.Calcular();
    }
    
    private void Calcular(){
        super.sueldoMensual= this.sueldoPorHora*this.numHorasTrab;
        super.descuentoIsr= super.sueldoMensual*0.1f;
        super.totalDescuentos = super.descuentoIsr;
        super.totalPagar = super.sueldoMensual- super.totalDescuentos;
                
    }

    @Override
    public TipoTrabajador getTipoTrabajador() {
        return TipoTrabajador.TRABAJADOR_POR_HORA;
    }
    
    @Override
        public String toString(){
        String contenido = super.toString() + "\n";
        contenido += "\n total a pagar "+super.totalPagar;
        return contenido;
    }
    
}
