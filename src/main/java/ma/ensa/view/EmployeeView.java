package ma.ensa.view;
import ma.ensa.beans.Employee;
import ma.ensa.services.EmployeeService;

import java.util.List;

public class EmployeeView {

    private EmployeeService employeeService;
    private static EmployeeView instance;


    private EmployeeView(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static EmployeeView getInstance(EmployeeService employeeService) {
        if (instance == null) {
            instance = new EmployeeView(employeeService);
        }
        return instance;
    }

    public void displayAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }

}
