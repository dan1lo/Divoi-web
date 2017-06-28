package br.com.divoi.dao;



import javax.persistence.EntityManager;
import br.com.divoi.entity.Dialeto;



public class DialetoDAO extends GenericDAO<Long,Dialeto>{

	public DialetoDAO(EntityManager entityManager) {
		super(entityManager);
		
	}

}
