package curso.hibernate.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "usu_usuario")
public class Usuario {
	
	private Integer id;
	private String nome;
	private Date nascimento;
	private Integer idade;
	private EstadoCivil estadoCivil;
	private Endereco endereco;
	private Endereco enderecoComercial;
	private List<Endereco> endExtras = new ArrayList<Endereco>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Temporal(TemporalType.DATE)
	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	@Transient
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil")
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="logradouro", column=@Column(name="rua"))
	})
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="logradouro", column=@Column(name="rua_com")),
		@AttributeOverride(name="cidade", column=@Column(name="cit_com")),
		@AttributeOverride(name="numero", column=@Column(name="num_com"))
	})
	public Endereco getEnderecoComercial() {
		return enderecoComercial;
	}

	public void setEnderecoComercial(Endereco enderecoComercial) {
		this.enderecoComercial = enderecoComercial;
	}

	@ElementCollection
	@JoinTable(name = "usu_endextras",
				joinColumns = @JoinColumn(name = "id_usuario"))
	public List<Endereco> getEndExtras() {
		return endExtras;
	}

	public void setEndExtras(List<Endereco> endExtras) {
		this.endExtras = endExtras;
	}
}
