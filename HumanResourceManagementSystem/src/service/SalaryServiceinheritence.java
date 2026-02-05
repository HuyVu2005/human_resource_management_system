/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Lenovo
 */
public class SalaryServiceinheritence extends SalaryService {

    public SalaryServiceinheritence(EmployeeService empService, AttendanceService attService) {
        super(empService, attService);
    }
}
