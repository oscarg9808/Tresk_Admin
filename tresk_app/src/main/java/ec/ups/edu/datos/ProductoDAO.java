package ec.ups.edu.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject; 
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ec.edu.ups.modelo.Categorias;
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

	
	public Productos leernom(String nombre) {
		System.out.println("Variabel dao nombre "+nombre);
		Query produ =  em.createQuery("SELECT c FROM productos c WHERE c.nombre ='" +nombre+"'");
		Productos prod = (Productos) produ.getSingleResult();
		
		return prod;
		}
	
	public List<Productos> listar() { 
		return em.createQuery("Select u from productos u order by (u.id) asc", Productos.class).getResultList();
	}

	
}
