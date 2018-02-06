package bernardino.modelo;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "User")
public class Usuario {

	private Integer id;
	private String nome;
	private Date dataNascimento;
	private Integer idade;
	private EstadoCivil estadoCivil;
	private Endereco residencial;
	private Endereco comercial;
	
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
	@Column(name = "nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Transient
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	@Enumerated(EnumType.STRING)
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Endereco getResidencial() {
		return residencial;
	}
	public void setResidencial(Endereco residencial) {
		this.residencial = residencial;
	}
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="logradouro",column=@Column(name="rua_comercial")),
		@AttributeOverride(name="numero",column=@Column(name="num_comercial")),
		@AttributeOverride(name="cidade",column=@Column(name="city_comercial"))
	})
	public Endereco getComercial() {
		return comercial;
	}
	public void setComercial(Endereco comercial) {
		this.comercial = comercial;
	}
	
}