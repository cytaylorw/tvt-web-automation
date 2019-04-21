package web.automation.core.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WebDate {

	
	public static String timeForTimer(){
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(new Date());
	}
	
	public static String timeForLogFile(){
		return (new SimpleDateFormat("yyyyMMdd-HHmmss")).format(new Date());
	}
	
	public static String timeForExceptionScreen(){
		return (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
	}
}
