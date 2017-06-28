package br.com.divoi.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil implements IJPAUtil {

	private EntityManager entityManager;
	private EntityManagerFactory factory;

	public JPAUtil(String persistenceUnitName){
		factory = Persistence.createEntityManagerFactory(persistenceUnitName);
		this.entityManager = factory.createEntityManager();
	}

	@Override
	public void beginTransaction(){
		entityManager.getTransaction().begin();
	}

	@Override
	public void commit(){
		entityManager.getTransaction().commit();
	}

	/**
	 * THIS METHOD NEEDS TO BE ALWAYS CALLED
	 */
	@Override
	public void close(){
		entityManager.clear();
		entityManager.close();
		factory.close();
	}

	@Override
	public void rollBack(){
		entityManager.getTransaction().rollback();
	}

	@Override
	public EntityManager getEntityManager(){
		return entityManager;
	}
	
	public void clear(){
		entityManager.clear();
	}

}
