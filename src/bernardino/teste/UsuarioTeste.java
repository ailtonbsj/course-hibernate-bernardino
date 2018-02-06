package bernardino.teste;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bernardino.modelo.Endereco;
import bernardino.modelo.EstadoCivil;
import bernardino.modelo.Usuario;

public class UsuarioTeste {

	public static void main(String[] args) {
		
		Usuario user0 = new Usuario();
		user0.setNome("Louis");
		user0.setDataNascimento(new Date());
		user0.setIdade(25);
		user0.setEstadoCivil(EstadoCivil.SOLTEIRO);
		
		Usuario user = new Usuario();
		user.setNome("Clark");
		user.setDataNascimento(new Date());
		user.setIdade(30);
		user.setEstadoCivil(EstadoCivil.SOLTEIRO);
		
		Endereco adrr = new Endereco();
		adrr.setLogradouro("Rua A");
		adrr.setNumero(11);
		adrr.setCidade("Sao Paulo");
		user.getEnderecos().add(adrr);
		
		Endereco adrrCom = new Endereco();
		adrrCom.setLogradouro("Rua B");
		adrrCom.setNumero(12);
		adrrCom.setCidade("Rio de Janeiro");
		user.getEnderecos().add(adrrCom);
		
		SessionFactory fac = new Configuration().configure().buildSessionFactory();
		Session ss = fac.openSession();
		ss.beginTransaction();
		
		ss.save(user0);
		ss.save(user);
		ss.getTransaction().commit();
		
		Usuario userFromDB = ss.get(Usuario.class, 2);
		
		System.out.println("Nome: " + userFromDB.getNome());
		List<Endereco> enderecos = userFromDB.getEnderecos();
		System.out.println("Ainda nao buscou no banco.");
		System.out.println("Endereco 1: "+ enderecos.get(0).getLogradouro());
		
		ss.close();

	}

}