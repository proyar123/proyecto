/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author pujay
 */
import Controlador.*;
import Modelo.Empleado;
import Modelo.GestorEmpleados;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class VistaEmpleados extends JFrame {
    private ControladorEmpleados controladorEmpleados;
    private Controlador_Reportes controladorReportes;
    private Controlador_Validaciones controladorValidaciones;

    private JTextField txtId, txtNombre, txtSalario, txtPuesto, txtBuscar;
    private JButton btnAgregar, btnBuscarId, btnBuscarNombre, btnBuscarPuesto, btnOrdenarNombre, btnOrdenarSalario;
    private JButton btnEliminar, btnMostrarTodos;
    private JTable tablaEmpleados;
    private DefaultTableModel modeloTabla;
    private JLabel lblTotalEmpleados;

    public VistaEmpleados() {
        GestorEmpleados gestor = new GestorEmpleados();
        controladorEmpleados = new ControladorEmpleados(gestor);
        controladorReportes = new Controlador_Reportes(gestor);
        controladorValidaciones = new Controlador_Validaciones();

        initComponentes();
        setTitle("Gestión de Empleados");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        refrescarTabla();
        actualizarTotalEmpleados();
    }

    private void initComponentes() {
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Agregar Empleado"));

        panelFormulario.add(new JLabel("ID:"));
        txtId = new JTextField();
        panelFormulario.add(txtId);

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Salario:"));
        txtSalario = new JTextField();
        panelFormulario.add(txtSalario);

        panelFormulario.add(new JLabel("Puesto:"));
        txtPuesto = new JTextField();
        panelFormulario.add(txtPuesto);

        btnAgregar = new JButton("Agregar Empleado");
        panelFormulario.add(btnAgregar);

        JPanel panelBusquedaOrden = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelBusquedaOrden.setBorder(BorderFactory.createTitledBorder("Buscar / Ordenar"));

        txtBuscar = new JTextField(15);
        panelBusquedaOrden.add(txtBuscar);

        btnBuscarId = new JButton("Buscar por ID");
        panelBusquedaOrden.add(btnBuscarId);

        btnBuscarNombre = new JButton("Buscar por Nombre");
        panelBusquedaOrden.add(btnBuscarNombre);

        btnBuscarPuesto = new JButton("Buscar por Puesto");
        panelBusquedaOrden.add(btnBuscarPuesto);

        btnOrdenarNombre = new JButton("Ordenar por Nombre");
        panelBusquedaOrden.add(btnOrdenarNombre);

        btnOrdenarSalario = new JButton("Ordenar por Salario");
        panelBusquedaOrden.add(btnOrdenarSalario);

        btnEliminar = new JButton("Eliminar Empleado");
        panelBusquedaOrden.add(btnEliminar);

        btnMostrarTodos = new JButton("Mostrar Todos");
        panelBusquedaOrden.add(btnMostrarTodos);

        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Puesto", "Salario"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaEmpleados = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaEmpleados);

        JPanel panelReporte = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblTotalEmpleados = new JLabel("Total Empleados: 0");
        panelReporte.add(lblTotalEmpleados);

        setLayout(new BorderLayout(10, 10));
        add(panelFormulario, BorderLayout.NORTH);
        add(panelBusquedaOrden, BorderLayout.CENTER);
        add(scrollTabla, BorderLayout.SOUTH);
        add(panelReporte, BorderLayout.PAGE_END);

        // Acciones para los botones
        btnAgregar.addActionListener(e -> agregarEmpleado());
        btnBuscarId.addActionListener(e -> buscarPorId());
        btnBuscarNombre.addActionListener(e -> buscarPorNombre());
        
        btnBuscarPuesto.addActionListener(e -> buscarPorPuesto());
        btnOrdenarNombre.addActionListener(e -> {
            controladorEmpleados.ordenarPorNombre();
            Empleado[] ordenados = controladorEmpleados.obtenerEmpleados();
            new VistaOrdenados("Empleados Ordenados por Nombre", ordenados);
        });

        btnOrdenarSalario.addActionListener(e -> {
            controladorEmpleados.ordenarPorSalario();
            Empleado[] ordenados = controladorEmpleados.obtenerEmpleados();
            new VistaOrdenados("Empleados Ordenados por Salario", ordenados);
        });
        btnEliminar.addActionListener(e -> eliminarEmpleado());
        btnMostrarTodos.addActionListener(e -> mostrarTodosEmpleados());
    }

    private void agregarEmpleado() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombre.getText().trim();
            double salario = Double.parseDouble(txtSalario.getText().trim());
            String puesto = txtPuesto.getText().trim();

            if (!controladorValidaciones.esIdValido(id)) {
                mostrarError("ID inválido. Debe ser mayor que 0.");
                return;
            }
            if (!controladorValidaciones.esNombreValido(nombre)) {
                mostrarError("Nombre inválido.");
                return;
            }
            if (!controladorValidaciones.esSalarioValido(salario)) {
                mostrarError("Salario inválido. Debe ser mayor o igual a 0.");
                return;
            }
            if (!controladorValidaciones.esPuestoValido(puesto)) {
                mostrarError("Puesto inválido. Debe ser uno de: Gerente, Analista, Programador, Asistente, Supervisor, Limpieza.");
                return;
            }
            if (controladorEmpleados.buscarPorId(id) != null) {
                mostrarError("ID ya existe. Ingrese otro.");
                return;
            }

            Empleado emp = new Empleado(id, nombre, salario, puesto);
            controladorEmpleados.agregarEmpleado(emp);

            limpiarCampos();
            refrescarTabla();
            actualizarTotalEmpleados();

            JOptionPane.showMessageDialog(this, "Empleado agregado exitosamente.");

        } catch (NumberFormatException ex) {
            mostrarError("Ingrese valores numéricos válidos para ID y Salario.");
        }
    }

    private void eliminarEmpleado() {
        try {
            int id = Integer.parseInt(txtBuscar.getText().trim());
            if (controladorEmpleados.eliminar(id)) {
                mostrarMensaje("Empleado eliminado exitosamente.");
            } else {
                mostrarError("Empleado no encontrado con ID: " + id);
            }
            refrescarTabla();
            actualizarTotalEmpleados();
        } catch (NumberFormatException ex) {
            mostrarError("Ingrese un ID válido para eliminar.");
        }
    }

    private void buscarPorId() {
        try {
            int id = Integer.parseInt(txtBuscar.getText().trim());
            Empleado emp = controladorEmpleados.buscarPorId(id);
            if (emp == null) {
                mostrarError("Empleado no encontrado con ID: " + id);
                return;
            }
            new VistaOrdenados("Resultado para ID: " + id, new Empleado[]{emp});
        } catch (NumberFormatException ex) {
            mostrarError("Ingrese un ID válido para buscar.");
        }
    }

    private void buscarPorNombre() {
        String nombre = txtBuscar.getText().trim();
        if (nombre.isEmpty()) {
            mostrarError("Ingrese un nombre para buscar.");
            return;
        }
        Empleado[] encontrados = controladorEmpleados.buscarPorNombre(nombre);
        if (encontrados.length == 0) {
            mostrarError("No se encontraron empleados con nombre: " + nombre);
            return;
        }
        new VistaOrdenados("Resultados para nombre: " + nombre, encontrados);
    }

    private void buscarPorPuesto() {
        String puesto = txtBuscar.getText().trim();
        if (puesto.isEmpty()) {
            mostrarError("Ingrese un puesto para buscar.");
            return;
        }
        Empleado[] encontrados = controladorEmpleados.buscarPorPuesto(puesto);
        if (encontrados.length == 0) {
            mostrarError("No se encontraron empleados con puesto: " + puesto);
            return;
        }
        new VistaOrdenados("Resultados para puesto: " + puesto, encontrados);
    }

    private void ordenarPorNombre() {
        controladorEmpleados.ordenarPorNombre();
        refrescarTabla();
        mostrarMensaje("Empleados ordenados por nombre.");
    }

    private void ordenarPorSalario() {
        controladorEmpleados.ordenarPorSalario();
        refrescarTabla();
        mostrarMensaje("Empleados ordenados por salario.");
    }

    private void refrescarTabla() {
        Empleado[] empleados = controladorEmpleados.obtenerEmpleados();
        mostrarEmpleadoEnTabla(empleados);
    }

    private void mostrarEmpleadoEnTabla(Empleado[] empleados) {
        modeloTabla.setRowCount(0);
        for (Empleado e : empleados) {
            modeloTabla.addRow(new Object[]{
                e.getIdEmpleado(),
                e.getNombre(),
                e.getPuesto(),
                String.format("S/ %.2f", e.getSalario())
            });
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtSalario.setText("");
        txtPuesto.setText("");
        txtBuscar.setText("");
    }

    private void actualizarTotalEmpleados() {
        int total = controladorReportes.contarEmpleados();
        lblTotalEmpleados.setText("Total Empleados: " + total);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VistaEmpleados::new);
    }

    private void mostrarTodosEmpleados() {
        Empleado[] empleados = controladorEmpleados.obtenerEmpleados();
        new VistaMostrarTodos(empleados);
    }
    
   
}
