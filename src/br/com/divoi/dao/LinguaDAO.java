package br.com.divoi.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.divoi.entity.Lingua;

public class LinguaDAO extends GenericDAO<Long,Lingua>{

	public LinguaDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	public boolean existeLingua(String nome) {
		EntityManager entityManager = super.getEntityManager();

		Query query = entityManager.createQuery("SELECT u FROM Lingua u WHERE u.nome = :nome");
		query.setParameter("nome", nome);
		return (query.getResultList().size() > 0);
	}

}
