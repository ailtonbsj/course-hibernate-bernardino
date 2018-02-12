package bernardino.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bernardino.modelo.Funcionario;
import bernardino.modelo.Projeto;

public class FuncionarioTeste {

	public static void main(String[] args) throws ParseException {
		
		SessionFactory fac = new Configuration().configure().buildSessionFactory();
		Session session = fac.openSession();
		session.beginTransaction();
		
		Projeto projeto1 = new Projeto();
		projeto1.setNome("Projeto 1");
		
		Projeto projeto2 = new Projeto();
		projeto1.setNome("Projeto 2");
		
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("João Batista");
		funcionario1.setSalario(2000.0);
		funcionario1.setCpf("1234");
		funcionario1.setAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2014"));
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Maria Silva");
		funcionario2.setSalario(3000.0);
		funcionario2.setCpf("1235");
		funcionario2.setAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2015"));
		
		Funcionario funcionario3 = new Funcionario();
		funcionario3.setNome("Jota Silva");
		funcionario3.setSalario(6000.0);
		funcionario3.setCpf("1236");
		funcionario3.setAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2017"));
		
		funcionario1.getProjetos().add(projeto1);
		funcionario1.getProjetos().add(projeto2);
		funcionario2.getProjetos().add(projeto1);
		
		projeto1.getFuncionarios().add(funcionario1);
		projeto1.getFuncionarios().add(funcionario2);
		projeto2.getFuncionarios().add(funcionario1);
		
		session.save(funcionario1);
		session.save(funcionario2);
		session.save(funcionario3);
		session.save(projeto1);
		session.save(projeto2);
		
		session.getTransaction().commit();
		session.close();
	}
}
