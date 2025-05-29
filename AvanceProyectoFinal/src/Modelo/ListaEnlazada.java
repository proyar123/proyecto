/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author pujay
 */
public interface ListaEnlazada {
    
    void agregarAlInicio(Empleado elemento);
    
    void agregarAlFinal(Empleado elemento);
    
    Empleado eliminar(int index);
    
    boolean contiene(Empleado e);
    
    Empleado get(int index);
    
    int size();
    
    boolean isEmpty();
    
    void imprimir();
}