package ec.ups.edu.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.modelo.Factura_Detalle;



@Stateless
public class FacturaDetalleDAO {
	
	
	@Inject
	private EntityManager entityManager;
	
	
	public List<Factura_Detalle> getlistar() { 
		return entityManager.createQuery("Select u from facturadetalle u", Factura_Detalle.class).getResultList();
	}
	
	

}
