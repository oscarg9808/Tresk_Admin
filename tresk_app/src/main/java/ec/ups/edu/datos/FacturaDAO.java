package ec.ups.edu.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sound.midi.Soundbank;

import ec.edu.ups.modelo.Factura_Cabecera;
import ec.edu.ups.modelo.Factura_Detalle;

@Stateless
public class FacturaDAO {
	@Inject
	private EntityManager em;
	
	/**
	 * 
	 * @param factura_Cabecera modelo de factura cabecera a ser insertado en la base
	 */
	public void insertarFactura(Factura_Cabecera factura_Cabecera) {
		em.persist(factura_Cabecera);
	}
	/**
	 * 
	 * @param id_factura variable que contiene la clave de factura cabecera
	 * @return una Factura cabecera que es busaca en base a si ID
	 */
	public Factura_Cabecera leerFactuarCabecera(int id_factura) {
		return em.find(Factura_Cabecera.class, id_factura);
	}
	
	/**
	 * 
	 * @return una lista de facturas cabeceras que se necuntrren registradas en la base
	 */
	public List<Factura_Cabecera> getListFacturaCabecer(){
		return em.createQuery("Select u from facturacabecera u", Factura_Cabecera.class).getResultList();
	}
	/**
	 * 
	 * @return retorna una lista de facturas detalles que se encuentren registradas en la base
	 */
	public List<Factura_Detalle> getListFacturaDetalle(){
		return em.createQuery("Select u from facturadetalle u", Factura_Detalle.class).getResultList();
	}
	
	/**
	 *  
	 * @param factura_Cabecera contiene el objeto de la factura cabecera a ser actualizaste
	 */
	public void actualizarFacturaCabecera(Factura_Cabecera factura_Cabecera) {
		em.merge(factura_Cabecera);
	}
	
	/*public Factura_Detalle getFacturaDetalle() {
		
		Query query1 = em.createQuery("Select u from usuario);
	      Usuario result = (Usuario) query1.getSingleResult();
	      System.out.println("Max Employee Salary :" + result);
	      
	      return result;
	}*/
	
	/*
	 * Metodos de la la factura detalle
	 */
	
	public void insertarFacDetalle(Factura_Detalle factura_Detalle) {
		em.persist(factura_Detalle);
		
	}
	
   public int idFacturaCabecera() {
	   try {
		 //  System.out.println(Integer.valueOf(em.createQuery("SELECT MAX(u.id) FROM facturacabecera u",Integer.class).getSingleResult())+"Numero");
		   return em.createQuery("SELECT MAX(u.id) FROM facturacabecera u" , Integer.class).getSingleResult();
	} catch (Exception e) {
		//System.out.println(em.createQuery("SELECT MAX(u.id) FROM facturacabecera u", Integer.class).getSingleResult()+"Numero");
		// TODO: handle exception
		return 1;
	}
	   
   }
  
   public int idFacturaDetalle() {
	   try {
		   
		 //  System.out.println(Integer.valueOf(em.createQuery("SELECT MAX(u.id) FROM facturadetalle u", Integer.class).getSingleResult())+" NUmero");
		   return Integer.valueOf(em.createQuery("SELECT MAX(u.id) FROM facturadetalle u",  Integer.class).getSingleResult());
	} catch (Exception e) {
		// TODO: handle exception
	//System.out.println(Integer.valueOf((String) em.createQuery("SELECT MAX(u.id) FROM facturadetalle u").getSingleResult())+" NUmero");
		
		return 1;
	}
	   
   }
   
   
   public int getUsuarioFacturas(String contrasena) {
		/*
		 "SELECT f.id FROM facturacabecera" + 
				"WHERE f.estado=false and f.usuariofactura="+contrasena+"'"
		 */
		
	   return Integer.valueOf(em.createQuery("SELECT id FROM facturacabecera f" + 
				" WHERE estado=false and usuariofactura='"+contrasena+"'",  Integer.class).getSingleResult());
		
		
	}
   
   
   
   
   public Factura_Detalle leerFacturaDetalle(int idFacDetalle) {
		return em.find(Factura_Detalle.class, idFacDetalle);
	}
   
   public void borrarFacturaDetalle(Factura_Detalle factura_Detalle) {
	   em.remove(factura_Detalle);
   }
 
   public boolean borrarFacturaDetalleBase(int id) {
	   em.createQuery("DELETE FROM facturadetalle c WHERE c.id="+id);
	   System.out.println(em.createQuery("DELETE FROM facturadetalle c WHERE c.id="+id).executeUpdate());
	   return true;
   }
   
	
   
   
}
