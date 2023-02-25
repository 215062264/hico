package com.hico.hico.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String salutation;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private int employeeNumber;
    @Column(nullable = false)
    private double salary;
    @Column(nullable = false)
    private String empProfileColor;

    public Employee() {
    }

    public Employee(Long employeeId, String firstName, String lastName, String salutation, String gender, int employeeNumber, double salary, String empProfileColor) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salutation = salutation;
        this.gender = gender;
        this.employeeNumber = employeeNumber;
        this.salary = salary;
        this.empProfileColor = empProfileColor;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmpProfileColor() {
        return empProfileColor;
    }

    public void setEmpProfileColor(String empProfileColor) {
        this.empProfileColor = empProfileColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId.equals(employee.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salutation='" + salutation + '\'' +
                ", gender='" + gender + '\'' +
                ", employeeNumber=" + employeeNumber +
                ", salary=" + salary +
                ", empProfileColor='" + empProfileColor + '\'' +
                '}';
    }
}
