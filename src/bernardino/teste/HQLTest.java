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
		Query consulta = sessao.createQuery("from Funcionario order by nome");
		
		List<Funcionario> funcionarios = 
				castList(Funcionario.class, consulta.getResultList());
		for (Funcionario funcionario : funcionarios) {
			System.out.println("Nome: " + funcionario.getNome()
			+ "| Salario: " + funcionario.getSalario());
		}
	}
	
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
}
