package bernardino.teste;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bernardino.modelo.EstadoCivil;
import bernardino.modelo.Usuario;

public class UsuarioTeste {

	public static void main(String[] args) {
		
		Usuario user = new Usuario();
		user.setNome("Clark");
		user.setDataNascimento(new Date());
		user.setIdade(30);
		user.setEstadoCivil(EstadoCivil.SOLTEIRO);
		
		SessionFactory fac = new Configuration().configure().buildSessionFactory();
		Session ss = fac.openSession();
		ss.beginTransaction();
		
		ss.save(user);
		ss.getTransaction().commit();
		ss.close();

	}

}