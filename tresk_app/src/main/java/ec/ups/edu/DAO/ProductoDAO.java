package ec.ups.edu.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject; 
import javax.persistence.EntityManager;

import ec.edu.ups.modelo.Productos;

@Stateless
public class ProductoDAO {
	
	@Inject
	private EntityManager em;
	
	
	public void insertar(Productos c) {
		em.persist(c);
	}  
	
	public void actualizar(Productos c) {
		em.merge(c);
		
	}
	
	 
	public void borrar(int id) {
		em.remove(leer(id));
	}
	
	
	public Productos leer(int id) {
		return em.find(Productos.class, id);
			
	}

	public List<Productos> listar() { 
		return em.createQuery("Select u from productos u order by (u.id) asc", Productos.class).getResultList();
	}

	
}
