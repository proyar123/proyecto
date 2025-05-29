/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author pujay
 */
import java.util.HashSet;
import java.util.Set;

public class Controlador_Validaciones {

    private Set<String> puestosValidos;

    public Controlador_Validaciones() {
        puestosValidos = new HashSet<>();
        puestosValidos.add("Gerente");
        puestosValidos.add("Analista");
        puestosValidos.add("Programador");
        puestosValidos.add("Asistente");
        puestosValidos.add("Supervisor");
        puestosValidos.add("Limpieza");
    }

    public boolean esNombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public boolean esPuestoValido(String puesto) {
        return puesto != null && puestosValidos.contains(puesto.trim());
    }

    public boolean esSalarioValido(double salario) {
        return salario >= 0;
    }

    public boolean esIdValido(int id) {
        return id > 0;
    }
}