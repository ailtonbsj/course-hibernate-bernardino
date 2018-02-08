package bernardino.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bernardino.modelo.Funcionario;
import bernardino.modelo.Projeto;

public class FuncionarioTeste {

	public static void main(String[] args) {
		
		SessionFactory fac = new Configuration().configure().buildSessionFactory();
		Session session = fac.openSession();
		session.beginTransaction();
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("João Batista");
		funcionario.setSalario(2000.0);
		
		Projeto projeto1 = new Projeto();
		projeto1.setNome("Projeto 1");
		
		Projeto projeto2 = new Projeto();
		projeto1.setNome("Projeto 2");
		
		funcionario.getProjetos().add(projeto1);
		funcionario.getProjetos().add(projeto2);
		
		session.save(funcionario);
		session.save(projeto1);
		session.save(projeto2);
		
		session.getTransaction().commit();
		session.close();
	}

}
