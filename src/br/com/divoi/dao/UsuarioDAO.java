package br.com.divoi.dao;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.divoi.entity.Usuario;

public class UsuarioDAO extends GenericDAO<Long,Usuario>{

	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);
		
	}
	
	public boolean existeEmail(String email) {
		EntityManager entityManager = super.getEntityManager();

		Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		query.setParameter("email", email);
		return (query.getResultList().size() > 0);
	}
	
	public Usuario getByEmail(String email) {
		EntityManager entityManager = super.getEntityManager();
		Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
		query.setParameter("email", email);
		return (Usuario) query.getSingleResult();
	}
}
