package org.frbkc.ijc;

public class Employee {

    final private String id;
    private String name;
    private int salary;
    private OrgUnit orgUnit;

    public Employee(String id, String name, int salary) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public void setOrgUnit(OrgUnit orgUnit) {
        this.orgUnit = orgUnit;
    }

    public void raiseSalary(int increment) {
        salary += increment;
    }

    public int getSalary() {
        return salary;
    }

    public OrgUnit getOrgUnit() {
        return orgUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;

        Employee employee = (Employee) o;

        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String getName() {
        return name;
    }
}
