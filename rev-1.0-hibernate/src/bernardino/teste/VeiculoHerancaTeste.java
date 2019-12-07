package bernardino.teste;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import bernardino.heranca.VeiculoDuasRodas;
import bernardino.heranca.VeiculoQuatroRodas;

public class VeiculoHerancaTeste {

	public static void main(String[] args) {
		
		SessionFactory fac = new Configuration().configure().buildSessionFactory();
		Session session = fac.openSession();
		session.beginTransaction();
		
		VeiculoQuatroRodas fusca = new VeiculoQuatroRodas();
		fusca.setMarca("VW");
		fusca.setModelo("Fusca");
		fusca.setAno(1966);
		fusca.setQuantidadePortas(2);
		
		VeiculoDuasRodas moto = new VeiculoDuasRodas();
		moto.setMarca("Honda");
		moto.setModelo("CG");
		moto.setAno(2015);
		moto.setCilindradas(125);
		
		session.save(fusca);
		session.save(moto);
		
		session.getTransaction().commit();
		
		VeiculoDuasRodas veiculo = session.get(VeiculoDuasRodas.class, 2);
		System.out.println(veiculo.getMarca());
		System.out.println(veiculo.getCilindradas());
		
		
		session.close();
	}
}
