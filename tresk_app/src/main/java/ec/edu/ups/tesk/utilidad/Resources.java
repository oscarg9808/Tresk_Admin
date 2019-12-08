package ec.edu.ups.tesk.utilidad;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
	
	@Produces
	@PersistenceContext
	private EntityManager em;
	
}
