package ec.edu.ups.tesk.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

import ec.edu.ups.tesk.modelo.Clientes;

@Stateless
public class ClienteDAO {
	
	@Inject
	private EntityManager em;
	
	
	public void insertar(Clientes c) {
		em.persist(c);
	}  
	
	public void actualizar(Clientes c) {
		em.merge(c);
		
	}
	
	 
	public void borrar(String id) {
		em.remove(leer(id));
	}
	
	
	public Clientes leer(String id) {
		em.find(Clientes.class, id);
		return null;
	}

	
}
