package br.com.divoi.dao;





import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
public class GenericDAO<PK, T> {

	private EntityManager entityManager;

	public GenericDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	/**
	 * Busca uma entidade por ID e retorna o objeto do banco de dados
	 * 
	 * @param pk
	 * @return
	 */
	public T getById(PK pk) {
		return (T) entityManager.find(getTypeClass(), pk);
	}

	/**
	 * Salva uma entidade no banco de dados
	 * 
	 * @param entity
	 */
	public void save(T entity) {
		entityManager.persist(entity);
	}

	/**
	 * Atualiza uma entidade no bando de dados
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		entityManager.merge(entity);
	}

	/**
	 * Exclui uma entidade do banco de dados
	 * 
	 * @param entity
	 */
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	/**
	 * Lista todos os registros de uma entidade no banco de dados
	 * 
	 * @return
	 */
	public List<T> findAll() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName())).getResultList();
	}
	
	/**
	 * Lista todos os registros de uma entidade no banco de dados
	 * 
	 * @return
	 */
	public List<T> findByPage(int page) {
		int pageSize = 10;
		int indexForFirstResult = ( page * pageSize ) - pageSize;
		Query query = entityManager.createQuery(("FROM " + getTypeClass().getName())).setFirstResult(indexForFirstResult).setMaxResults(pageSize);
		return query.getResultList();
	}

	/**
	 * Retorna o nome da classe/entidade
	 * 
	 * @return
	 */
	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
		return clazz;
	}

}