package ec.edu.ups.tesk.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject; 
import javax.persistence.EntityManager;

import ec.edu.ups.tesk.modelo.Categorias; 
/*
 * Modelo de la clase Categoria
 */
@Stateless
public class CategoriaDAO {
	
	@Inject
	private EntityManager em;
	
	
	public void insertar(Categorias c) {
		em.persist(c);
	}  
	
	public void actualizar(Categorias c) {
		em.merge(c);
		
	}
	
	 
	public void borrar(int id) {
		em.remove(leer(id));
	}
	
	
	public Categorias leer(int id) {
		return em.find(Categorias.class, id);
		
	}

	public List<Categorias> listar() { 
		return em.createQuery("Select u from categorias u", Categorias.class).getResultList();
	}

	
}
