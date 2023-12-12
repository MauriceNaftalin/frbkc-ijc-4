package org.frbkc.ijc;

public class Manager extends Employee {

    private String office;

    // TODO write constructor
    public Manager(String id, String name, int salary, String office) {
        super(id, name, salary);
        this.office = office;
    }

    // TODO override raiseSalary() method to double ordinary Employee's salary increment 😐
    public void raiseSalary(int increment) {
        super.raiseSalary(2 * increment);
    }
}
