
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
            System.out.println("--------------------------------------");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                // Manage Employees
                case 1: {
                    EmployeeService.menuEmployeeService(empService, sc);
                    break;
                }

                // Attendance Management
                case 2: {
                    AttendanceService.menuAttendanceService(sc,attService);
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
                    System.out.println("Exiting....");
                    return;
                }
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    public static void menuSalaryService(){
        // to do
    }
}
