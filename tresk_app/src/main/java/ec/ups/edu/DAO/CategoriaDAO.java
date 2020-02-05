package ec.ups.edu.DAO;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ec.edu.ups.modelo.Categorias;

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
	
	
	public Categorias leernom(String nombre) {
		TypedQuery<Categorias> cate =  em.createQuery("SELECT c FROM categorias c WHERE c.nombre = :nombre", Categorias.class);
		System.out.println(cate.setParameter("nombre", nombre).getSingleResult());
		return cate.setParameter("nombre", nombre).getSingleResult();
		
	}
	
	public List<Categorias> listar() { 
		return em.createQuery("SELECT U FROM categorias U", Categorias.class).getResultList();
	}

	
}
