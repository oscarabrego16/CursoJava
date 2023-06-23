/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clasecurso1;

import javax.swing.JOptionPane;

/**
 *
 * @author oara1
 */
public class ClaseCurso1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 0;
        String msg = "";
        num = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));
        for (int i = 1; i <= 10; i++) {
            msg += num + " x "+ i + " = " + (i*num) + "\n";
        }
        JOptionPane.showMessageDialog(null, msg);
    }
    
}
