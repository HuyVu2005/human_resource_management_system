/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Lenovo
 */
public class PartTimeEmployee extends Employee{

    public PartTimeEmployee(String id, String name, String department, String jobTitle, LocalDate joiningDate, double basicSalary, boolean active) {
        super(id, name, department, jobTitle, joiningDate, basicSalary, active);
    }
    
    @Override
    public double getOvertimeRate() {
        return 50000; // 50k/hour
    }
}
