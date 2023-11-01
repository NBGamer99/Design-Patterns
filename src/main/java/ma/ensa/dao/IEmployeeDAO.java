package ma.ensa.dao;

import ma.ensa.beans.Employee;

import java.util.List;

public interface IEmployeeDAO {

    public void addEmployee(Employee employee);
    public void deleteEmployee(int employeeId);
    public List<Employee> getAllEmployees();

    void updateEmployee(int employeeId);
}
