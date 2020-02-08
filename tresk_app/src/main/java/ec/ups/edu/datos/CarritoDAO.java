package ec.ups.edu.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.modelo.Carrito;



@Stateless
public class CarritoDAO {
	
	@Inject
	private EntityManager entityManager;
	
	
	
	public boolean insertarCarrito(Carrito carrito) {
		
		entityManager.persist(carrito);
		return true;
	}
	
	public List<Carrito> getListaCarrito(){
		return entityManager.createQuery("select u from carrito u", Carrito.class).getResultList();
	}
	
	

}
