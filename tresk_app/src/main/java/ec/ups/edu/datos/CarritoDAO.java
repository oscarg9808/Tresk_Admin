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
	
	
	/**
	 * 
	 * @param carrito metdo que se encarga de insertar un detalle de compras en la base
	 * @return retorna una variable boolena que se encarga de verificar que el proceso se haya integrado
	 */
	public boolean insertarCarrito(Carrito carrito) {
		
		entityManager.persist(carrito);
		return true;
	}
	/***
	 *  Metodo solicitado pro la applicacion movil
	 * @return una lista del modelo de carritos para ser porcesado en la app
	 */
	public List<Carrito> getListaCarrito(){
		return entityManager.createQuery("select u from carrito u", Carrito.class).getResultList();
	}
	
	

}
