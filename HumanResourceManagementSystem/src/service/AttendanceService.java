/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.ArrayList;
import model.Attendance;
import java.util.List;
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
}
