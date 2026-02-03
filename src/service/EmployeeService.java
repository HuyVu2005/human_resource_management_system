/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Employee;

/**
 *
 * @author Lenovo
 */
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();
    
    public void viewAll(){
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%-5s | %-20s | %-15s | %-15s | %-20s\n", "ID", "Name", "Job Title", "Department", "Salary");
        System.out.println("----------------------------------------------------------------------------------");
        
        for(Employee emp : employeeList){
            System.out.println(emp);
        }
    }
    
    // Tim theo ID
    public Employee findById(String id){
        for(Employee emp : employeeList){
            if(emp.getId().equalsIgnoreCase(id)){
                return emp;
            }
        }
        return null;
    }
    
    public List<Employee> getAll() {
        return employeeList;
    }
    
    // Them Nhan vien
    public boolean addEmployee(Employee emp){
        
        if(findById(emp.getId()) != null){
            System.out.println("ID already exist!");
            return false;
        }
        
        if(emp.getName().isEmpty() || emp.getDepartment().isEmpty()){
            System.out.println("Name or Department can't be empty!");
            return false;
        }
        
        
        employeeList.add(emp);
        return true;
    }
    
    public void updateEmployee(String id, String newDept, String newJob){
        
        Employee emp = findById(id);
        if(emp.getId() != null){
            if(!newDept.isEmpty()){
                emp.setDepartment(newDept);
            }
            if(!newJob.isEmpty()){
                emp.setJobTitle(newJob);
            }
            System.out.println("Employee added successfully.");
        }else{
            System.out.println("Can not find this Employee!");
        }
    }
}
