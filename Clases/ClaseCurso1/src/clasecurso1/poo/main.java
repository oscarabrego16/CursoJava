/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasecurso1.poo;

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
        int cod;
        String nom, ape;
        float sm;
        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del trabajador"));
        nom = JOptionPane.showInputDialog("Digite el nombre del trabajador: ");
        ape = JOptionPane.showInputDialog("Digite el apellido del trabajador: ");
        sm = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el sueldo del trabajador"));
        
        tb = new Trabajador(cod, nom, ape, sm);
        
        return tb;
    }
    
    static void mostrarPlanilla (Trabajador lst[], int cont){
        String mensaje;
        if(cont==0)
            mensaje = "LA plantilla esta vacia \n";
        else{
            mensaje="Cod Nombre Apellido Sueldo Total Pagar\n";
            for(int i=0;i<cont;i++){
                mensaje += lst[i].getCodigo();
                mensaje += lst[i].getNombre();
                mensaje += lst[i].getApellido();
                mensaje += lst[i].getSueldoMensual();
                mensaje += lst[i].getTotalPagar();   
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public static void main(String[] args) {
        int DIM =5, contador=0, opcion=0;
        Trabajador planilla[]= new Trabajador[DIM];
        
        do{
            opcion=menu();
            switch(opcion){
                case 1:
                    if(contador< DIM){
                    planilla[contador]= agregarTrabajador();
                    contador++;
                    }else{
                        JOptionPane.showMessageDialog(null, "Planilla llena");
                    }
                    break;
                case 2:
                    mostrarPlanilla(planilla, contador);
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
