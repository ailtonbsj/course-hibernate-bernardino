package bernardino.teste;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;

import bernardino.modelo.Funcionario;

public class HQLTest {

	public static void main(String[] args) {
		Session sessao = SessionHibernate.obterSession();
		int id = 2;
		double salario = 5000;
		Query consulta = sessao.createQuery(
				"from Funcionario where id = :id and salario < :sal order by id");
		consulta.setParameter("id", id);
		consulta.setParameter("sal", salario);

		try {
			Funcionario funcionario = (Funcionario) consulta.getSingleResult();
			System.out.printf("Id\t | Nome\t\t | Salario\n");
			System.out.printf("%d\t | %s\t | %4.2f\n", 
					funcionario.getId(),
					funcionario.getNome(),
					funcionario.getSalario());
		} catch (NonUniqueResultException e) {
			System.out.println("Muitas linhas!!!");
		}
	}
	
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
}