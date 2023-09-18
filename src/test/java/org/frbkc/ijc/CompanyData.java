package org.frbkc.ijc;

import java.util.*;

public class CompanyData {

    public static Map<String,Employee> employeeDirectory = new HashMap<>(Map.of(
            "dfoste",new Employee("dfoste", "Daniel Foster",1200),
            "trhart",new Manager("trhart", "Tracy Hart",1200, "Rm102"),
            "jfoste",new Manager("jfoste", "Jody Foster", 10100, "Rm999"),
            "tcruis",new Employee("tcruis", "Tom Cruise", 8350),
            "batman",new Employee("batman", "Bat Man", 7500),
            "dvader",new Employee("dvader","Darth Vader", 9654),
            "hlecte",new Manager("hlecte", "Hannibal Lecter", 9745, "Rm104"),
            "jrober",new Manager("jrober", "Julia Roberts", 8745, "Rm103")
    ));

    public static Map<String, Employee> getEmployeeDirectory() {
        return employeeDirectory;
    }

    public static Company createCompany() {

        Map<DepartmentId, Department> departmentDirectory = new HashMap<>();

        // TODO populate the Map departmentDirectory with key-value pairs, where the key
        // is a member of the DepartmentId enum, and the value is a new Department

        Department sales = departmentDirectory.get(DepartmentId.SALES);
        Department production = departmentDirectory.get(DepartmentId.PRODUCTION);
        Department research = departmentDirectory.get(DepartmentId.RESEARCH);

        production.addEmployee(employeeDirectory.get("dfoste"));
        production.addEmployee(employeeDirectory.get("tcruis"));
        production.addEmployee(employeeDirectory.get("hlecte"));
        sales.addEmployee(employeeDirectory.get("dvader"));
        sales.addEmployee(employeeDirectory.get("jrober"));
        research.addEmployee(employeeDirectory.get("trhart"));
        research.addEmployee(employeeDirectory.get("batman"));

        Company company = new Company("Acme Products", departmentDirectory, employeeDirectory);
        company.setCeo((Manager)employeeDirectory.get("jfoste"));

        return company;
    }
}
