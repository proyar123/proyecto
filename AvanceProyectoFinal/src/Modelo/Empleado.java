/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pujay
 */
public class Empleado {
    private int idEmpleado;
    private String nombre;
    private double salario;
    private String puesto;

    public Empleado(int idEmpleado, String nombre, double salario, String puesto) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.salario = salario;
        this.puesto = puesto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public String getPuesto() {
        return puesto;
    }

    @Override
    public String toString() {
        return idEmpleado + " | " + nombre + " | Puesto: " + puesto + " | Salario: S/" + String.format("%.2f", salario);
    }
}