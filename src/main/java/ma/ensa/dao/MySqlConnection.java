package ma.ensa.dao;

import ma.ensa.beans.Employee;

import java.util.List;

public class MySqlConnection implements IConnection{
    @Override
    public void insert(Employee employee) {
        System.out.println("Inserting employee in MySQL database");
    }

    @Override
    public void delete(int employeeId) {
        System.out.println("Deleting employee with id " + employeeId + " from MySQL database");
    }

    @Override
    public List<Employee> select() {
        System.out.println("Selecting employee from MySQL database");
        return null;
    }

    @Override
    public void update(int employeeId) {
        System.out.println("Updating employee with id \" + employeeId + \" from MySQL database");
    }
}
