package br.com.divoi.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa {
	
	protected String nome;
	protected String email;
	protected String senha;
	protected String tipo;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
