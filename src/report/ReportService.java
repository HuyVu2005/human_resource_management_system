/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;
import model.Employee;
import service.AttendanceService;
import service.EmployeeService;
/**
 *
 * @author Lenovo
 */
public class ReportService {
    private EmployeeService empService;
    private AttendanceService attService;

    public ReportService(EmployeeService empService, AttendanceService attService) {
        this.empService = empService;
        this.attService = attService;
    }
    
    public void excessiveAbsence(int month, int year) {
        System.out.println("\n===== REPORT: Excessive Absence =====");

        for (Employee e : empService.getAll()) {
            int abs = attService.countAbsence(e.getId(), month, year);

            if (abs >= 2) {
                System.out.println(e.getId() + " - " + e.getName() + " | Absences: " + abs);
            }
        }
    }
}
