package ec.ups.edu.datos;



import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.text.AsyncBoxView;

import ec.edu.ups.modelo.Categorias;
import ec.edu.ups.modelo.Productos;

@Stateless
public class CategoriaDAO{
	
	@Inject
	private EntityManager em;
	
	/**
	 * 
	 * @param c metodo JPA que inserta la categoria en la base
	 */
	public void insertar(Categorias c) {
		em.persist(c);
	}  
	/**
	 * 
	 * @param c metodo JPA que actualiza la categoria en la base
	 */
	public void actualizar(Categorias c) {
		em.merge(c);
		
	}
	
	 /**
	  * 
	  * @param id metodo JPA que elimina  la categoria en la base
	  */
	public void borrar(int id) {
		em.remove(leer(id));
	}
	
	/**
	 * 
	 * @param id variable que contiene la clave primaria de el modelo categoria
	 * @return retorna un objeto tipo categoria si encuntra en la base
	 */
	public Categorias leer(int id) {
		return em.find(Categorias.class, id);
		
	}
	/**
	 * 
	 * @param nombre nombre de la categoria a ser buscada en la base
	 * @return retorna un acategoria especifica que se ha registardo en la base
	 */
	
	public Categorias leernomcat(String nombre) {
		System.out.println("asdkanadsada snombre cate"+nombre);
		Query cate = em.createQuery("SELECT c FROM categorias c WHERE c.nombre= '"+nombre+"'");
		Categorias cat = (Categorias) cate.getSingleResult();
		return cat;
	}
	/**
	 * 
	 * @return retorna una lista de modelos tipos categoria que se encunetren registrados en la base
	 */
	public List<Categorias> listar() { 
		return em.createQuery("SELECT U FROM categorias U", Categorias.class).getResultList();
	}

	
}
