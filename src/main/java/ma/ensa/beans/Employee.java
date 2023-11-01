package ma.ensa.beans;

import java.util.ArrayList;
import java.util.List;

public class Employee extends EmployeeComponent implements Cloneable{
    private int id;
    private String name;
    private final List<EmployeeComponent> teamMembers;

    public Employee(int id, String nom) {
        this.id = id;
        this.name = nom;
        this.teamMembers = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee: " + name + " (ID: " + id + ")");
    }

    @Override
    public List<EmployeeComponent> getTeamMembers() {
        return teamMembers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }

    public void addTeamMember(EmployeeComponent employee) {
        teamMembers.add(employee);
    }

    public void removeTeamMember(EmployeeComponent employee) {
        teamMembers.remove(employee);
    }

}

