package org.frbkc.ijc;

import java.util.*;

public class Department implements OrgUnit {

    final private DepartmentId id;
    final private Set<Employee> employees;

    public Department(DepartmentId id) {
        this.id = id;
        employees = new HashSet<>();
    }

    public void addEmployee(Employee e) {
        employees.add(e);
        e.setOrgUnit(this);
    }

    public String getName() {
        return id.toString();
    }

    // TODO implement getManagedUnits()

    @Override
    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Department that = (Department) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Department{" + "id='" + id + '\'' + '}';
    }
}
