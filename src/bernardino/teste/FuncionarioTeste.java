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
		funcionario1.setNome("Manuel");
		funcionario1.setSalario(2000.0);
		funcionario1.setCpf("1238");
		funcionario1.setAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("13/02/2018"));
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Fabiana Lima");
		funcionario2.setSalario(3000.0);
		funcionario2.setCpf("1237");
		funcionario2.setAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("20/02/2018"));
		
		Funcionario funcionario3 = new Funcionario();
		funcionario3.setNome("Datiano Augusto");
		funcionario3.setSalario(6000.0);
		funcionario3.setCpf("1239");
		funcionario3.setAdmissao(new Date());
		
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
