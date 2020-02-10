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
	
	/**
	 * Metodo que inserta un usuario en la base de datos 
	 * @param c es el el parametro que se insertara en la base de datos 
	 */
	public void insertar(Usuario c) {
		entitymanager.persist(c);
	}  
	/**
	 * Metodo que actualkiza la Entidad Usuario en la Base de datos
	 * @param c es le paramtreo que contine los datos a se actualizados en la base de datos 
	 */
	
	public void actualizar(Usuario c) {
		entitymanager.merge(c);
		
	}
	/**
	 *  Metedo que elimima un usuario en la base de datos 
	 * @param cedu contiene el atributo primario con el que se hace la busqueda de eliminacion
	 * @return valor nulo
	 */
	
	public String borrar(String cedu) {
		entitymanager.remove(leer(cedu));
		return null;
	}
	
	/**
	 * Metodo que busca una entidad usuario dentro del  base de datos
	 * @param cedu paramtro que contine la clave primaria con la que se realiza la busqueda 
	 * @return retorna el objeto buscado dentro de la base de datos Usuario
	 */
	public Usuario leer(String cedu) {
		System.out.println("Buscar usuario DAO............");
		System.out.println(" "+entitymanager.find(Usuario.class, cedu));
		return entitymanager.find(Usuario.class, cedu);
		
	}
	
	/**
	 * Metodo que lista los usuarios dentro de la base de datos
	 * @return una lista con los usuarios que se encunetran en la base de datos
	 */
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
