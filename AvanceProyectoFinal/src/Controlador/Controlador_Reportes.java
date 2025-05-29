/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author pujay
 */
import Modelo.GestorEmpleados;


public class Controlador_Reportes {
    private GestorEmpleados gestor;

    public Controlador_Reportes(GestorEmpleados gestor) {
        this.gestor = gestor;
    }

    public int contarEmpleados() {
        return gestor.getTamaño();
    }
    
}