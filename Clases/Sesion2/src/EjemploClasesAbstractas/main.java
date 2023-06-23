package EjemploClasesAbstractas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;




public class main {
     static int menu(){
        String mensaje= "Menu de opciones\n";
        mensaje+="1. Agregar trabajador\n";
        mensaje+="2.Mostrar planilla\n";
        mensaje+="3. Salir\n";
        mensaje+="Digite la opcion: \n";
        return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    }
    static Trabajador agregarTrabajador(){
        Trabajador tb;
        int cod, tipo, nht;
        String nom, ape;
        float sm;
        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del trabajador"));
        tipo = Integer.parseInt(JOptionPane.showInputDialog("Digite el tipo TC=1, TPH2"));
        nom = JOptionPane.showInputDialog("Digite el nombre del trabajador: ");
        ape = JOptionPane.showInputDialog("Digite el apellido del trabajador: ");
        
        if(tipo ==1){
            sm = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el sueldo del trabajador"));
            tb = new TrabajadorTiempoCompleto(cod, nom, ape, sm);
        }else{
            sm = Float.parseFloat(JOptionPane.showInputDialog("Digite el sueldo por hora"));
            nht = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de horas trabajadas"));
            tb = new TrabajadorPorHora(cod, nom, ape, sm, nht);
        }
        
        
 
        
        return tb;
    }
    
    static void mostrarPlanilla (List<Trabajador> lst){
        String mensaje;
        if(lst.size()==0)
            mensaje = "LA plantilla esta vacia \n";
        else{
            mensaje="Cod Nombre Apellido Sueldo Total Pagar\n";
            
            //esta funcion lambda puede no ser ejecutada por servidores viejos
           
            
            for(int i=0;i<lst.size();i++){
                mensaje += lst.get(i).getCodigo() +" ";
                mensaje += lst.get(i).getNombre()+" ";
                mensaje += lst.get(i).getApellido()+" ";
                mensaje += lst.get(i).getSueldoMensual()+" ";
                mensaje += lst.get(i).getTotalPagar()+" ";   
                mensaje += (lst.get(i).getTipoTrabajador() ==
                        TipoTrabajador.TRABAJADOR_TIEMPO_COMPLETO ? "Tiempo completo": "Por hora")+ "\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    
    //funcion polimorfica, ya que puede recibir de distinto tipo
    static void MostrarDatosTrabajador(Trabajador tb){
        System.out.println(tb.toString());
    }
    
    public static void main(String[] args) {
        
        List<Trabajador> planilla = new ArrayList<>();
        /**
        Trabajador[] planilla = new Trabajador[2]; //arreglo polimorfico, la planilla de tipo trabajador
        //puede recibir de distintos tipos, puede reaccionarse de distinta forma 
        //Trabajador obj1; declaracion de variable, no instancia
        
        //list es una interfaz y por tanto no es instanciable, debe usarse una particularizacion
        List<Trabajador> lista1 = new ArrayList<>(); //posteriormente puedo cambiar sus comportamientos
        //a otro tipo de lista como linkedlist
        Set<Trabajador> lista2 = new HashSet<>();
        
        
        TrabajadorTiempoCompleto ob1= new TrabajadorTiempoCompleto(1, "Juan","Perez", 1000);
        TrabajadorPorHora ob2 = new TrabajadorPorHora(2, "Mario","Diaz", 5f, 46);
        /**planilla[0]= ob1;
        planilla[1]= ob2;
        MostrarDatosTrabajador(planilla[0]);
        MostrarDatosTrabajador(planilla[1]);**/
        /**
        lista1.add(ob1);
        lista1.add(ob2);
        **/
                
          int DIM =5, contador=0, opcion=0;
        
        do{
            opcion=menu();
            switch(opcion){
                case 1:
                    if(contador< DIM){
                    planilla.add(agregarTrabajador());
                    }else{
                        JOptionPane.showMessageDialog(null, "Planilla llena");
                    }
                    break;
                case 2:
                    mostrarPlanilla(planilla);
                    break;
                case 3:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Error, la opcion no esta definida ");
                    break;
            }
        }while( opcion !=3);
        
        
        
    }
}
