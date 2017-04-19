package Business;

import DataAccess.LogMapper;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LogManager {

    public static String saveLog(int ID,String action){

        Log log=new Log(ID,action);
        return LogMapper.save(log);
    }

    public static ArrayList<Log> getLogs(int employeeID, String fromDateText, String toDateText) {
        SimpleDateFormat parserSDF=new SimpleDateFormat("yyyy MM dd hh mm");
        Date fromDate =parserSDF.parse(fromDateText,new ParsePosition(0));
        Date toDate =parserSDF.parse(toDateText,new ParsePosition(0));
        return LogMapper.getLogs(employeeID,fromDate,toDate);
    }
}