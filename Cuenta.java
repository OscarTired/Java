/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;

public class Cuenta {
    private String titular;
    private double cantidad;

    // Constructor con saldo inicial
    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            JOptionPane.showMessageDialog(null, "La cantidad inicial no puede ser negativa. Se establecerá en 0.");
            this.cantidad = 0;
        }
    }

    // Constructor sin saldo inicial
    public Cuenta(String titular) {
        this(titular, 0); // Llamada al otro constructor con saldo 0
    }

    // Métodos get y set
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            JOptionPane.showMessageDialog(null, "La cantidad no puede ser negativa. No se realizará el cambio.");
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Banco SENATI\nHola " + titular + ", usted cuenta con " + String.format("%.2f", cantidad) + " nuevos soles.";
    }

    // Método para ingresar dinero
    public void ingresar(double cantidad) {
        if (cantidad >= 0) {
            this.cantidad += cantidad;
        } else {
            JOptionPane.showMessageDialog(null, "La cantidad a ingresar no puede ser negativa. No se realizará la operación.");
        }
    }

    // Método para retirar dinero
    public void retirar(double cantidad) {
        if (this.cantidad - cantidad >= 0) {
            this.cantidad -= cantidad;
        } else {
            this.cantidad = 0;
            JOptionPane.showMessageDialog(null, "La cantidad a retirar supera el saldo disponible. Se retirará todo el dinero.");
        }
    }

    public static void main(String[] args) {
        // Ventana de "Abrir Cuenta"
        String titular = JOptionPane.showInputDialog("Introduce el nombre del titular:");
        double saldoInicial;
        try {
            saldoInicial = Double.parseDouble(JOptionPane.showInputDialog("Introduce el saldo inicial:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida. Se establecerá un saldo inicial de 0.");
            saldoInicial = 0;
        }

        // Crear la cuenta
        Cuenta cuenta = new Cuenta(titular, saldoInicial);

        // Ventana con dos opciones: "Ingresar" y "Retirar"
        Object[] options = {"Ingresar", "Retirar"};
        int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Operación",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        // Realizar la operación seleccionada
        if (opcion == 0) { // Ingresar
            double cantidadIngresar;
            try {
                cantidadIngresar = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad a ingresar:"));
                cuenta.ingresar(cantidadIngresar);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cantidad inválida. No se realizará la operación.");
            }
        } else if (opcion == 1) { // Retirar
            double cantidadRetirar;
            try {
                cantidadRetirar = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad a retirar:"));
                cuenta.retirar(cantidadRetirar);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cantidad inválida. No se realizará la operación.");
            }
        }

        // Mostrar el estado de la cuenta
        JOptionPane.showMessageDialog(null, cuenta.toString());
    }
}