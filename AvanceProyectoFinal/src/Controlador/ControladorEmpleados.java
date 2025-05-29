/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author ELMER
 */
import Modelo.*;

public class ControladorEmpleados {
    private GestorEmpleados gestor;

    public ControladorEmpleados(GestorEmpleados gestor) {
        this.gestor = gestor;
    }

    public void agregarEmpleado(Empleado e) {
        gestor.agregarEmpleado(e);
    }

    public Empleado[] obtenerEmpleados() {
        return gestor.convertirAArreglo();
    }

    public Empleado buscarPorId(int id) {
        return gestor.buscarPorId(id);
    }

    public Empleado[] buscarPorNombre(String nombre) {
        return gestor.buscarPorNombre(nombre);
    }

    public Empleado[] buscarPorPuesto(String puesto) {
        return gestor.buscarPorPuesto(puesto);
    }

    public void ordenarPorNombre() {
        gestor.ordenarPorNombre();
    }

    public void ordenarPorSalario() {
        gestor.ordenarPorSalario();
    }
    
    public boolean eliminar(int id) {
        return gestor.eliminar(id);
    }
}
