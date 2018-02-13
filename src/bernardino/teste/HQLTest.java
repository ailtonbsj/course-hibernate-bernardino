package bernardino.teste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import bernardino.modelo.Funcionario;

public class HQLTest {

	public static void main(String[] args) {
		Session sessao = SessionHibernate.obterSession();

		//from Funcionario where admissao = CURRENT_DATE
		Query consulta = sessao.createQuery(
				"from Funcionario where year(admissao) = :ano");
		consulta.setParameter("ano", 2018);

		List<Funcionario> funcionarios = 
				castList(Funcionario.class, consulta.getResultList());
		
		System.out.printf("Id\t | Nome\t\t | Salario\t | Admissão\n");
		for (Funcionario funcionario : funcionarios) {
			System.out.printf("%d\t | %s\t | %4.2f\t | %s\n", 
					funcionario.getId(),
					funcionario.getNome(),
					funcionario.getSalario(),
					funcionario.getAdmissao());
		}
	}
	
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
}