package br.com.csm.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.csm.entidade.Usuario;

public class UsuarioDAO {
	
	private EntityManager entityManager;
	
	public UsuarioDAO(EntityManager entityManager){
		this.entityManager= entityManager;
	}
	
	public void cadastrar(Usuario usuario){
		entityManager.persist(usuario);
	}
	
	public void alterar(Usuario usuario){
		entityManager.merge(usuario);
	}
	
	public void excluir(Usuario usuario){
		entityManager.remove(entityManager.merge(usuario));
	}
	
	public Usuario consultar(Long id){
		return entityManager.getReference(Usuario.class, id);
	}

	public List<Usuario> listar(){
		
		String sql = "Select usu from Usuario usu order by nome";
		Query query = entityManager.createQuery(sql);
		
		return query.getResultList();
	}
	
}
