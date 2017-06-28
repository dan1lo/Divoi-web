package br.com.divoi.controller;


import java.util.ArrayList;
import java.util.List;

import br.com.divoi.dao.UsuarioDAO;
import br.com.divoi.entity.Usuario;
import br.com.divoi.util.Constants;
import br.com.divoi.util.JPAUtil;
import br.com.divoi.util.JSONUtil;

public class UsuarioController {
	private UsuarioDAO usuarioDAO;
	private JPAUtil simpleEntityManager;
	
	//M�todo cadastrar
	public boolean create(Usuario usuario){
		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.usuarioDAO = new UsuarioDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();
			usuarioDAO.save(usuario);
			simpleEntityManager.commit();
			if(usuarioDAO.existeEmail(usuario.getEmail())){
				System.out.println("alo");
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
	
	//m�todo atualizar
	public boolean update(Usuario usuario) {

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.usuarioDAO = new UsuarioDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();

			Usuario usuarioAux = this.usuarioDAO.getById(usuario.getId());

			if (usuarioAux != null) {

				usuarioAux.setNome(usuario.getNome());
				usuarioAux.setEmail(usuario.getEmail());
				usuarioAux.setSenha(usuario.getSenha());
				usuarioAux.setTipo(usuario.getTipo());

				usuarioDAO.update(usuarioAux);
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
	
	public Usuario getById(long id){

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.usuarioDAO = new UsuarioDAO(this.simpleEntityManager.getEntityManager());
		
		try {
			this.simpleEntityManager.beginTransaction();

			Usuario usuarioAux = this.usuarioDAO.getById(id);

			if (usuarioAux != null) {
				return usuarioAux;
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
		this.usuarioDAO = new UsuarioDAO(this.simpleEntityManager.getEntityManager());

		try {
			this.simpleEntityManager.beginTransaction();

			Usuario usuarioAux = this.usuarioDAO.getById(id);

			if (usuarioAux != null) {
				usuarioDAO.delete(usuarioAux);
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

	
	public List<Usuario> getList() {

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.usuarioDAO = new UsuarioDAO(this.simpleEntityManager.getEntityManager());

		List<Usuario> listaUsuarios = usuarioDAO.findAll();

		try {
			this.simpleEntityManager.beginTransaction();

			if (listaUsuarios == null) {
				System.out.println("Lista nula");
			}

		} catch (Exception e) {

			this.simpleEntityManager.rollBack();

			e.printStackTrace();

		} finally {

			this.simpleEntityManager.close();
		}
		return listaUsuarios;
	}
	
	public Usuario autenticacao(String email, String senha){
		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.usuarioDAO = new UsuarioDAO(this.simpleEntityManager.getEntityManager());
		Usuario usuario = null;
		if(usuarioDAO.existeEmail(email)){ 
			usuario = usuarioDAO.getByEmail(email);
			if(usuario.getSenha().equals(senha)){
				return usuario;
			}
		}else{
			System.out.println("Email n�o cadastrado");
		}
		return null;
	}
	
	public String getListGson() {

		this.simpleEntityManager = new JPAUtil(Constants.PERSISTENCE_UNIT_NAME);
		this.usuarioDAO = new UsuarioDAO(this.simpleEntityManager.getEntityManager());

		List<Usuario> listaUsuario = usuarioDAO.findAll();
		List<Usuario> listaAux = new ArrayList<Usuario>();

		try {
			this.simpleEntityManager.beginTransaction();
			if (listaUsuario != null) {
				for(Usuario usuario : listaUsuario){
					
						listaAux.add(usuario);
					
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


