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

		Query consulta = sessao.createQuery("select count(id) from Funcionario");
		Query consulta2 = sessao.createQuery("select sum(salario) from Funcionario");
		Query consulta3 = sessao.createQuery("select avg(salario) from Funcionario");
		Query consulta4 = sessao.createQuery("from Funcionario where salario = "
				+ "(select max(salario) from Funcionario)");
		try {
			long amount = (long) consulta.getSingleResult();
			double total = (double) consulta2.getSingleResult();
			double mean = (double) consulta3.getSingleResult();
			Funcionario maior = (Funcionario) consulta4.getResultList().get(0);
			System.out.println("Quantidade de funcionarios: " + amount);
			System.out.printf("Total dos salarios: %4.2f\n", total);
			System.out.printf("Média dos salarios: %4.2f\n", mean);
			System.out.printf("Maior salario: %4.2f\n", maior.getSalario());
			System.out.println("Funcionario de maior salario: " + maior.getNome());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		/*
		 *  ABS: Calcula o valor absoluto de um número.
			CONCAT: Concatena strings.
			DISTINCT: Retorno sem repeticao.
			CURRENT_DATE: Recupera a data atual.
			CURRENT_TIME: Recupera o horário atual.
			CURRENT_TIMESTAMP: Recupera a data e o horário atuais.
			LENGTH: Calcula o número de caracteres de uma string.
			LOCATE: Localiza uma string dentro de outra.
			LOWER: Deixa as letras de uma string minúsculas.
			MOD: Calcula o resto da divisão entre dois números.
			SIZE: Calcula o número de elementos de uma coleção.
			SQRT: Calcula a raiz quadrada de um número.
			SUBSTRING: Recupera um trecho de uma string.
			UPPER: Deixa as letras de uma string maiúsculas.
			TRIM: Elimina eventuais espaços no início e no fim de uma string.
		 */
	}
	
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
}