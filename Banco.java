/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospropuestos;

/**
 *
 * @author USER
 */
import javax.swing.JOptionPane;

public class Banco {
    public static void main(String[] args) {
        double monto = 0;
        while (true) {
            try {
                String montoStr = JOptionPane.showInputDialog("Ingrese el monto a depositar:");
                monto = Double.parseDouble(montoStr);
                if (monto < 100) {
                    JOptionPane.showMessageDialog(null, "El monto debe ser mayor o igual a 100.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número válido.");
            }
        }

        String[] opciones = {"Cuenta Cero", "Largo Plazo"};
        int tipoCuenta = JOptionPane.showOptionDialog(null, "Elija el tipo de cuenta:", "Tipo de Cuenta",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        double interes = 0;
        if (monto >= 100 && monto <= 500) {
            interes = tipoCuenta == 0 ? 0.02 : 0.03;
        } else if (monto > 500 && monto <= 1500) {
            interes = tipoCuenta == 0 ? 0.04 : 0.05;
        } else if (monto > 1500) {
            interes = tipoCuenta == 0 ? 0.06 : 0.07;
        }

        double mantenimiento = tipoCuenta == 0 ? 10 : 5;
        double totalInteresAnual = monto * interes;
        double totalAhorroAnual = monto + totalInteresAnual - (mantenimiento * 12);

        JOptionPane.showMessageDialog(null, "El interés del cliente es: " + interes);
        JOptionPane.showMessageDialog(null, "El total que obtendrá con dicho ahorro es: " + totalAhorroAnual);
    }
}
