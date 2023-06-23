package EjemploInterfaces;


public class Revista extends Publicacion {
    private int numeroRevista;
    public Revista(int idPublicacion, String titulo, int anioPublicacion, int nr) {
        super(idPublicacion, titulo, anioPublicacion);
        this.numeroRevista= nr;
    }

    @Override
    public TipoPublicacion getTipoPublicacion() {
        return TipoPublicacion.REVISTA;
    }
    
    
    
}
