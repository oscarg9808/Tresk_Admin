package ec.edu.ups.tesk.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.tesk.modelo.Categorias;
import ec.edu.ups.tesk.modelo.Usuario;

@Stateless
public class UsuarioDAO {

	@Inject
	private EntityManager em;
	
	
	public void insertar(Usuario c) {
		em.persist(c);
	}  
	
	public void actualizar(Usuario c) {
		em.merge(c);
		
	}
	
	public String borrar(String ced) {
		em.remove(leer(ced));
		return null;
	}
	
	
	public Usuario leer(String cedu) {
		return em.find(Usuario.class, cedu);
	}
	
	public List<Usuario> listar() { 
		return em.createQuery("Select u from usuario u", Usuario.class).getResultList();
	}

}
