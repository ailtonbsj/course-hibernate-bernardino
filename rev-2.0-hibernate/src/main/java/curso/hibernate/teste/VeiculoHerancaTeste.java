package curso.hibernate.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import curso.hibernate.heranca.VeiculoDuasRodas;
import curso.hibernate.heranca.VeiculoQuatroRodas;

public class VeiculoHerancaTeste {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		session.beginTransaction();
		
		VeiculoQuatroRodas fusca = new VeiculoQuatroRodas();
		fusca.setMarca("VW");
		fusca.setModelo("Fusca");
		fusca.setAno(1966);
		fusca.setQuantidadePortas(2);
		
		VeiculoDuasRodas moto = new VeiculoDuasRodas();
		moto.setMarca("Honda");
		moto.setModelo("Pop 110i");
		moto.setAno(2018);
		moto.setCilindradas(125);
		
		session.save(moto);
		session.save(fusca);
		session.getTransaction().commit();
		session.close();
	}
}
