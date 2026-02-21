/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Attendance;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class AttendanceService {

    private List<Attendance> list = new ArrayList<>();

    public void record(Attendance A) {
        list.add(A);
        System.out.println("Attendance recorded");
    }

    public int countAbsence(String empId, int month, int year) {
        int abs = 0;
        for (Attendance A : list) {
            if (A.getEmployeeID().equals(empId)
                    && A.getDate().getYear() == year
                    && A.getDate().getMonthValue() == month
                    && A.getStatus().equalsIgnoreCase("Absent")) {
                abs++;
            }
        }
        return abs;
    }

    public int sumOvertime(String empId, int month, int year) {
        int ot = 0;
        for (Attendance A : list) {
            if (A.getEmployeeID().equals(empId)
                    && A.getDate().getYear() == year
                    && A.getDate().getMonthValue() == month) {
                ot += A.getOvertimeHours();
            }
        }
        return ot;
    }

    private static List<Attendance> attendanceList = new ArrayList<>();

    public void viewAttendance() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //format date theo form mình muốn
        System.out.println("------------------------------------------");
        System.out.printf("%-10s  %-10s  %-10s\n", "Date", "Status", "Overtime");
        System.out.println("------------------------------------------");
        for (Attendance a : attendanceList) {
            System.out.printf("%-10s  %-10s  %-10d\n",
                    a.getDate().format(formatter), //format để in ra output với form dd/mm/yy
                    a.getStatus(),
                    a.getOvertimeHours());
        }
        System.out.println("------------------------------------------");
    }

    public static void menuAttendanceService(Scanner sc, AttendanceService attService) {
        // to do 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("-------Attendance Management-------");
        System.out.println("1. Record Attendance");
        System.out.println("2. View Attendance History");
        System.out.println("3. Back to Main menu");
        System.out.print("Choose an option: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                System.out.println("------- Record Attendance -------");
                System.out.print("Employee ID: ");
                String employeeID = sc.nextLine();
                System.out.print("Date: ");
                LocalDate date = LocalDate.parse(sc.nextLine(), formatter);
                System.out.print("Status: ");
                String status = sc.nextLine();
                System.out.print("Overtime Hours: ");
                int overtimeHours = Integer.parseInt(sc.nextLine());

                Attendance a = new Attendance(employeeID, status, date, overtimeHours);
                attendanceList.add(a);
                
                System.out.println("Attendance recorded successfully");
                break;
            case 2:
                attService.viewAttendance();
                break;
            case 3:
                System.out.println("Return to main menu....");
                return;
            default:
                System.out.println("Invalid choice! Please choice agains.");
        }

    }
}
