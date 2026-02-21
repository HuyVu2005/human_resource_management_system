/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Employee;
import model.FullTimeEmployee;
import model.PartTimeEmployee;

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
    
    public boolean removeEmployee(String id){
        Employee emp = findById(id);
        if(emp == null){
            System.out.println("Can not find Employee with ID: " + id);
            return false;
        }
        employeeList.remove(emp);
        System.out.println("Remove successfully!");
        return true;
        
    }
    
    public static void menuEmployeeService(EmployeeService EmpService, Scanner sc) {
        System.out.println("-------Employee Management-------");
        System.out.println("1. View all Employee");
        System.out.println("2. Add Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Remove Employee");
        System.out.println("5. Back to Main menu");
        System.out.println("Choose an option: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                EmpService.viewAll();
                break;
            case 2:
                System.out.println("=========================");
                System.out.println(" ADD EMPLOYEE ");
                System.out.println("=========================");
                System.out.println("Employee ID: ");
                String id = sc.nextLine();
                System.out.println("Full Name: ");
                String name = sc.nextLine();
                System.out.println("Department: ");
                String dept = sc.nextLine();
                System.out.println("Job Title: ");
                String job = sc.nextLine();
                System.out.println("Date of joining");
                LocalDate date = LocalDate.parse(sc.nextLine());
                System.out.println("Basic Salary: ");
                double salary = Double.parseDouble(sc.nextLine());
                System.out.println("Type: [1] Fulltime  [2] Parttime");
                int type = Integer.parseInt(sc.nextLine());

                Employee emp = (type == 1)
                        ? new FullTimeEmployee(id, name, dept, job, date, salary, true)
                        : new PartTimeEmployee(id, name, dept, job, date, salary, true);
                EmpService.addEmployee(emp);
                break;
            case 3: 
                System.out.println("Enter Employee ID to update: ");
                String idUpdate = sc.nextLine();
                
                Employee existingEmp = EmpService.findById(idUpdate);
                if(existingEmp != null){
                    System.out.println("Enter new Department: ");
                    String newDept = sc.nextLine();
                    System.out.println("Enter new Title job: ");
                    String newJob = sc.nextLine();
                    
                    EmpService.updateEmployee(idUpdate, newDept, newJob);
                }else{
                    System.out.println("This Employee do not exist!");
                }
                break;
            case 4: 
                System.out.println("Enter Employee ID to remove: ");
                String idRemove = sc.nextLine();
                
                EmpService.removeEmployee(idRemove);
                break;
            case 5: 
                System.out.println("Return to main menu....");
                return;
            default: 
                System.out.println("Invalid choice! Please choice agains.");
        }
    }
}
