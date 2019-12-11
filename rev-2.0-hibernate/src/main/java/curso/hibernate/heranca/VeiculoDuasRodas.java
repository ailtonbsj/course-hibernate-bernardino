package curso.hibernate.heranca;

import javax.persistence.Entity;

@Entity
public class VeiculoDuasRodas extends Veiculo {
	
	private Integer cilindradas;

	public Integer getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(Integer cilindradas) {
		this.cilindradas = cilindradas;
	}
	
}
