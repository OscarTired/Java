/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tare01;

import javax.swing.JOptionPane;

public class calcularJornal {
    private String nombre;
    private int horasTrabajadas;

    public calcularJornal(String nombre, int horasTrabajadas) {
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
    }

    public void calcularJornal() {
        final int HORAS_NORMALES = 40;
        final double PAGO_NORMAL = 25.0;
        final double PAGO_EXTRA = 30.0;
        final double DESCUENTO = 0.195;
        final double BONIFICACION = 100.0;

        int horasNormales = Math.min(horasTrabajadas, HORAS_NORMALES);
        int horasExtra = Math.max(0, horasTrabajadas - HORAS_NORMALES);

        double sueldoBasico = horasNormales * PAGO_NORMAL;
        double descuentos = sueldoBasico * DESCUENTO;
        double premio = (horasTrabajadas >= HORAS_NORMALES) ? BONIFICACION : 0.0;

        double pagoExtra = horasExtra * PAGO_EXTRA;
        double aCobrar = sueldoBasico + pagoExtra - descuentos + premio;

        String resultado = String.format("EMPLEADO: %s" +
                           "\nCANTIDAD HORAS TRABAJADAS: %d" +
                           "\nSUELDO BÁSICO: s/. %.2f" +
                           "\nCANTIDAD HORAS SIMPLES: %d" +
                           "\nDESCUENTOS: s/. %.2f" +
                           "\nCANTIDAD HORAS EXCEDENTES: %d" +
                           "\nBONO: s/. %.2f" +
                           "\nA COBRAR: s/. %.2f", 
                           nombre, horasTrabajadas, sueldoBasico, horasNormales, descuentos, 
                           horasExtra, premio, aCobrar);

        JOptionPane.showMessageDialog(null, resultado);
    }

    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
        
        int horasTrabajadas;
        while (true) {
            try {
                horasTrabajadas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas trabajadas por el empleado:"));
                if (horasTrabajadas < 0) {
                    JOptionPane.showMessageDialog(null, "Las horas trabajadas no pueden ser negativas. Inténtalo de nuevo.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor ingrese un número entero.");
            }
        }

        calcularJornal empleado = new calcularJornal(nombre, horasTrabajadas);
        empleado.calcularJornal();
    }
}

