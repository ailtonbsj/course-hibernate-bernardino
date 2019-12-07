package bernardino.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionHibernate {

	public static Session obterSession() {
		SessionFactory fac = new Configuration().configure().buildSessionFactory();
		Session session = fac.openSession();
		return session;
	}
	
}
