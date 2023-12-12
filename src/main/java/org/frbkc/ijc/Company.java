package org.frbkc.ijc;

import java.util.*;

public class Company implements OrgUnit {
    final private String name;

    final private Map<DepartmentId,Department> departmentDirectory;
    final private Map<String,Employee> employeeDirectory;
    private Manager ceo;

    public Company(String name, Map<DepartmentId, Department> departmentDirectory, Map<String, Employee> employeeDirectory) {
        this.name = name;
        this.departmentDirectory = departmentDirectory;
        this.employeeDirectory = employeeDirectory;
    }

    public Map<DepartmentId, Department> getDepartmentDirectory() {
        return departmentDirectory;
    }

    public void setCeo(Manager ceo) {
        this.ceo = ceo;
        ceo.setOrgUnit(this);
    }

    // TODO implement getEmployees()


    // TODO implement getManagedUnits()
    @Override
    public Set<? extends OrgUnit> getManagedUnits() {
        return new HashSet<>(departmentDirectory.values());
    }

    @Override
    public String getName() {
        return name;
    }

    public Employee getHighestPaid() {
        // TODO implement highestPaid
        return null;
    }

    public Map<Department,Integer> getDepartmentCosts() {
        // TODO implement getDepartmentCosts (Map from Department to total salary for that Department)
        Map<Department,Integer> departmentCosts = new HashMap<>();
        for (Department d : getDepartmentDirectory().values()) {
            int departmentCost = 0;
            for (Employee e : d.getEmployees()) {
                departmentCost += e.getSalary();
            }
            departmentCosts.put(d, departmentCost);
        }
        return departmentCosts;
    }

    public void applyRaise(int raise) {
        for (Employee e: getEmployees()) {
            e.raiseSalary(raise);
        }
    }
}
