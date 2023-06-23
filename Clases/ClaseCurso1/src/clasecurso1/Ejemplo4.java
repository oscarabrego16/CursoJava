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
public class Ejemplo4 {
    public static void main(String[] args) {
        int n1, n2, n3, my, cn, mn;
        n1= Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero 1"));
        n2= Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero 2"));
        n3= Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero 3"));
        
        if(n1>n2){
            my= n1;
            mn=n2;
        }else{
            my = n2;
            mn =n1;
        }
        if(my > n3){
            if(mn > n3){
                cn = mn;
                mn = n3;
            }else{
                cn = n3;
            }
        }else{
            cn = my;
            my = n3;
        }
        System.out.println("Mayor es: " + my);
        System.out.println("Central es: " + cn);
        System.out.println("Menor es: " + mn);
    }
}
