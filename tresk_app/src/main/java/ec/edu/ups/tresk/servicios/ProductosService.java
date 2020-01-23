package ec.edu.ups.tresk.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.edu.ups.tesk.datos.ProductoDAO;
import ec.edu.ups.tesk.modelo.Productos;
import ec.edu.ups.tresk.Bean.ProductoBean;



@Path("/productos")
public class ProductosService {
	

	@Inject 
	private ProductoDAO prodao;
	private ProductoBean proc;
	
	/*@GET
	@Path("/listaprod")
	@Produces ("application/json")
	public List<Productos> listarproducto(){
		return prodao.listar();
	}*/
	
	/*@POST
	@Path("/login")
	@Consumes("application/json")
	@Produces("application/json")
	public Respuesta login(Usuario usuario) {
		Respuesta re = new Respuesta();
		try {
			Usuario u = conon.login(usuario.getCedula());
			if(usuario.getContrasena().equals(u.getCedula())) {
				re.setId("1");
				re.setMens("Credenciales Correctas");
			}else {
				re.setId("99");
				re.setMens("Error, Contrasea incorrecta");
			}
			
		}catch (Exception e) {
			re.setId("9");
			re.setMens("Error");
		}
		return re;
	}*/
	
	/*@POST
	@Path("/insertar")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta insertar(Usuario usuario) {
		Respuesta r= new Respuesta();
		try {
			String nue = conon.Guardarusu(usuario);
			r.setId("1");
			r.setMens("Guardado");
					
		}catch (Exception e) {
			r.setId("99");
			r.setMens("Error, al guardar");
			System.out.println(e);
		}
		return r;
	}*/
}
