/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospropuestos;

import javax.swing.JOptionPane;

/**
 *
 * @author alu_esp
 */
public class Inmuebles {
    public static void main(String[] args) {
        double costoUrbano = 120;
        double costoIndustrial = 145;
        double costoRural = 95;

        String entradaPropiedades = JOptionPane.showInputDialog("Ingrese el número de propiedades a la venta");
        int propiedadesVenta = Integer.parseInt(entradaPropiedades);

        String[] ubicacionesVenta = new String[propiedadesVenta];
        double[] preciosVenta = new double[propiedadesVenta];

        int propiedadesUrbano = 0, propiedadesIndustrial = 0, propiedadesRural = 0;

        for (int i = 0; i < propiedadesVenta; i++) {
            String entradaUbicacion = JOptionPane.showInputDialog("Ingrese la ubicación de la propiedad a la venta " + (i + 1) + " (urbana, industrial, rural)");
            ubicacionesVenta[i] = entradaUbicacion;

            String entradaMetros = JOptionPane.showInputDialog("Ingrese la cantidad en metros cuadrados de la propiedad a la venta " + (i + 1));
            double metros = Double.parseDouble(entradaMetros);

            double costo;
            switch (ubicacionesVenta[i]) {
                case "urbana":
                    costo = costoUrbano;
                    propiedadesUrbano++;
                    break;
                case "industrial":
                    costo = costoIndustrial;
                    propiedadesIndustrial++;
                    break;
                case "rural":
                    costo = costoRural;
                    propiedadesRural++;
                    break;
                default:
                    throw new IllegalArgumentException("Ubicación no válida: " + ubicacionesVenta[i]);
            }

            preciosVenta[i] = metros * costo;

            JOptionPane.showMessageDialog(null, "La propiedad a la venta " + (i + 1) + " se vende a: s/." + preciosVenta[i]);
        }

        String entradaPropiedadesVendidas = JOptionPane.showInputDialog("Ingrese el número de propiedades vendidas");
        int propiedadesVendidas = Integer.parseInt(entradaPropiedadesVendidas);

        String[] ubicacionesVendidas = new String[propiedadesVendidas];
        double[] preciosVendidos = new double[propiedadesVendidas];
        double menorVenta = Double.MAX_VALUE;
        String ubicacionMenorVenta = "";

        int ventasUrbano = 0, ventasIndustrial = 0, ventasRural = 0;

        for (int i = 0; i < propiedadesVendidas; i++) {
            String entradaUbicacionVendida = JOptionPane.showInputDialog("Ingrese la ubicación de la propiedad vendida " + (i + 1) + " (urbana, industrial, rural)");
            ubicacionesVendidas[i] = entradaUbicacionVendida;

            String entradaPrecioVendido = JOptionPane.showInputDialog("Ingrese el precio de venta de la propiedad vendida " + (i + 1));
            preciosVendidos[i] = Double.parseDouble(entradaPrecioVendido);

            if (preciosVendidos[i] < menorVenta) {
                menorVenta = preciosVendidos[i];
                ubicacionMenorVenta = ubicacionesVendidas[i];
            }

            switch (ubicacionesVendidas[i]) {
                case "urbana":
                    ventasUrbano++;
                    break;
                case "industrial":
                    ventasIndustrial++;
                    break;
                case "rural":
                    ventasRural++;
                    break;
                default:
                    throw new IllegalArgumentException("Ubicación no válida: " + ubicacionesVendidas[i]);
            }
        }

        double porcentajeUrbano = Math.round((double) ventasUrbano / (propiedadesUrbano + ventasUrbano) * 100 * 100.0) / 100.0;
        double porcentajeIndustrial = Math.round((double) ventasIndustrial / (propiedadesIndustrial + ventasIndustrial) * 100 * 100.0) / 100.0;
        double porcentajeRural = Math.round((double) ventasRural / (propiedadesRural + ventasRural) * 100 * 100.0) / 100.0;

        JOptionPane.showMessageDialog(null, "Porcentaje de propiedades vendidas en una ubicación urbana: " + porcentajeUrbano + "%");
        JOptionPane.showMessageDialog(null, "Porcentaje de propiedades vendidas en una ubicación industrial: " + porcentajeIndustrial + "%");
        JOptionPane.showMessageDialog(null, "Porcentaje de propiedades vendidas en una ubicación rural: " + porcentajeRural + "%");

        JOptionPane.showMessageDialog(null, "La menor venta realizada entre todas las propiedades fue en la ubicación " + ubicacionMenorVenta + " por: s/." + menorVenta);
    }
}

