/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pujay
 */
public class GestorEmpleados {
    private NodoEmpleado cabeza;
    private int tamaño;

    public GestorEmpleados() {
        cabeza = null;
        tamaño = 0;
    }

    public void agregarEmpleado(Empleado emp) {
        NodoEmpleado nuevo = new NodoEmpleado(emp);
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

    public int getTamaño() {
        return tamaño;
    }

    public Empleado[] convertirAArreglo() {
        Empleado[] arreglo = new Empleado[tamaño];
        NodoEmpleado actual = cabeza;
        int i = 0;
        while (actual != null) {
            arreglo[i++] = actual.empleado;
            actual = actual.siguiente;
        }
        return arreglo;
    }

    // Ordenar por nombre (ascendente)
    public void ordenarPorNombre() {
        if (cabeza == null) return;
        boolean cambio;
        do {
            cambio = false;
            NodoEmpleado actual = cabeza;
            while (actual.siguiente != null) {
                if (actual.empleado.getNombre().compareToIgnoreCase(actual.siguiente.empleado.getNombre()) > 0) {
                    Empleado temp = actual.empleado;
                    actual.empleado = actual.siguiente.empleado;
                    actual.siguiente.empleado = temp;
                    cambio = true;
                }
                actual = actual.siguiente;
            }
        } while (cambio);
    }

    // Ordenar por salario (descendente)
    public void ordenarPorSalario() {
        if (cabeza == null) return;
        boolean cambio;
        do {
            cambio = false;
            NodoEmpleado actual = cabeza;
            while (actual.siguiente != null) {
                if (actual.empleado.getSalario() < actual.siguiente.empleado.getSalario()) {
                    Empleado temp = actual.empleado;
                    actual.empleado = actual.siguiente.empleado;
                    actual.siguiente.empleado = temp;
                    cambio = true;
                }
                actual = actual.siguiente;
            }
        } while (cambio);
    }

    // Búsqueda por ID (retorna Empleado o null)
    public Empleado buscarPorId(int id) {
        NodoEmpleado actual = cabeza;
        while (actual != null) {
            if (actual.empleado.getIdEmpleado() == id) {
                return actual.empleado;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    // Búsqueda por nombre (retorna arreglo de empleados que coincidan)
    public Empleado[] buscarPorNombre(String nombre) {
        int contador = 0;
        NodoEmpleado actual = cabeza;
        while (actual != null) {
            if (actual.empleado.getNombre().equalsIgnoreCase(nombre)) {
                contador++;
            }
            actual = actual.siguiente;
        }
        if (contador == 0) return new Empleado[0];

        Empleado[] resultado = new Empleado[contador];
        actual = cabeza;
        int i = 0;
        while (actual != null) {
            if (actual.empleado.getNombre().equalsIgnoreCase(nombre)) {
                resultado[i++] = actual.empleado;
            }
            actual = actual.siguiente;
        }
        return resultado;
    }
    public Empleado[] buscarPorPuesto(String puesto) {
        int contador = 0;
        NodoEmpleado actual = cabeza;
        while (actual != null) {
            if (actual.empleado.getPuesto().equalsIgnoreCase(puesto)) {
                contador++;
            }
            actual = actual.siguiente;
        }
        if (contador == 0) return new Empleado[0];

        Empleado[] resultado = new Empleado[contador];
        actual = cabeza;
        int i = 0;
        while (actual != null) {
            if (actual.empleado.getPuesto().equalsIgnoreCase(puesto)) {
                resultado[i++] = actual.empleado;
            }
            actual = actual.siguiente;
        }
        return resultado;
    }
    
    public boolean eliminar(int id) {
        NodoEmpleado actual = cabeza;
        NodoEmpleado anterior = null;

        while (actual != null) {
            if (actual.empleado.getIdEmpleado() == id) {
                if (anterior == null) {
                    cabeza = actual.siguiente; // Eliminar el primer nodo
                } else {
                    anterior.siguiente = actual.siguiente; // Eliminar nodo intermedio o final
                }
                tamaño--;
                return true; // Empleado eliminado
            }
            anterior = actual;
            actual = actual.siguiente;
        }
        return false; // Empleado no encontrado
    }
}
