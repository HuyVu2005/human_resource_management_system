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
public class FullTimeEmployee extends Employee{
    private int otHours;
    private int absentDays;

    public FullTimeEmployee(int otHours, int absentDays, String id, String name, String department, String jobTitle, LocalDate joiningDate, double basicSalary, boolean active) {
        super(id, name, department, jobTitle, joiningDate, basicSalary, active);
        this.otHours = otHours;
        this.absentDays = absentDays;
    }
    
    
}
