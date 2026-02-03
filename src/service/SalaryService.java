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
    private EmployeeService empService;
    private AttendanceService attService;

    public SalaryService(EmployeeService empService, AttendanceService attService) {
        this.empService = empService;
        this.attService = attService;
    }
    
    public void calculateSalary(String empId, int month, int year){
        //Kiem tra nhan vin co ton tai ko
        Employee emp = empService.findById(empId);
        if(emp == null){
            System.out.println("This Employee is not exist!");
            return;
        }
        
        //
        
    }
   
    
}
