/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pujay
 */
public class NodoEmpleado {
    Empleado empleado;
    NodoEmpleado siguiente;

    public NodoEmpleado(Empleado empleado) {
        this.empleado = empleado;
        this.siguiente = null;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public NodoEmpleado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEmpleado siguiente) {
        this.siguiente = siguiente;
    }
    
}

