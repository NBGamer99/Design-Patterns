package ma.ensa.beans;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable{
    private int id;
    private String name;

    public Employee(int id, String nom) {
        this.id = id;
        this.name = nom;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee: " + name + " (ID: " + id + ")");
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
    
}

