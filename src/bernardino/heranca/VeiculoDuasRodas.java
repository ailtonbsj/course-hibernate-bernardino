package bernardino.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "duas_rodas")
public class VeiculoDuasRodas extends VeiculoHeranca {
	private Integer cilindradas;

	public Integer getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(Integer cilindradas) {
		this.cilindradas = cilindradas;
	}
}
