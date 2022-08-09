import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class GetInTouchDAO 
{
	public void addfeedback(String name,String email,String message,String subject)
	{
		System.out.println("Onject created1....");
		Configuration cfg = new Configuration();
		System.out.println("Onject created2....");
		cfg.configure("hibernate.cfg.xml");
		
		System.out.println("Onject created3....");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		System.out.println("Onject created4....");
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		feedback obj = new feedback();
		String fid = email+subject;
		obj.setFid(fid);
		obj.setName(name);
		obj.setEmail(email);
		obj.setSubject(subject);
		obj.setMessage(message);
		
		tx.commit();
		
		s.close();
		sf.close();
	}
}
