package br.com.divoi.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Lingua {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String nome;
	private String povo;

	private String localizacao;
	private String descricao;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "lingua", cascade = CascadeType.ALL)
	private List<Dialeto> dialetos;
	
	public Lingua(){
		
	}
	public Lingua(String nome, String povo, String localizacao, String descricao, Usuario usuario, List<Dialeto> dialetos) {
		this.nome = nome;
		this.povo = povo;
		this.localizacao = localizacao;
		this.descricao = descricao;
		this.dialetos = dialetos;
	}
	
	public Lingua(String nome, String povo, String localizacao, String descricao) {
		this.nome = nome;
		this.povo = povo;
		this.localizacao = localizacao;
		this.descricao = descricao;
	}
	
	public Lingua(long id, String nome, String povo, String localizacao, String descricao) {
		this.id = id;
		this.nome = nome;
		this.povo = povo;
		this.localizacao = localizacao;
		this.descricao = descricao;
	}
	
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPovo() {
		return povo;
	}
	public void setPovo(String povo) {
		this.povo = povo;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@OneToMany
	@JoinColumn(name = "publicador_id")
	public List<Dialeto> getDialetos() {
		return dialetos;
	}
	public void setDialetos(List<Dialeto> dialetos) {
		this.dialetos = dialetos;
	}
	
	@Override
	public String toString() {
		return "Lingua [id=" + id + ", nome=" + nome + ", povo=" + povo + ", localizacao=" + localizacao
				+ ", descricao=" + descricao + ", dialetos=" + dialetos + "]";
	}

}
