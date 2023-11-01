package ma.ensa.beans;

public class EmployeeBuilder {
    private int id;
    private String nom;
    //add more properties here

    public EmployeeBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public EmployeeBuilder setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public Employee build() {
        return new Employee(id, nom);
    }
}
