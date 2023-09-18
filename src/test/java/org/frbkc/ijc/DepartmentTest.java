package org.frbkc.ijc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.frbkc.ijc.DepartmentId.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DepartmentTest {

    private Company company;

    @BeforeEach
    void setUp() {
        company= CompanyData.createCompany();
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