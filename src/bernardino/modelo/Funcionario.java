package bernardino.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Funcionario {
	private Integer id;
	private String nome;
	private Double salario;
	private String cpf;
	private Date admissao;
	private List<Projeto> projetos = new ArrayList<>();
	
	public Funcionario() {
	}
	
	public Funcionario(String nome, Double salario, String cpf, Date admissao) {
		super();
		this.nome = nome;
		this.salario = salario;
		this.cpf = cpf;
		this.admissao = admissao;
	}
	
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
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	@ManyToMany
	@JoinTable(name="func_proj",
	joinColumns = @JoinColumn(name = "id_func"),
	inverseJoinColumns = @JoinColumn(name = "id_proj"))
	public List<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Temporal(TemporalType.DATE)
	public Date getAdmissao() {
		return admissao;
	}
	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}
	
}
