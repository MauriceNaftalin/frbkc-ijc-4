package org.frbkc.ijc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.frbkc.ijc.DepartmentId.*;
import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    private Company company;

    @BeforeEach
    void setUp() {
        company= CompanyData.createCompany();
    }

    @Test
    void testHighestPaid() {
        assertEquals("Jody Foster", company.getHighestPaid().getName());
    }

    @Test
    void testGetEmployees() {
        final Set<Employee> expectedEmployees = new HashSet<>(CompanyData.getEmployeeDirectory().values());
        final Set<Employee> actualEmployees = company.getEmployees();
        assertEquals(expectedEmployees.size(), actualEmployees.size());
        assertEquals(expectedEmployees, actualEmployees);
    }

    @Test
    void testApplyRaise() {
        int dfosteBeforeSalary = CompanyData.getEmployeeDirectory().get("dfoste").getSalary();
        int jfosteBeforeSalary = CompanyData.getEmployeeDirectory().get("jfoste").getSalary();
        company.applyRaise(100);
        int dfosteAfterSalary = CompanyData.getEmployeeDirectory().get("dfoste").getSalary();
        int jfosteAfterSalary = CompanyData.getEmployeeDirectory().get("jfoste").getSalary();
        assertEquals(dfosteBeforeSalary + 100, dfosteAfterSalary);
        assertEquals(jfosteBeforeSalary + 200, jfosteAfterSalary);
    }

    @Test
    void testEmployeesInDepartment() {
        Department sales = company.getDepartmentDirectory().get(DepartmentId.SALES);
        Set<Employee> employeesFromSales = sales.getEmployees();
        Set<Employee> expectedSalesEmployees = company.getEmployees().stream()
                .filter(e -> e.getOrgUnit().equals(sales))
                .collect(toSet());
        assertEquals(expectedSalesEmployees, employeesFromSales);
    }

    @Test
    void testDepartmentCosts() {
        Map<DepartmentId, Department> departmentDirectory = company.getDepartmentDirectory();
        Map<Department, Integer> departmentCosts = company.getDepartmentCosts();
        assertEquals(departmentCosts.get(departmentDirectory.get(SALES)),18399);
        assertEquals(departmentCosts.get(departmentDirectory.get(PRODUCTION)),19295);
        assertEquals(departmentCosts.get(departmentDirectory.get(RESEARCH)),8700);
    }
}