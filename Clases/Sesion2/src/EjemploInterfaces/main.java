package EjemploInterfaces;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class main {
    static int menu(){
        int op;
    String mensaje = "Menu de opciones \n";
    mensaje += "1. Agregar publicacion\n";
    mensaje += "2. Prestar libros\n";
    mensaje += "3. Devolver libros\n";
            mensaje += "4. Lista publicaciones\n";
            mensaje += "5. Salir\n";
            mensaje += "Digite la opcion\n";
            op = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            return op;
    }
    
    static Publicacion agregarPublicacion(){
        Publicacion pub;
        int id, ap, nr, tipo;
        String titulo;
        tipo = Integer.parseInt(JOptionPane.showInputDialog("Tipo 1. Libro 2. Revista"));
        if(tipo==1){
            id = Integer.parseInt(JOptionPane.showInputDialog("Digite id de libro"));
            titulo = JOptionPane.showInputDialog("Digite el titulo de libro");
            ap = Integer.parseInt(JOptionPane.showInputDialog("Digite el anio de publicacion"));
            pub = new Libro(id, titulo, ap);
        }else{
            id = Integer.parseInt(JOptionPane.showInputDialog("Digite id de la revista"));
            titulo = JOptionPane.showInputDialog("Digite el titulo de revista");
            ap = Integer.parseInt(JOptionPane.showInputDialog("Digite el anio de publicacion"));
            nr = Integer.parseInt(JOptionPane.showInputDialog("Digite numero revista"));
            pub = new Revista(id, titulo, ap,nr);
            
        }
        return pub;
    }
    
    static Libro buscarLibro(List<Publicacion> lst, int id){
        //iterar la coleccion y devolver el lubro
        Libro libroTemp = null;
        int cont=0;
        boolean encontrado = false;
        while(cont < lst.size() && !encontrado){
            if(lst.get(cont).getTipoPublicacion()== TipoPublicacion.LIBRO){
                if(lst.get(cont).getIdPublicacion()==id){
                encontrado = true;
                libroTemp =(Libro)  lst.get(cont); //se puede castear porque libro hereda de publicacion
                }else{
                    cont++;
                }
            }else{
                cont++;
            }
        }
        return libroTemp;
    }
    
    static void mostrarPublicaciones(List<Publicacion> lst){
        String msg="";
        if(lst.size()==0){
            msg= "Lista vacia";
        }else{
            msg = "Id Titulo Tipo Estado \n";
            for (int i = 0; i < lst.size(); i++) {
                msg += lst.get(i).getIdPublicacion() + " ";
                msg += lst.get(i).getTitulo()+ " ";
                msg += lst.get(i).getTipoPublicacion()== TipoPublicacion.LIBRO? "Libro\n"+ " ":"Revista\n" + " ";
                if(lst.get(i).getTipoPublicacion()==TipoPublicacion.LIBRO){
                    Libro lb = (Libro) lst.get(i);
                    msg += (lb.estadoPrestamo()?"Prestado":"Disponible") +"\n";
                }
                
            }
        }
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static void main(String[] args) {
        List <Publicacion> pub = new ArrayList<>();
        int opc, id;
        do{
            opc = menu();
            switch(opc){
                case 1:
                    pub.add(agregarPublicacion());
                    break;
                    case 2:
                        id = Integer.parseInt(JOptionPane.showInputDialog("Digite id de libro"));
                        Libro lb = buscarLibro(pub, id);
                        if(lb != null){
                            //revisar si se puede prestas
                            if(!lb.estadoPrestamo()){
                                lb.Prestar();
                                JOptionPane.showMessageDialog(null, "Prestado on exito");
                            }else{
                                JOptionPane.showMessageDialog(null, "Libro ya prestado");
                            }
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "No se encontro el libro ");
                        }
                    break;
                    case 3:
                        //devolver libro
                        id = Integer.parseInt(JOptionPane.showInputDialog("Digite id de libro"));
                        Libro lb2 = buscarLibro(pub, id);
                        if(lb2 != null){
                            //revisar si se puede prestas
                            if(lb2.estadoPrestamo()){
                                lb2.Devolver();
                                JOptionPane.showMessageDialog(null, "Devuelto on exito");
                            }else{
                                JOptionPane.showMessageDialog(null, "Libro no estaba prestado");
                            }
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "No se encontro el libro ");
                        }
                    break;
                    case 4:
                        //mostrar publicaciones
                        mostrarPublicaciones(pub);
                    break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Saliendo");
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "error ");
            }
        }while(opc !=5);
    }
    
}
