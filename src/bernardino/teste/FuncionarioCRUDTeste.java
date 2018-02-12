package bernardino.teste;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bernardino.modelo.Funcionario;

public class FuncionarioCRUDTeste {
	
	public static void main(String[] args) {
		
		Funcionario func1 = new Funcionario("Mario", 1500.0, "12345", new Date());
		create(func1);
		Funcionario func2 = read(2);
		System.out.println(func2.getNome());
		func2.setNome("Mario da Silva");
		func2.setCpf("00000");
		update(func2);
		delete(func2);
	}
	
	public static void delete(Funcionario func1) {
		Session session = obterSession();
		session.beginTransaction();
		session.delete(func1);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void update(Funcionario func1) {
		Session session = obterSession();
		session.beginTransaction();
		session.update(func1);
		session.getTransaction().commit();
		session.close();
	}
	
	public static Funcionario read(Integer id) {
		Session session = obterSession();
		Funcionario func = session.get(Funcionario.class, id);
		session.close();
		return func;
	}
	
	public static void create(Funcionario func1) {
		Session session = obterSession();
		session.beginTransaction();
		session.save(func1);
		session.getTransaction().commit();
		session.close();
	}
	
	public static Session obterSession() {
		SessionFactory fac = new Configuration().configure().buildSessionFactory();
		Session session = fac.openSession();
		return session;
	}
}
