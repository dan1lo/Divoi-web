package br.com.divoi.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.divoi.entity.Arquivo;

public class ArquivoDAO extends GenericDAO<Integer,Arquivo>{

	public ArquivoDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	
	public Arquivo getByDialeto(Long idDialeto) {
		EntityManager entityManager = super.getEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM Arquivo u WHERE u.idDialeto = :idDialeto");
		query.setParameter("idDialeto", idDialeto);
		return (Arquivo) query.getSingleResult();
	}
}
