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

public class VistaMostrarTodos extends JFrame {
    public VistaMostrarTodos(Empleado[] empleados) {
        setTitle("Todos los Empleados");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        DefaultTableModel modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Puesto", "Salario"}, 0);
        JTable tablaEmpleados = new JTable(modeloTabla);

        // Rellenar la tabla con los empleados
        for (Empleado e : empleados) {
            modeloTabla.addRow(new Object[]{
                e.getIdEmpleado(),
                e.getNombre(),
                e.getPuesto(),
                String.format("S/ %.2f", e.getSalario())
            });
        }

        JScrollPane scrollPane = new JScrollPane(tablaEmpleados);
        add(scrollPane);

        setVisible(true);
    }
}
