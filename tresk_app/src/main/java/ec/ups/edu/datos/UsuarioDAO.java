package ec.ups.edu.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Usuario;


@Stateless
public class UsuarioDAO {

	@Inject
	private EntityManager entitymanager;
	
	private Usuario us;
	
	
	public void insertar(Usuario c) {
		entitymanager.persist(c);
	}  
	
	public void actualizar(Usuario c) {
		entitymanager.merge(c);
		
	}
	
	public String borrar(String cedu) {
		entitymanager.remove(leer(cedu));
		return null;
	}
	
	
	public Usuario leer(String cedu) {
		System.out.println("Buscar usuario DAO............");
		System.out.println(" "+entitymanager.find(Usuario.class, cedu));
		return entitymanager.find(Usuario.class, cedu);
		
	}
	
	
	public List<Usuario> getlistar(){ 
		return entitymanager.createQuery("Select u from usuario u", Usuario.class).getResultList();
	}
	
	public List<Usuario> listar() {
		String jpql = "Select u from usuario u";
		Query query = entitymanager.createQuery(jpql,Usuario.class);
		List<Usuario> clientes = query.getResultList();
		return clientes;
	}
		
	/*public Usuario loginadmin(String usuariolog, String contra) {
		 Query query1 = entitymanager.createQuery("Select u from usuario u where usuariolog='"+usuariolog+
				 "' and contrasena='"+contra+"'");
	      try{
	    	  Usuario result = (Usuario) query1.getSingleResult(); 
	    	  return result;
	      }catch(Exception e) {
	    	  
	      }
	      
	      
	      return null;
	}*/
	
	
	public Usuario getUsuario(String contrasena, String correo) {
		System.out.println(contrasena+"  "+correo+"hola");
		
		try {
			Query query1 = entitymanager.createQuery("Select u from usuario u where contrasena='"+contrasena.trim()+
		
				 "' and correo='"+correo.trim()+"'");
			
	      Usuario result = (Usuario) query1.getSingleResult();
	      System.out.println("Max Employee Salary :" + result);
	      return result;
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}  
	      
	     
	}
	
	public String idUsuarioMasCompas() {
		   
		   String maxUsuarios="select  tabla:cedula from \r\n" + 
		   		"(select count(*) cuenta, u:cedula cedula from usuario u, facturacabecera f WHere u:cedula = f:usuariofactura GROUP by u:cedula) tabla\r\n" + 
		   		"where tabla:cuenta=(select max(tabla:cuenta) cedula from (\r\n" + 
		   		"	\r\n" + 
		   		"(select count(*) cuenta, u:cedula cedula from usuario u, facturacabecera f WHere u:cedula = f:usuariofactura GROUP by u:cedula)) tabla)";
		   System.out.println("Id Usuario comprado "+String.valueOf(entitymanager.createQuery(maxUsuarios,String.class).getSingleResult()));
		   
		   return String.valueOf(entitymanager.createQuery(maxUsuarios,String.class).getSingleResult());
	   }
	   

}
