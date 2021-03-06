package br.com.csm.resources;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.csm.DAO.JPAUtil;
import br.com.csm.DAO.UsuarioDAO;
import br.com.csm.entidade.Usuario;

@Path("/usuarios")
public class UsuarioResources {
	
	
	@GET
	@Path("/listarUsuarios")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listUsuarios(){
		List<Usuario> list = new ArrayList<Usuario>();
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);	
		list=dao.listar();
		
		return list;
		
	}
	
	@POST
	@Path("/consultarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario buscarUsuario(long id){
		Usuario usuario = new Usuario();
		EntityManager em = JPAUtil.getEntityManager();
		UsuarioDAO dao = new UsuarioDAO(em);
		usuario = dao.consultar(id);
		
		return usuario;
	}
	

}
