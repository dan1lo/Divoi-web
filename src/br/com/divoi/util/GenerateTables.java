package br.com.divoi.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe responsável por gerar as tabelas
 * 
 */
public class GenerateTables {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("br.com.divoi");
		factory.close();

		System.out.println("OK");

	}

}
