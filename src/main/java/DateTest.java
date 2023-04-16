import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		int reuse = 30;
		
		//GET Current Date then Concat deleteOTPTime
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateTime = dateFormat.format(new Date());
		System.out.println(dateTime);
		 
		Date d = dateFormat.parse(dateTime); 
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MINUTE, -reuse);

		String time = dateFormat.format(cal.getTime());
		System.out.println(time);
		//HashMap<String, Object> values = new HashMap<String, Object>();
		//values.put("time", time);
System.out.println(time);
	}

}
