package br.com.divoi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Arquivo {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String audio;
	private Long idDialeto;
	private String imagem;
	
	public Arquivo(){}
	
	
	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}


	public Long getIdDialeto() {
		return idDialeto;
	}

	public void setIdDialeto(Long idDialeto) {
		this.idDialeto = idDialeto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	@Override
	public String toString() {
		return "Arquivo [id=" + id + ", idDialeto=" + idDialeto + ", imagem=" + imagem + "]";
	}

}
