package domain;

import org.aspectj.lang.ProceedingJoinPoint;

public class ContactLogger {
	
	public void log(ProceedingJoinPoint pjp,Contact contact) throws Throwable {
		try {
		
			System.out.println("Utilisation d'aop");
			pjp.proceed();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
