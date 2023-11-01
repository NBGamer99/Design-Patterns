package ma.ensa.services;

import ma.ensa.beans.Employee;
import ma.ensa.dao.EmployeeDAO;

import java.util.List;

public class EmployeeService {

    private EmployeeDAO employeeDAO;
    private static EmployeeService instance;

    private EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public static EmployeeService getInstance(EmployeeDAO employeeDAO) {
        if (instance == null) {
            instance = new EmployeeService(employeeDAO);
        }
        return instance;
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    public void deleteEmployee(int employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

    public void updateEmployee(int employeeId){
        employeeDAO.deleteEmployee(employeeId);
    }

}
