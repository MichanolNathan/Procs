package domain;

import org.aspectj.lang.ProceedingJoinPoint;

public class ContactLogger {
	
	public void log(Contact contact) throws Throwable {
		try {
		
			System.out.println("Utilisation d'aop");
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
