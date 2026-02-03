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
    private int otHours;
    private int absentsDay;

    public PartTimeEmployee(int otHours, int absentsDay, String id, String name, String department, String jobTitle, LocalDate joiningDate, double basicSalary, boolean active) {
        super(id, name, department, jobTitle, joiningDate, basicSalary, active);
        this.otHours = otHours;
        this.absentsDay = absentsDay;
    }
    
    
    
    
    
}
