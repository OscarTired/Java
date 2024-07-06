/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciospropuestos;

import javax.swing.JOptionPane;

/**
 *
 * @author alu_esp
 */
public class Uber {
    public static void main(String[] args) {
        int tarifaDia = 8;
        int tarifaNoche = 10;
        int recargoCombustible = 1;
        int multiplicadorExtra = 2;
        int KmGratis = 2;

        String entradaHorario = JOptionPane.showInputDialog("Ingrese la hora en formato de 24 horas (HH)");
        int horario = Integer.parseInt(entradaHorario);

        String entradaViajes = JOptionPane.showInputDialog("Ingrese la cantidad de viajes a realizar");
        int viajes = Integer.parseInt(entradaViajes);

        String entradaDistancia = JOptionPane.showInputDialog("Ingrese la distancia del viaje en km");
        int distancia = Integer.parseInt(entradaDistancia) - KmGratis;
        if (distancia < 0) {
            distancia = 0;
        }

        String entradaExtra = JOptionPane.showInputDialog("Ingrese los kilómetros extra del viaje");
        int extra = Integer.parseInt(entradaExtra);

        int tarifa;
        if (horario >= 6 && horario <= 21) {
            tarifa = tarifaDia;
        } else {
            tarifa = tarifaNoche;
        }

        int costoViaje = (tarifa * distancia) + (multiplicadorExtra * extra) + (recargoCombustible * viajes);
        int costoTotal = costoViaje;

        JOptionPane.showMessageDialog(null, "El costo total de los viajes es: s/." + costoTotal);
    }
}