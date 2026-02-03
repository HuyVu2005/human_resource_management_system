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
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Record Attendance");
            System.out.println("4. Calculate Salary");
            System.out.println("5. Report Excess Absence");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                // ADD EMPLOYEE
                case 1: {
                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Job Title: ");
                    String job = sc.nextLine();

                    System.out.print("Join Date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());

                    System.out.print("Basic Salary: ");
                    double salary = Double.parseDouble(sc.nextLine());

                    System.out.print("Type (1=FullTime, 2=PartTime): ");
                    int type = Integer.parseInt(sc.nextLine());

                    Employee e = (type == 1)
                            ? new FullTimeEmployee(id, name, dept, job, date, salary, true)
                            : new PartTimeEmployee(id, name, dept, job, date, salary, true);

                    empService.addEmployee(e);
                    break;
                }

                // VIEW ALL EMPLOYEES
                case 2:{
                    empService.viewAll();
                    break;
                }

                // RECORD ATTENDANCE
                case 3: {
                    System.out.print("Employee ID: ");
                    String id = sc.nextLine();

                    System.out.print("Date (yyyy-mm-dd): ");
                    LocalDate d = LocalDate.parse(sc.nextLine());

                    System.out.print("Status (Present/Absent/Leave): ");
                    String st = sc.nextLine();

                    System.out.print("OT Hours: ");
                    int ot = Integer.parseInt(sc.nextLine());

                    // LƯU Ý: constructor Attendance(empID, status, date, ot)
                    attService.record(new Attendance(id, st, d, ot));
                    break;
                }

                // CALCULATE SALARY
                case 4: {
                    System.out.print("Employee ID: ");
                    String id = sc.nextLine();

                    System.out.print("Month: ");
                    int m = Integer.parseInt(sc.nextLine());

                    System.out.print("Year: ");
                    int y = Integer.parseInt(sc.nextLine());

                    salaryService.calculateSalary(id, m, y);
                    break;
                }

                // REPORT EXCESS ABSENCE
                case 5: {
                    System.out.print("Month: ");
                    int m = Integer.parseInt(sc.nextLine());

                    System.out.print("Year: ");
                    int y = Integer.parseInt(sc.nextLine());

                    reportService.excessiveAbsence(m, y);
                    break;
                }

                case 0: {
                    System.out.println("Exiting...");
                    System.exit(0);
                }

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
