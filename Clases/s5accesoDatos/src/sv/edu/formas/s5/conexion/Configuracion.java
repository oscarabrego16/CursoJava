package sv.edu.formas.s5.conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracion {
    private Properties propiedades;
    private InputStream entrada;
    
    public Configuracion(String archivo){
        String rutaProyecto = new File("").getAbsolutePath()+"\\"+ archivo;//devuelve ruta proyecto
        System.out.println(rutaProyecto);
        this.propiedades= new Properties();
        try {
            this.entrada= new FileInputStream(rutaProyecto);
            System.out.println(this.entrada);
            this.propiedades.load(this.entrada);
            System.setProperty("driver", this.propiedades.getProperty("driver"));
            System.setProperty("usuario", this.propiedades.getProperty("usuario"));
            System.setProperty("clave", this.propiedades.getProperty("clave"));
            System.setProperty("url", this.propiedades.getProperty("url"));
        } catch (IOException e) {
            System.out.println("");
        }
    }
}
