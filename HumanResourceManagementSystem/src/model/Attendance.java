
package model;
import java.time.LocalDate;

public class Attendance {
    private String employeeID;
    private String status;
    private LocalDate date;
    private int overtimeHours;

    public Attendance(String employeeID, String status, LocalDate date, int overtimeHours) {
        this.employeeID = employeeID;
        this.status = status;
        this.date = date;
        this.overtimeHours = overtimeHours;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
    
}