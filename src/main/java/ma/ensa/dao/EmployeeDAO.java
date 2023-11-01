package ma.ensa.dao;


import ma.ensa.beans.Employee;

import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {

    private IConnection connection;
    private static EmployeeDAO instance;

    private EmployeeDAO() {
        connection = ConnectionFactory.createConnection();
    }

    public static EmployeeDAO getInstance() {
        if (instance == null) {
            instance = new EmployeeDAO();
        }
        return instance;
    }

    public void addEmployee(Employee employee) {
        connection.insert(employee);
    }

    public void deleteEmployee(int employeeId) {
        connection.delete(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return connection.select();
    }

    @Override
    public void updateEmployee(int employeeId) {
        connection.update(employeeId);
    }
}
