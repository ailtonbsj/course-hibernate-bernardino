package bernardino.teste;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bernardino.modelo.Endereco;
import bernardino.modelo.EstadoCivil;
import bernardino.modelo.Usuario;

public class UsuarioTeste {

	public static void main(String[] args) {
		
		Usuario user = new Usuario();
		user.setNome("Clark");
		user.setDataNascimento(new Date());
		user.setIdade(30);
		user.setEstadoCivil(EstadoCivil.SOLTEIRO);
		
		Endereco adrr = new Endereco();
		adrr.setLogradouro("Rua A");
		adrr.setNumero(11);
		adrr.setCidade("Sao Paulo");
		user.setResidencial(adrr);
		
		Endereco adrrCom = new Endereco();
		adrrCom.setLogradouro("Rua B");
		adrrCom.setNumero(12);
		adrrCom.setCidade("Rio de Janeiro");
		user.setComercial(adrrCom);
		
		SessionFactory fac = new Configuration().configure().buildSessionFactory();
		Session ss = fac.openSession();
		ss.beginTransaction();
		
		ss.save(user);
		ss.getTransaction().commit();
		
		Usuario userFromDB = ss.get(Usuario.class, 1);
		System.out.println("Nome: " + userFromDB.getNome());
		
		ss.close();

	}

}