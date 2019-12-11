package curso.hibernate.heranca;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("quatro")
public class VeiculoQuatroRodas extends Veiculo {
	
	private Integer quantidadePortas;

	public Integer getQuantidadePortas() {
		return quantidadePortas;
	}

	public void setQuantidadePortas(Integer quantidadePortas) {
		this.quantidadePortas = quantidadePortas;
	}
	
}
