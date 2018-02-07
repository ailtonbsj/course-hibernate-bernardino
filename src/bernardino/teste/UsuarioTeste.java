package bernardino.teste;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bernardino.modelo.Endereco;
import bernardino.modelo.EstadoCivil;
import bernardino.modelo.Usuario;
import bernardino.modelo.Veiculo;

public class UsuarioTeste {

	public static void main(String[] args) {
		
		Usuario clark = new Usuario();
		Veiculo fusca = new Veiculo("Fusca", 1966);
		
		clark.setNome("Clark");
		clark.setDataNascimento(new Date());
		clark.setIdade(30);
		clark.setEstadoCivil(EstadoCivil.SOLTEIRO);
		clark.setVeiculo(fusca);
		
		fusca.setUsuario(clark);
		
		Usuario louis = new Usuario();
		louis.setNome("Louis");
		louis.setDataNascimento(new Date());
		louis.setIdade(25);
		louis.setEstadoCivil(EstadoCivil.SOLTEIRO);
		
		
		SessionFactory fac = new Configuration().configure().buildSessionFactory();
		Session ss = fac.openSession();
		ss.beginTransaction();
		
		ss.save(louis);
		
		ss.save(clark);
		
		ss.getTransaction().commit();
		
		Usuario userFromDB = ss.get(Usuario.class, 2);
		
		System.out.println("Nome: " + userFromDB.getNome());

		ss.close();

	}

}