
# Caso Práctico: Ordenamiento de Empleados con MVC (Nombre, Salario, Puesto)

## Descripción

Este caso práctico consiste en desarrollar una aplicación de escritorio en Java utilizando Swing y el patrón Modelo-Vista-Controlador (MVC). El objetivo es ordenar una lista de empleados, cada uno con los atributos:

- **Nombre**
- **Salario**
- **Puesto**

El usuario podrá elegir:
- **Criterio de ordenación:** por **Nombre**, **Salario** o **Puesto**
- **Algoritmo de ordenamiento:** **Bubble Sort** o **Selection Sort**

La aplicación mostrará los resultados en una tabla gráfica (`JTable`) después de ordenar la lista.

---

## Objetivo del Estudiante

El estudiante deberá implementar los algoritmos de ordenamiento **Bubble Sort** y **Selection Sort** en la clase `EmployeeModel.java`. Se le proporciona todo el código de la vista y del controlador, para que se concentre en la lógica del modelo.

---

## Estructura del Proyecto

- `Employee.java`: Clase que representa a un empleado con nombre, salario y puesto.
- `EmployeeModel.java`: Contiene los datos y métodos de ordenamiento a completar.
- `EmployeeView.java`: Interfaz gráfica ya implementada.
- `EmployeeController.java`: Controlador que coordina la vista y el modelo.
- `MainApp.java`: Clase principal para lanzar la aplicación.

---

## Métodos a Implementar (en EmployeeModel.java)

### Por Bubble Sort

- `sortByNameBubble()`
- `sortBySalaryBubble()`
- `sortByPositionBubble()`

### Por Selection Sort

- `sortByNameSelection()`
- `sortBySalarySelection()`
- `sortByPositionSelection()`

---

## Código Base

### Employee.java

```java
public class Employee {
    private String name;
    private double salary;
    private String position;

    public Employee(String name, double salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }
}
```

### EmployeeModel.java

```java
public class EmployeeModel {
    private Employee[] employees;

    public EmployeeModel() {
        employees = new Employee[] {
            new Employee("Alice", 5000, "Analyst"),
            new Employee("Bob", 4000, "Developer"),
            new Employee("Charlie", 6000, "Manager"),
            new Employee("Diana", 4500, "Support"),
            new Employee("Edward", 5500, "Tester")
        };
    }

    public Employee[] getEmployees() {
        return employees;
    }

    // TODO: Implementar los métodos de ordenamiento
    public void sortByNameBubble() {}
    public void sortBySalaryBubble() {}
    public void sortByPositionBubble() {}

    public void sortByNameSelection() {}
    public void sortBySalarySelection() {}
    public void sortByPositionSelection() {}
}
```

### EmployeeView.java

```java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class EmployeeView extends JFrame {
    private JTable table;
    private JComboBox<String> criteriaCombo;
    private JComboBox<String> algorithmCombo;
    private JButton sortButton;

    public EmployeeView() {
        setTitle("Employee Sorting Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel titleLabel = new JLabel("Employee List");
        titleLabel.setBounds(20, 10, 200, 25);
        add(titleLabel);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 40, 500, 150);
        add(scrollPane);

        criteriaCombo = new JComboBox<>(new String[]{"Name", "Salary", "Position"});
        criteriaCombo.setBounds(20, 210, 120, 25);
        add(criteriaCombo);

        algorithmCombo = new JComboBox<>(new String[]{"Bubble Sort", "Selection Sort"});
        algorithmCombo.setBounds(150, 210, 150, 25);
        add(algorithmCombo);

        sortButton = new JButton("Sort");
        sortButton.setBounds(320, 210, 100, 25);
        add(sortButton);

        setSize(560, 300);
        setLocationRelativeTo(null);
    }

    public void updateTable(Employee[] employees) {
        String[] columns = {"Name", "Salary", "Position"};
        Object[][] data = new Object[employees.length][3];
        for (int i = 0; i < employees.length; i++) {
            data[i][0] = employees[i].getName();
            data[i][1] = employees[i].getSalary();
            data[i][2] = employees[i].getPosition();
        }
        table.setModel(new DefaultTableModel(data, columns));
    }

    public int getSelectedCriteria() {
        return criteriaCombo.getSelectedIndex();
    }

    public int getSelectedAlgorithm() {
        return algorithmCombo.getSelectedIndex();
    }

    public void addSortButtonListener(ActionListener listener) {
        sortButton.addActionListener(listener);
    }
}
```

### EmployeeController.java

```java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController {
    private EmployeeModel model;
    private EmployeeView view;

    public EmployeeController(EmployeeModel model, EmployeeView view) {
        this.model = model;
        this.view = view;
        view.updateTable(model.getEmployees());

        view.addSortButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortEmployees();
            }
        });
    }

    private void sortEmployees() {
        int criteria = view.getSelectedCriteria();
        int algorithm = view.getSelectedAlgorithm();

        if (criteria == 0 && algorithm == 0) model.sortByNameBubble();
        else if (criteria == 0) model.sortByNameSelection();
        else if (criteria == 1 && algorithm == 0) model.sortBySalaryBubble();
        else if (criteria == 1) model.sortBySalarySelection();
        else if (criteria == 2 && algorithm == 0) model.sortByPositionBubble();
        else model.sortByPositionSelection();

        view.updateTable(model.getEmployees());
    }
}
```

### MainApp.java

```java
import javax.swing.SwingUtilities;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeModel model = new EmployeeModel();
            EmployeeView view = new EmployeeView();
            new EmployeeController(model, view);
            view.setVisible(true);
        });
    }
}
```

---

## Instrucciones para los Estudiantes

1. **Explora el proyecto.**
2. **Completa los métodos en `EmployeeModel`.**
3. **Ejecuta la aplicación y realiza pruebas.**
4. **Reflexiona sobre los algoritmos aplicados.**

---

## Resultado Esperado

Una interfaz gráfica que ordene por **nombre**, **salario** o **puesto**, usando el algoritmo seleccionado.

---

## Recomendación

Este caso está diseñado para realizarse en **una hora y media**, enfocándose en la lógica del modelo y comprensión del patrón MVC.

---

**Autor:** Dr. Ing. Carlos Palomino Vidal  
**Curso:** Algoritmos y Estructura de Datos
