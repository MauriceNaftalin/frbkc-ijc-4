package org.frbkc.ijc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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
}