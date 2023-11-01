package ma.ensa.beans;

public class EmployeeMemento {
    private String name;
    private int id;

    public EmployeeMemento(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
