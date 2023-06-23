package EjemploInterfaces;

public abstract class Publicacion {
    private int idPublicacion;
    private String titulo;
    private int anioPublicacion;

    public Publicacion(int idPublicacion, String titulo, int anioPublicacion) {
        this.idPublicacion = idPublicacion;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    
    public abstract TipoPublicacion getTipoPublicacion();
}
