package org.example;

import org.example.Model.Employee;
import org.example.Model.PensionPlan;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "John", "Doe", LocalDate.of(2019, 4, 1), 60000.00, null)); // No pension plan
        employees.add(new Employee(102, "Alice", "Smith", LocalDate.of(2018, 5, 15), 55000.00, new PensionPlan("P001", LocalDate.of(2020, 2, 10), 500.00)));
        employees.add(new Employee(103, "Bob", "Jones", LocalDate.of(2019, 4, 20), 62000.00, null)); // No pension plan


        Collections.sort(employees, Comparator.comparing(Employee::lastName)
                .thenComparing(Employee::yearlySalary, Comparator.reverseOrder()));


        System.out.println("[");
        for (Employee employee : employees) {
            System.out.println("  {");
            System.out.println("    \"Employee Id\": " + employee.employeeId() + ",");
            System.out.println("    \"First Name\": \"" + employee.firstName() + "\",");
            System.out.println("    \"Last Name\": \"" + employee.lastName() + "\",");
            System.out.println("    \"Employment Date\": \"" + employee.employmentDate() + "\",");
            System.out.println("    \"Yearly Salary\": " + employee.yearlySalary() + ",");
            if (employee.pensionPlan() != null) {
                PensionPlan pensionPlan = employee.pensionPlan();
                System.out.println("    \"Pension Plan\": {");
                System.out.println("      \"Plan Reference Number\": \"" + pensionPlan.planReferenceNumber() + "\",");
                System.out.println("      \"Enrollment Date\": \"" + pensionPlan.enrollmentDate() + "\",");
                System.out.println("      \"Monthly Contribution\": " + pensionPlan.monthlyContribution());
                System.out.println("    }");
            }
            System.out.println("  },");
        }
        System.out.println("]");


        LocalDate firstDateOfNextMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        LocalDate lastDateOfNextMonth = firstDateOfNextMonth.withDayOfMonth(firstDateOfNextMonth.lengthOfMonth());

        List<Employee> qualifyingEmployees = employees.stream()
                .filter(employee -> employee.pensionPlan() == null && isQualifyingForPension(employee, firstDateOfNextMonth, lastDateOfNextMonth))
                .sorted(Comparator.comparing(Employee::employmentDate))
                .collect(Collectors.toList());

        System.out.println("[");
        for (Employee employee : qualifyingEmployees) {
            System.out.println("  {");
            System.out.println("    \"Employee Id\": " + employee.employeeId() + ",");
            System.out.println("    \"First Name\": \"" + employee.firstName() + "\",");
            System.out.println("    \"Last Name\": \"" + employee.lastName() + "\",");
            System.out.println("    \"Employment Date\": \"" + employee.employmentDate() + "\",");
            System.out.println("    \"Yearly Salary\": " + employee.yearlySalary());
            System.out.println("  },");
        }
        System.out.println("]");
    }



    private static boolean isQualifyingForPension(Employee employee, LocalDate firstDateOfNextMonth, LocalDate lastDateOfNextMonth) {
        LocalDate employmentDatePlusFiveYears = employee.employmentDate().plusYears(5);
        return employmentDatePlusFiveYears.isAfter(firstDateOfNextMonth) && employmentDatePlusFiveYears.isBefore(lastDateOfNextMonth.plusDays(1));
    }
}

