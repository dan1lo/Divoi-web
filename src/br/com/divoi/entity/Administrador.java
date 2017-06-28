package br.com.divoi.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Administrador extends Pessoa{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public Administrador(String nome, String email, String senha, String tipo) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = "Administrador";
	}
	
	
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
}
