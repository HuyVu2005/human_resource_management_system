
import java.time.LocalDate;
import java.util.Scanner;
import model.Employee;
import service.EmployeeService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Lenovo
 */
public class Main {

    public static void main(String[] args) {

        service.EmployeeService empManager = new EmployeeService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("======================================");
            System.out.println("HUMAN RESOURCE MANAGEMENT");
            System.out.println("======================================");
            System.out.println("1. Manage Employees.");
            System.out.println("2. Attendance Management.");
            System.out.println("3. Salary Management");
            System.out.println("4. Report.");
            System.out.println("5. Exit!");
            System.out.println("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:

            }

        }

    }

    public static void empManageMenu(EmployeeService empManager, Scanner sc) {
        System.out.println("Manage Employees Menu");
        System.out.println("1. View all Employees.");
        System.out.println("2. Add new Employee.");
        System.out.println("3. Update Employee.");
        System.out.println("4. Remove Employee.");

        int choice = Integer.parseInt(sc.nextLine());
        

        switch (choice) {
            case 1:
                empManager.viewAll();
                break;
            case 2:

                System.out.println("Employee ID: ");
                String id = sc.nextLine();
                System.out.println("Full Name: ");
                String name = sc.nextLine();
                System.out.println("Department: ");
                String dept = sc.nextLine();
                System.out.println("Job title: ");
                String job = sc.nextLine();
                System.out.println("Date of joining: ");
                String dateJoin = sc.nextLine();
                System.out.println("Basic Salary: ");
                double salary = Double.parseDouble(sc.nextLine());
                System.out.println("Type: ([1]Full-time   [2]Part-time");
                int empType = Integer.parseInt(sc.nextLine());
                switch (empType) {
                    case 1:
                        
                    case 2: 
                        
                }

                

        }
    }
}
