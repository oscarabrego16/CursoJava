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
public class Ejemplo2MultiRusa {
    public static void main(String[] args) {
        int num1, num2, suma=0;
        num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
        num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
        while (num1 >0 ){// se va dividiendo entre 2
           if(num1 %2 != 0){
               suma += num2;
           }else if(num2 %2 !=0){
               suma +=num1;
           }
           num1 /=2;
           num2 *=2;
        }
        JOptionPane.showMessageDialog(null, suma);
    }
}
