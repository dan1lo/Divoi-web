package br.com.divoi.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.divoi.dao.DialetoDAO;
import br.com.divoi.entity.Arquivo;
import br.com.divoi.entity.Dialeto;
import br.com.divoi.util.Constants;
import br.com.divoi.util.JPAUtil;
import br.com.divoi.util.JSONUtil;

public class DialetoController {
	
	private DialetoDAO dialetoDAO;
	private JPAUtil simpleEntityManager;
	
	public boolean create(Dialeto dialeto) {

		this.simpleEntityManager = new JPAUtil("br.com.divoi");
		this.dialetoDAO = new DialetoDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();
			dialetoDAO.save(dialeto);
			simpleEntityManager.commit();
			
		} catch (Exception e) {

			this.simpleEntityManager.rollBack();

			e.printStackTrace();

			return false;
		} finally {

			this.simpleEntityManager.close();
		}

		return true;
	}
	
	public boolean update(Dialeto dialeto) {

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.dialetoDAO = new DialetoDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();

			Dialeto dialetoAux = this.dialetoDAO.getById(dialeto.getId());

			if (dialetoAux != null) {

				dialetoAux.setPalavra(dialeto.getPalavra());
				dialetoAux.setTraducao(dialeto.getTraducao());
				dialetoAux.setAplicacaoFrase(dialeto.getAplicacaoFrase());
				dialetoAux.setTraducaoFrase(dialeto.getTraducaoFrase());
				dialetoAux.setLingua(dialeto.getLingua());

				dialetoDAO.update(dialetoAux);
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
	
	public Dialeto getById(long id){

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.dialetoDAO = new DialetoDAO(this.simpleEntityManager.getEntityManager());
		
		try {
			this.simpleEntityManager.beginTransaction();

			Dialeto dialetoAux = this.dialetoDAO.getById(id);

			if (dialetoAux != null) {
				return dialetoAux;
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
		this.dialetoDAO = new DialetoDAO(this.simpleEntityManager.getEntityManager());

		try {
			
			this.simpleEntityManager.beginTransaction();

			Dialeto dialetoAux = this.dialetoDAO.getById(id);

			if (dialetoAux != null) {
				dialetoDAO.delete(dialetoAux);
				this.simpleEntityManager.commit();
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
	
	public List<Dialeto> getList(long id) {

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.dialetoDAO = new DialetoDAO(this.simpleEntityManager.getEntityManager());

		List<Dialeto> listaDialeto = dialetoDAO.findAll();
		List<Dialeto> listaAux = new ArrayList<Dialeto>();

		try {
			this.simpleEntityManager.beginTransaction();

			if (listaDialeto != null) {
				for(Dialeto dialeto : listaDialeto){
					if(dialeto.getLingua().getId() == id){
						listaAux.add(dialeto);
					}
				} return listaAux;
			}else{System.out.println("Lista nula");}

		} catch (Exception e) {

			this.simpleEntityManager.rollBack();

			e.printStackTrace();

		} finally {

			this.simpleEntityManager.close();
		}
		return listaAux;
		}
	
	public String getListGson(long id) {

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.dialetoDAO = new DialetoDAO(this.simpleEntityManager.getEntityManager());
		ArquivoController arquivoController = new ArquivoController();

		List<Dialeto> listaDialeto = dialetoDAO.findAll();
		List<Dialeto> listaAux = new ArrayList<Dialeto>();
		

		try {
			this.simpleEntityManager.beginTransaction();

			if (listaDialeto != null) {
				for(Dialeto dialeto : listaDialeto){
					if(dialeto.getLingua().getId() == id){
						dialeto.getLingua().setDialetos(null);
						dialeto.setLingua(null);
						dialeto.setAudioUrl("none");
						dialeto.setImagemUrl("none");
						if(arquivoController.getByIdDialeto(dialeto.getId()) != null){
							Arquivo arquivo = arquivoController.getByIdDialeto(dialeto.getId());
							dialeto.setImagemUrl(arquivo.getImagem());
							dialeto.setAudioUrl(arquivo.getAudio());
						}
						listaAux.add(dialeto);
					}
				}
			}else{System.out.println("Lista nula");}

		} catch (Exception e) {

			this.simpleEntityManager.rollBack();

			e.printStackTrace();

		} finally {

			this.simpleEntityManager.close();
		}
		return JSONUtil.objectToJSON(listaAux);
		}

	

}
