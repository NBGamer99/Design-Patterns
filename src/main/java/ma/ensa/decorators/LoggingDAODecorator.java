package ma.ensa.decorators;

import ma.ensa.beans.Employee;
import ma.ensa.dao.*;
import ma.ensa.proxies.DaoProxy;

import java.util.List;

public class LoggingDAODecorator implements IEmployeeDAO {

    private DaoProxy daoProxy;
    private String logFileName;

    public LoggingDAODecorator(DaoProxy daoProxy) {
        this.daoProxy = daoProxy;
        this.logFileName = "db.log";
    }

    private void log(String message) {
        System.out.println(message);
    }

    @Override
    public void addEmployee(Employee employee) {
        daoProxy.addEmployee(employee);
        log("Date: Insertion");
    }

    @Override
    public void deleteEmployee(int employeeId) {
        daoProxy.deleteEmployee(employeeId);
        log("Date: Delete");
    }

    @Override
    public List<Employee> getAllEmployees() {
        daoProxy.getAllEmployees();
        log("Date: Listing");
        return null;
    }

    @Override
    public void updateEmployee(int employeeId) {
        daoProxy.updateEmployee(employeeId);
        log("Date: Update");
    }
}
