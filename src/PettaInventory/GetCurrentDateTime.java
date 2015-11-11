package PettaInventory;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 
 
public class GetCurrentDateTime {
    public static String usingDate() {
 
	    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    //get current date time with Date()
	    Date date = new Date();
	    return (dateFormat.format(date));
	}
	public static String usingCalendar() {
	   	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    //get current date time with Calendar()
	    Calendar cal = Calendar.getInstance();
	    return (dateFormat.format(cal.getTime()));
 
    }
}