package br.com.divoi.dao;

import javax.persistence.EntityManager;

import br.com.divoi.entity.MyFile;

public class MyFileDAO extends GenericDAO<Long, MyFile> {

	public MyFileDAO(EntityManager entityManager) {
		super(entityManager);
	}

}