package ec.ups.edu.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Usuario;


@Stateless
public class UsuarioDAO {

	@Inject
	private EntityManager entitymanager;
	
	private Usuario us;
	
	
	public void insertar(Usuario c) {
		entitymanager.persist(c);
	}  
	
	public void actualizar(Usuario c) {
		entitymanager.merge(c);
		
	}
	
	public String borrar(String cedu) {
		entitymanager.remove(leer(cedu));
		return null;
	}
	
	
	public Usuario leer(String cedu) {
		return entitymanager.find(Usuario.class, cedu);
	}
	
	public List<Usuario> getlistar() throws Exception{ 
		return entitymanager.createQuery("Select u from usuario u", Usuario.class).getResultList();
	}
	
	public List<Usuario> listar() throws Exception {
		String jpql = "Select u from usuario u";
		Query query = entitymanager.createQuery(jpql,Usuario.class);
		List<Usuario> clientes = query.getResultList();
		return clientes;
	}
		
	public Usuario login(String usuariolog, String contra) {
		 Query query1 = entitymanager.createQuery("Select u from usuario u where usuariolog='"+usuariolog+
				 "' and contrasena='"+contra+"'");
	      try{
	    	  Usuario result = (Usuario) query1.getSingleResult(); 
	    	  return result;
	      }catch(Exception e) {
	    	  
	      }
	      
	      
	      return null;
	}
	

}
