package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;

public class Biblioteca {
    private String ISBN;
    private String titulo;
    private String autor;
    private int numeroPaginas;

    // Constructor
    public Biblioteca(String ISBN, String titulo, String autor, int numeroPaginas) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = Math.max(numeroPaginas, 0);
    }

    // Métodos get y set
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        if (numeroPaginas >= 0) {
            this.numeroPaginas = numeroPaginas;
        } else {
            JOptionPane.showMessageDialog(null, "Número de páginas no válido. No se realizará el cambio.");
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "El libro con ISBN " + ISBN + " creado por " + autor + " tiene " + numeroPaginas + " páginas.";
    }

    public static void main(String[] args) {
        // Crear dos objetos Libro
        Biblioteca libro1 = crearBiblioteca();
        Biblioteca libro2 = crearBiblioteca();

        // Mostrar información por pantalla
        JOptionPane.showMessageDialog(null, libro1.toString());
        JOptionPane.showMessageDialog(null, libro2.toString());

        // Comparar número de páginas
        compararPaginas(libro1, libro2);
    }

    private static Biblioteca crearBiblioteca() {

        String ISBN = JOptionPane.showInputDialog("Introduce el ISBN: ");
        
        String titulo = JOptionPane.showInputDialog("Introduce el título: ");
        
        String autor = JOptionPane.showInputDialog("Introduce el autor: ");
        
        int numeroPaginas = obtenerNumeroPaginas();

        return new Biblioteca(ISBN, titulo, autor, numeroPaginas);
    }

    private static int obtenerNumeroPaginas() {
        int numeroPaginas = 0;

        while (true) {
            try {
                numeroPaginas = Integer.parseInt(JOptionPane.showInputDialog("Introduce el número de páginas: "));
                if (numeroPaginas >= 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Número de páginas no válido. Debe ser un número no negativo.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Introduce un número válido.");
            }
        }

        return numeroPaginas;
    }

    private static void compararPaginas(Biblioteca libro1, Biblioteca libro2) {
        if (libro1.getNumeroPaginas() > libro2.getNumeroPaginas()) {
            JOptionPane.showMessageDialog(null, "El libro 1 tiene más páginas.");
        } else if (libro1.getNumeroPaginas() < libro2.getNumeroPaginas()) {
            JOptionPane.showMessageDialog(null, "El libro 2 tiene más páginas.");
        } else {
            JOptionPane.showMessageDialog(null, "Ambos libros tienen la misma cantidad de páginas.");
        }
    }
}
