package ma.ensa.dao;

import ma.ensa.beans.Employee;

import java.util.List;

public interface IConnection {
    void insert(Employee employee);
    void delete(int employeeId);
    List<Employee> select();

    void update(int employeeId);
}

