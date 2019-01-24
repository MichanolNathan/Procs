package loggerAOP;


import modele.Contact;

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
