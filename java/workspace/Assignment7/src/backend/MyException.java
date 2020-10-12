package backend;

import java.time.LocalDate;

public class MyException {
	private String message;
	private String reason;
	private String stackTrace;
	private LocalDate time;
	
	public void writeLog(String message,String reason,String stackTrace, LocalDate time) {
		
	}
	
	public void writeLog(MyException exception) {
		
	}
}
