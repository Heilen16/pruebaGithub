/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila;

import java.util.Scanner;

public class Pila {
    private final int[] pila;
    private int tope;
    private final int maxSize;

    public Pila(int tamaño) {
        maxSize = tamaño;
        pila = new int[maxSize];
        tope = -1;
    }

    public void apilar(int elemento) {
        if (estaLlena()) {
            System.out.println("La pila está llena. No se puede apilar.");
        } else {
            pila[++tope] = elemento;
            System.out.println("Elemento " + elemento + " apilado.");
        }
    }

    public void desapilar() {
        if (estaVacia()) {
            System.out.println("La pila está vacía. No se puede desapilar.");
        } else {
            System.out.println("Elemento " + pila[tope--] + " desapilado.");
        }
    }

    public void mostrarTope() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Tope de la pila: " + pila[tope]);
        }
    }

    public void mostrarElementos() {
        if (estaVacia()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Elementos en la pila:");
            for (int i = tope; i >= 0; i--) {
                System.out.println(pila[i]);
            }
        }
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == maxSize - 1;
    }

    public int tamaño() {
        return tope + 1;
    }

    public void vaciar() {
        tope = -1;
        System.out.println("La pila ha sido vaciada.");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el tamaño de la pila: ");
            int tamaño = scanner.nextInt();
            Pila pila = new Pila(tamaño);
            
            int opcion;
            do {
                System.out.println("\nMenú de opciones:");
                System.out.println("1. Apilar");
                System.out.println("2. Desapilar");
                System.out.println("3. Mostrar tope");
                System.out.println("4. Mostrar todos los elementos");
                System.out.println("5. Verificar si está vacía");
                System.out.println("6. Verificar si está llena");
                System.out.println("7. Mostrar tamaño de la pila");
                System.out.println("8. Vaciar la pila");
                System.out.println("9. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el elemento a apilar: ");
                        int elemento = scanner.nextInt();
                        pila.apilar(elemento);
                    }
                    case 2 -> pila.desapilar();
                    case 3 -> pila.mostrarTope();
                    case 4 -> pila.mostrarElementos();
                    case 5 -> System.out.println(pila.estaVacia() ? "La pila está vacía." : "La pila no está vacía.");
                    case 6 -> System.out.println(pila.estaLlena() ? "La pila está llena." : "La pila no está llena.");
                    case 7 -> System.out.println("Tamaño de la pila: " + pila.tamaño());
                    case 8 -> pila.vaciar();
                    case 9 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida.");
                }
            } while (opcion != 9);
        }
    }
}

