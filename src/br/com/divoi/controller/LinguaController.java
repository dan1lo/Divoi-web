package br.com.divoi.controller;

import java.util.List;
import br.com.divoi.dao.LinguaDAO;
import br.com.divoi.entity.Lingua;
import br.com.divoi.util.Constants;
import br.com.divoi.util.JPAUtil;
import br.com.divoi.util.JSONUtil;

public class LinguaController {

	private LinguaDAO linguaDAO;
	private JPAUtil simpleEntityManager;

	public boolean create(Lingua lingua){
		this.simpleEntityManager = new JPAUtil("br.com.divoi");
		this.linguaDAO = new LinguaDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();
			if(linguaDAO.existeLingua(lingua.getNome())){
				linguaDAO.save(lingua);
				simpleEntityManager.commit();
				return true;
			}else{
				return false;
			}

		} catch (Exception e) {

			this.simpleEntityManager.rollBack();

			e.printStackTrace();

			return false;
		} finally {

			this.simpleEntityManager.close();
		}
	}

	//m�todo atualizar
	public boolean update(Lingua lingua) {

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.linguaDAO = new LinguaDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();

			Lingua linguaAux = this.linguaDAO.getById(lingua.getId());

			if (linguaAux != null) {

				linguaAux.setNome(lingua.getNome());
				linguaAux.setPovo(lingua.getPovo());
				linguaAux.setLocalizacao(lingua.getLocalizacao());
				linguaAux.setDescricao(lingua.getDescricao());

				linguaDAO.update(linguaAux);
				simpleEntityManager.commit();

			} else {
				System.out.println("Objeto nulo");
				return false;
			}
		} catch (Exception e) {

			this.simpleEntityManager.rollBack();

			e.printStackTrace();

			return false;
		} finally {

			this.simpleEntityManager.close();
		}
		return true;
	}

	public Lingua getById(long id){

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.linguaDAO = new LinguaDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();

			Lingua linguaAux = this.linguaDAO.getById(id);

			if (linguaAux != null) {
				return linguaAux;
			} else {
				System.out.println("Objeto nulo");
				return null;
			}
		} catch (Exception e) {

			this.simpleEntityManager.rollBack();

			e.printStackTrace();

			return null;
		} finally {

			this.simpleEntityManager.close();
		}

	}



	public boolean delete(Long id) {

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.linguaDAO = new LinguaDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();

			Lingua linguaAux = this.linguaDAO.getById(id);

			if (linguaAux != null) {
				linguaDAO.delete(linguaAux);
				simpleEntityManager.commit();
			} else {
				System.out.println("Objeto nulo");
				return false;
			}
		} catch (Exception e) {

			this.simpleEntityManager.rollBack();

			e.printStackTrace();

			return false;
		} finally {

			this.simpleEntityManager.close();
		}
		return true;
	}

	public List<Lingua> getList() {

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.linguaDAO = new LinguaDAO(this.simpleEntityManager.getEntityManager());

		List<Lingua> listaLingua = linguaDAO.findAll();

		try {
			this.simpleEntityManager.beginTransaction();

			if (listaLingua == null) {
				System.out.println("Lista nula");
			}

		} catch (Exception e) {

			this.simpleEntityManager.rollBack();

			e.printStackTrace();

		} finally {

			this.simpleEntityManager.close();
		}
		return listaLingua;
	}

	public String getListGson() {

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.linguaDAO = new LinguaDAO(this.simpleEntityManager.getEntityManager());

		List<Lingua> listaLingua = linguaDAO.findAll();

		try {
			this.simpleEntityManager.beginTransaction();

			if (listaLingua != null) {
				for(Lingua lingua : listaLingua){
					lingua.setDialetos(null);
					System.out.println(lingua);

				}


			}else{System.out.println("Lista nula");}

		} catch (Exception e) {

			this.simpleEntityManager.rollBack();

			e.printStackTrace();

		} finally {

			this.simpleEntityManager.close();
		}
		return JSONUtil.objectToJSON(listaLingua);
	}


}


