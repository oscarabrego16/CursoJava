package EjemploClasesAbstractas;

public abstract class Trabajador {
    //miembros jamas deberian ser publicos
    private int codigo;
    private String nombre;
    private String apellido; //utilizarse solo dentro de la clase
    protected float sueldoMensual; //puede ir hasta las clases derivadas
    protected float descuentoIsr;
    protected float totalDescuentos;
    protected float totalPagar;
    
    //metodos publicos e spara que sean accesibles al exterior.
    //meotodos protegidos, es que solo puede ser utilziado por sus clases derivadas
    //en una instancia no lo veriamos
    public Trabajador(int c, String n, String a){
        this.codigo=c;
        this.nombre=n;
        this.apellido=a;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getSueldoMensual() {
        return sueldoMensual;
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
    
    //para que la clase sea abstracta debe tener un metodo abstracto
    public abstract TipoTrabajador getTipoTrabajador();
    public String toString(){
        String cont= this.codigo+" "+ this.nombre+" "+this.apellido;
        cont += "\n Sueldo mensual "+this.sueldoMensual;
        cont += "\n Descuento renta "+this.descuentoIsr;
        return cont;
    }

}
