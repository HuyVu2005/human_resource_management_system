/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Employee;

/**
 *
 * @author Lenovo
 */
public abstract class SalaryService {
    public static double Absence_Deduction = 50000;
    
    private EmployeeService empService;
    private AttendanceService attService;

    public SalaryService(EmployeeService empService, AttendanceService attService) {
        this.empService = empService;
        this.attService = attService;
    }

    public void calculateSalary(String empId, int month, int year) {
        //Kiem tra nhan vien co ton tai ko
        Employee emp = empService.findById(empId);
        if (emp == null) {
            System.out.println("This Employee is not exist!");
            return;
        }

        //tinh luong
        int abs = attService.countAbsence(empId, month, year);
        int ot = attService.sumOvertime(empId, month, year);

        double salary = emp.getBasicSalary() + ot * emp.getOvertimeRate() - abs * Absence_Deduction;

        System.out.println("\n===== SALARY =====");
        System.out.println("ID: " + empId);
        System.out.println("Name: " + emp.getName());
        System.out.println("Basic Salary: " + emp.getBasicSalary());
        System.out.println("Overtime Hours: " + ot);
        System.out.println("Absence: " + abs);
        System.out.println("→ FINAL SALARY: " + salary);
    }

}
