package EjemploClasesAbstractas;

public class TrabajadorTiempoCompleto extends Trabajador{
    private float descuentoIsss;
    private float descuentoAfp;
    
    
    public TrabajadorTiempoCompleto(int c, String n, String a, float sueldoMensual) {
        super(c, n, a);
        super.sueldoMensual=sueldoMensual;
        this.Calcular();
    }

    public float getDescuentoIss() {
        return descuentoIsss;
    }

    public float getDescuentoAfp() {
        return descuentoAfp;
    }
    
    
    private void Calcular(){
    if(super.sueldoMensual >= 0 && super.sueldoMensual <=CONSTANTES.TECHOISS){
        this.descuentoIsss = super.sueldoMensual* 0.03f;
    }else{
            this.descuentoIsss=30;
        }
        
        if(super.sueldoMensual >=0 && super.sueldoMensual <=CONSTANTES.TECHOAFP){
            this.descuentoAfp = super.sueldoMensual *0.0725f;
        }else{
            //aplicado directo sobre el limite
            this.descuentoAfp= 510.77f;
        }
        
        //renta
        float ri = super.sueldoMensual - (this.descuentoAfp + this.descuentoIsss);
        if(ri >0 && ri <=472){
            super.descuentoIsr=0;
        }else{
            if(ri > 472 && ri<=895.24){
                super.descuentoIsr = (ri - 472)*0.1f + 17.67f;
            }else{
                if(ri > 895.24 && ri <= 2038.1){
                    super.descuentoIsr= (ri - 895.24f)*0.2f + 60;
                }else{
                    super.descuentoIsr= (ri - 2038.1f)*0.3f + 288.57f;
                }
            }
        }
        
        this.totalDescuentos = this.descuentoAfp+this.descuentoIsr+this.descuentoIsss;
        super.totalPagar= super.sueldoMensual - this.totalDescuentos;
    }

    
    @Override
    public TipoTrabajador getTipoTrabajador() {
        return TipoTrabajador.TRABAJADOR_TIEMPO_COMPLETO;
    }
    
    @Override
    public String toString(){
        String contenido = super.toString() + "\n";
        contenido += " descuento seguro "+ this.descuentoIsss;
        contenido += "\n descuento afp "+this.descuentoAfp;
        contenido += "\n descuento seguro "+this.descuentoIsr;
        contenido += "\n total a pagar "+this.totalPagar;
        return contenido;
    }
    
}
