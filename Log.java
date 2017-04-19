package Business;

import java.sql.Timestamp;
import java.util.Date;

public class Log {

    private int employeeID;
    private String action;
    private Date date;

    public Log(int employeeID, String action)
    {
        setEmployeeID(employeeID);
        setAction(action);
        setDate(new Date());
    }

    public Log(int employeeID, String action, Timestamp date) {
        setEmployeeID(employeeID);
        setAction(action);
        setDate(date);
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}