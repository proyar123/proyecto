/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author pujay
 */
import Modelo.Empleado;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaOrdenados extends JFrame {

    public VistaOrdenados(String titulo, Empleado[] empleados) {
        setTitle(titulo);
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] columnas = {"ID", "Nombre", "Puesto", "Salario"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Empleado emp : empleados) {
            if (emp != null) {
                Object[] fila = {
                    emp.getIdEmpleado(),
                    emp.getNombre(),
                    emp.getPuesto(),
                    emp.getSalario()
                };
                modelo.addRow(fila);
            }
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
        setVisible(true);
    }
}
