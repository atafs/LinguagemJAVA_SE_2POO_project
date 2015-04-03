package control_2OO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Start_OO_control23_Date {

	public static void main(String[] args) {

		Date d = new Date();
		System.out.println("[Hoje: " + d + "]");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		try {
			d = sdf.parse("11/09/1979");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(sdf.format(d) + "\n");
		
		Locale local1 = new Locale("en");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyy E", local1);
		System.out.println(sdf1.format(d));
		
		Locale local2 = new Locale("ja");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyy E", local2);
		System.out.println(sdf2.format(d));
		
		Locale local3 = new Locale("in");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyy E", local3);
		System.out.println(sdf3.format(d));

	}
	

}
