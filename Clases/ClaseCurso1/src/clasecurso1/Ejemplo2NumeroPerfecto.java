/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasecurso1;

import javax.swing.JOptionPane;

/**
 *
 * @author oara1
 */
public class Ejemplo2NumeroPerfecto {
    public static void main(String[] args) {
        //si la suma de todos los divisores del numero numero es igual al numero entonces es perfecto
        int num, suma = 0;
        num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero"));
        for (int i = num-1; i > 0; i--) {
            suma += (num%i==0)? i:0;
        }
        if(suma == num)
            JOptionPane.showMessageDialog(null, "El numero es perfecto");
        else
            JOptionPane.showMessageDialog(null, "El numero no es perfecto");
    }
}
