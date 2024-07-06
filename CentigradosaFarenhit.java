//f=32+(9*C)/5
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alu_esp
 */
import javax.swing.JOptionPane;
public class CentigradosaFarenhit {
    
    public static void main(String[] args) {
        String texto = JOptionPane.showInputDialog("Introduce el grado Celciu: ");
        double numero= Double.parseDouble(texto);
            
            double faren = 32+((9*numero)/5);
            JOptionPane.showMessageDialog(null,"En grados Farenhit es: "+faren);
            
            
    
    
    
    
    }
    
}
