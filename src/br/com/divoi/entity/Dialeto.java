package br.com.divoi.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;


@Entity
public class Dialeto {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String palavra;
	private String traducao;
	private String aplicacaoFrase;
	private String traducaoFrase;
	@ManyToOne
	private Lingua lingua;
	private String imagemUrl;
	private String audioUrl;

	
	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public String getAudioUrl() {
		return audioUrl;
	}

	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Dialeto() {
	}

	public Dialeto(String palavra, String traducao, String aplicacaoFrase, String traducaoFrase, Lingua lingua) {
		this.palavra = palavra;
		this.traducao = traducao;
		this.aplicacaoFrase = aplicacaoFrase;
		this.traducaoFrase = traducaoFrase;
		this.lingua = lingua;
	}
	
	public Dialeto(long id, String palavra, String traducao, String aplicacaoFrase, String traducaoFrase, Lingua lingua) {
		this.id = id;
		this.palavra = palavra;
		this.traducao = traducao;
		this.aplicacaoFrase = aplicacaoFrase;
		this.traducaoFrase = traducaoFrase;
		this.lingua = lingua;
	}

	public long getId() {
		return id;
	}
	
	public String getPalavra() {
		return palavra;
	}
	

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public String getTraducao() {
		return traducao;
	}

	public void setTraducao(String traducao) {
		this.traducao = traducao;
	}

	public String getAplicacaoFrase() {
		return aplicacaoFrase;
	}

	public void setAplicacaoFrase(String aplicacaoFrase) {
		this.aplicacaoFrase = aplicacaoFrase;
	}
	
	public String getTraducaoFrase() {
		return traducaoFrase;
	}

	public void setTraducaoFrase(String traducaoFrase) {
		this.traducaoFrase = traducaoFrase;
	}

	public Lingua getLingua() {
		return lingua;
	}

	public void setLingua(Lingua lingua) {
		this.lingua = lingua;
	}

	@Override
	public String toString() {
		return "Dialeto [id=" + id + ", palavra=" + palavra + ", traducao=" + traducao + ", aplicacaoFrase="
				+ aplicacaoFrase + ", traducaoFrase=" + traducaoFrase + ", lingua=" + lingua + ", imagemUrl="
				+ imagemUrl + ", audioUrl=" + audioUrl + "]";
	}



	
	
}

