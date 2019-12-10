package curso.hibernate.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import curso.hibernate.modelo.Funcionario;
import curso.hibernate.modelo.Projeto;

public class FuncionarioTeste {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("João Batista");
		funcionario.setSalario(2000.0);
		
		Projeto projeto1 = new Projeto();
		projeto1.setNome("Projeto 1");
		
		Projeto projeto2 = new Projeto();
		projeto2.setNome("Projeto 2");
		
		funcionario.getProjetos().add(projeto1);
		funcionario.getProjetos().add(projeto2);
		
		session.save(projeto1);
		session.save(projeto2);
		session.save(funcionario);
		session.getTransaction().commit();
		session.close();
	}
}
