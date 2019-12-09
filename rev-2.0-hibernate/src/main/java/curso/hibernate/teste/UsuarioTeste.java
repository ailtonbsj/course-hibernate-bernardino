package curso.hibernate.teste;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import curso.hibernate.modelo.Endereco;
import curso.hibernate.modelo.EstadoCivil;
import curso.hibernate.modelo.Usuario;

public class UsuarioTeste {
	public static void main(String[] args) {
		Endereco endereco = new Endereco();
		endereco.setCidade("Ico");
		endereco.setLogradouro("Rua G");
		endereco.setNumero(2);
		
		Usuario usuario = new Usuario();
		usuario.setNome("Mateus");
		usuario.setNascimento(new Date());
		usuario.setIdade(12);
		usuario.setEstadoCivil(EstadoCivil.SOLTEIRO);
		usuario.setEndereco(endereco);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		session.save(usuario);
		session.getTransaction().commit();
		session.close();
	}
}
