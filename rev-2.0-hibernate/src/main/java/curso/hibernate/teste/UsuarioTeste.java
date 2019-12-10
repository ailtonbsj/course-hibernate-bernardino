package curso.hibernate.teste;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import curso.hibernate.modelo.EstadoCivil;
import curso.hibernate.modelo.Usuario;
import curso.hibernate.modelo.Veiculo;

public class UsuarioTeste {
	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		usuario.setNome("Mateus");
		usuario.setNascimento(new Date());
		usuario.setIdade(12);
		usuario.setEstadoCivil(EstadoCivil.SOLTEIRO);
		
		Veiculo fusca = new Veiculo("Fusca", 1966);
		Veiculo brasilia = new Veiculo("Brasilia", 1980);
		fusca.setUsuario(usuario);
		brasilia.setUsuario(usuario);
		
		usuario.setVeiculos(new ArrayList<Veiculo>());
		usuario.getVeiculos().add(fusca);
		usuario.getVeiculos().add(brasilia);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.save(usuario);
		session.save(fusca);
		session.save(brasilia);
		
		session.getTransaction().commit();
		
		session.close();
	}
}
