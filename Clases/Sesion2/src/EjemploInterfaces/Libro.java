/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploInterfaces;

/**
 *
 * @author oara1
 */
public class Libro extends Publicacion implements Prestable{
    private boolean estado;
    public Libro(int idPublicacion, String titulo, int anioPublicacion) {
        super(idPublicacion, titulo, anioPublicacion);
        this.estado= false; //estadod e prestamo falso
    }

    @Override
    public TipoPublicacion getTipoPublicacion() {
        return TipoPublicacion.LIBRO;
    }

    @Override
    public void Prestar() {
        this.estado= true;
    }

    @Override
    public void Devolver() {
        this.estado=false;
    }

    @Override
    public boolean estadoPrestamo() {
        return this.estado;
    }
    
}
