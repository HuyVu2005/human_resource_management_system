
import model.*;
import service.*;
import report.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Tạo các service
        EmployeeService empService = new EmployeeService();
        AttendanceService attService = new AttendanceService();
        SalaryService salaryService = new SalaryServiceinheritence(empService, attService);
        ReportService reportService = new ReportService(empService, attService);

        while (true) {
            System.out.println("======================================");
            System.out.println("   HUMAN RESOURCE MANAGEMENT SYSTEM   ");
            System.out.println("======================================");
            System.out.println("1. Manage Employees");
            System.out.println("2. Attendance Management");
            System.out.println("3. Salary Management");
            System.out.println("4. Report");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                // Manage Employees
                case 1: {
                    menuEmployeeService(empService, sc);
                    break;
                }

                // Attendance Management
                case 2: {
                    menuAttendanceService();
                    break;
                }

                // Salary Management
                case 3: {
                    menuSalaryService();
                    break;
                }

                // Report
                case 4: {
                    reportService.excessiveAbsence(choice, choice);
                    break;
                }

                // Exit
                case 5: {
                    System.out.println("Exitting....");
                    return;
                }
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    //Menu Manage Employees
    public static void menuEmployeeService(EmployeeService EmpService, Scanner sc) {
        System.out.println("\n-------Employee Management-------\n");
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
                System.out.println(" Manage Employees Menu");
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
    
    public static void menuAttendanceService(){
        // to do 
    }
    
    public static void menuSalaryService(){
        // to do
    }
}
