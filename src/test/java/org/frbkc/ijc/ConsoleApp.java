package org.frbkc.ijc;

import java.util.List;
import java.util.Scanner;
public class ConsoleApp {
/*
    public static void main(String[] args) {
        // fake the creation of a Company from database data
        Company company = CompanyData.createCompany();

        // get user input to provide choice of operations
        var scanner = new Scanner(System.in);
        displayMenu();
        char option = scanner.nextLine().charAt(0);
        while (option != 'z') {
            if (option == 'a') {
                // list all employees
                List<Person> employees = company.getEmployees();
                for (Person employee : employees) {
                    System.out.println(employee);
                }
            } else if (option == 'b') {
                // print the highest salary
                System.out.println(company.highestPaid().getSalary());
            } else if (option == 'c') {
                // print the average pay
                System.out.println("not implemented yet");
            } else if (option == 'd') {
                // give every employee a raise
                System.out.print("How much? ");
                int raise = scanner.nextInt();
                scanner.nextLine();
                company.applyRaise(raise);
                for (Person employee : company.getEmployees()) {
                    System.out.println(employee);
                }
            } else if (option == 'e') {
                // print the first few employees
                System.out.print("How many? ");
                int howMany = scanner.nextInt();
                scanner.nextLine();
                company.getFirstFew(howMany);
                System.out.println("not implemented yet");
            } else if (option == 'f') {
                // print the number of employees earning less than user-entered amount
                System.out.println("not implemented yet");
            } else if (option == 'g') {
                // list employees earning less than a user-entered amount
                System.out.print("Salary: ");
                int salary = scanner.nextInt();
                scanner.nextLine();
                final List<Person> employeesEarningLessThan = company.getLowPaidEmployees(salary);
                for (Person e : employeesEarningLessThan) {
                    if (e == null) {
                        break;
                    } else {
                        System.out.println(e);
                    }
                }
            } else if (option == 'h') {
                // list the company's employees in reverse order
                System.out.println("not implemented yet");
            } else if (option == 'i') {
                // replace the first employee with a newly-created employee
                System.out.print("Person Name: ");
                String name = scanner.nextLine();
                System.out.print("Person Salary: ");
                int salary = scanner.nextInt();
                scanner.nextLine();
                // TODO replace the next line with the creation of a new employee
                System.out.println("not implemented yet");
            } else if (option == 'j') {
                // list the employees in reverse order
                System.out.println("not implemented yet");
            }
            displayMenu();
            option = scanner.nextLine().charAt(0);
        }
    }

    private static void displayMenu() {
        System.out.println("Program Options:");
        System.out.println("   z: exit");
        System.out.println("   a: list all employees");
        System.out.println("   b: print the highest salary");
        System.out.println("   c: print the average pay");
        System.out.println("   d: give every employee a raise");
        System.out.println("   e: print the first few employees");
        System.out.println("   f: print the number of employees earning less than user-entered amount");
        System.out.println("   g: list the employees earning less than user-entered amount");
        System.out.println("   h: list the company's employees in reverse order");
        System.out.println("   i: replace the first employee with a newly-created employee");
        System.out.print("Choose an option: ");
    }

 */
}