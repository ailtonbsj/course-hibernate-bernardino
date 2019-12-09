package curso.hibernate.teste;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import curso.hibernate.modelo.EstadoCivil;
import curso.hibernate.modelo.Usuario;
import curso.hibernate.modelo.Veiculo;

public class UsuarioTeste {
	public static void main(String[] args) {
//		Endereco endereco = new Endereco();
//		endereco.setCidade("Ico");
//		endereco.setLogradouro("Rua G");
//		endereco.setNumero(2);
		
//		Endereco enderecoComercial = new Endereco();
//		enderecoComercial.setCidade("Ico");
//		enderecoComercial.setLogradouro("Rua B");
//		enderecoComercial.setNumero(12);
		
		Usuario usuario = new Usuario();
		usuario.setNome("Mateus");
		usuario.setNascimento(new Date());
		usuario.setIdade(12);
		usuario.setEstadoCivil(EstadoCivil.SOLTEIRO);
		//usuario.setEndereco(endereco);
		//usuario.setEnderecoComercial(enderecoComercial);
		
//		Endereco end1 = new Endereco();
//		end1.setCidade("Cedro");
//		end1.setLogradouro("Prado");
//		end1.setNumero(1);
//		
//		Endereco end2 = new Endereco();
//		end2.setCidade("Jaguaribe");
//		end2.setLogradouro("Rua dos Alfineiros");
//		end2.setNumero(100);
		
//		usuario.getEndExtras().add(end1);
//		usuario.getEndExtras().add(end2);
		
		Veiculo fusca = new Veiculo("Fusca", 1966);
		usuario.setVeiculo(fusca);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.save(usuario);
		session.save(fusca);
		session.getTransaction().commit();
		
		session.close();
	}
}
