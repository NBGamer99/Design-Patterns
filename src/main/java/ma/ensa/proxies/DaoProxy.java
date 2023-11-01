package ma.ensa.proxies;

import ma.ensa.beans.Employee;
import ma.ensa.dao.*;

import java.util.List;

public class DaoProxy implements IEmployeeDAO {

    private EmployeeDAO realDao;
    private String username;
    private String password;

    public DaoProxy(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private boolean isGranted() {
        return true;
    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int employeeId) {

    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public void updateEmployee(int employeeId) {
        if (isGranted()) {
            if (realDao == null){
                realDao = EmployeeDAO.getInstance();
            }
            realDao.updateEmployee(employeeId);
        } else {
            throw new SecurityException("Permission denied");
        }
    }
}
