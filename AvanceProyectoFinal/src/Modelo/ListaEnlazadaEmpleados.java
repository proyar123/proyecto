/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pujay
 */
public class ListaEnlazadaEmpleados implements ListaEnlazada {

    private NodoEmpleado cabeza;
    private int tamaño;

    private static class NodoEmpleado {
        Empleado empleado;
        NodoEmpleado siguiente;

        NodoEmpleado(Empleado empleado) {
            this.empleado = empleado;
            this.siguiente = null;
        }
    }

    public ListaEnlazadaEmpleados() {
        cabeza = null;
        tamaño = 0;
    }

    @Override
    public void agregarAlInicio(Empleado elemento) {
        NodoEmpleado nuevo = new NodoEmpleado(elemento);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamaño++;
    }

    @Override
    public void agregarAlFinal(Empleado elemento) {
        NodoEmpleado nuevo = new NodoEmpleado(elemento);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoEmpleado actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamaño++;
    }

    @Override
    public Empleado eliminar(int index) {
        validarIndice(index);
        NodoEmpleado eliminado;
        if (index == 0) {
            eliminado = cabeza;
            cabeza = cabeza.siguiente;
        } else {
            NodoEmpleado actual = cabeza;
            for (int i = 0; i < index - 1; i++) {
                actual = actual.siguiente;
            }
            eliminado = actual.siguiente;
            actual.siguiente = eliminado.siguiente;
        }
        tamaño--;
        return eliminado.empleado;
    }

    @Override
    public boolean contiene(Empleado e) {
        NodoEmpleado actual = cabeza;
        while (actual != null) {
            if (actual.empleado.equals(e)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public Empleado get(int index) {
        validarIndice(index);
        NodoEmpleado actual = cabeza;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        return actual.empleado;
    }

    @Override
    public int size() {
        return tamaño;
    }

    @Override
    public boolean isEmpty() {
        return tamaño == 0;
    }

    @Override
    public void imprimir() {
        NodoEmpleado actual = cabeza;
        while (actual != null) {
            System.out.println(actual.empleado); // Asume que Empleado tiene un método toString() adecuado.
            actual = actual.siguiente;
        }
    }

    private void validarIndice(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
    }
}