/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alu_esp
 */
import javax.swing.JOptionPane;
public class AreaCirculo2 {
    
    public static void main(String[] args) {
        String texto = JOptionPane.showInputDialog("Introduce el radio: ");
        double numero= Double.parseDouble(texto);
            
            double area = Math.PI * Math.pow(numero, 2);
            JOptionPane.showMessageDialog(null, "El radio es: "+area);
            
    
    
    }
    
}
