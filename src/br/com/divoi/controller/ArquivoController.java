package br.com.divoi.controller;
import javax.swing.ImageIcon;

import br.com.divoi.dao.ArquivoDAO;
import br.com.divoi.entity.Arquivo;
import br.com.divoi.util.Constants;
import br.com.divoi.util.JPAUtil;

public class ArquivoController {

	private ArquivoDAO arquivoDAO;
	private JPAUtil simpleEntityManager;

	public boolean create(Arquivo arquivo) {

		this.simpleEntityManager = new JPAUtil("br.com.divoi");
		this.arquivoDAO = new ArquivoDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();
			arquivoDAO.save(arquivo);
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

	public ImageIcon recuperaImagemDiretorio(Long idDialeto) {


		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.arquivoDAO = new ArquivoDAO(this.simpleEntityManager.getEntityManager());
		ImageIcon imagem;
		try {
			this.simpleEntityManager.beginTransaction();

			StringBuffer sql = new StringBuffer();
			Arquivo arquivoAux = this.arquivoDAO.getByDialeto(idDialeto);

			if (arquivoAux != null) {
				sql.append(arquivoAux);
				String caminhoImagem = arquivoAux.getImagem();
				imagem = new ImageIcon(caminhoImagem);
				return imagem;

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


	public Arquivo getByIdDialeto(long idDialeto){

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.arquivoDAO = new ArquivoDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();

			Arquivo arquivoAux = this.arquivoDAO.getByDialeto(idDialeto);

			if (arquivoAux != null) {
				return arquivoAux;
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
	public boolean deleteByIdDialeto(long idDialeto){

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.arquivoDAO = new ArquivoDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();

			Arquivo arquivoAux = this.arquivoDAO.getByDialeto(idDialeto);

			if (arquivoAux != null) {
				arquivoDAO.delete(arquivoAux);
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

	public boolean update(Arquivo arquivo) {

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.arquivoDAO = new ArquivoDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();

			Arquivo dialetoAux = this.arquivoDAO.getByDialeto(arquivo.getIdDialeto());

			if (dialetoAux != null) {

				dialetoAux.setImagem(arquivo.getImagem());
				dialetoAux.setAudio(arquivo.getAudio());

				arquivoDAO.update(dialetoAux);
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
}
