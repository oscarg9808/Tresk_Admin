package ups.edu.ec.tresk.categoriaServicio;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.edu.ups.tesk.modelo.Categorias;
import ec.edu.ups.tesk.modelo.Productos;
import ec.edu.ups.tesk.modelo.Usuario;
import ec.edu.ups.tresk.Bean.CategoriaBean;
import ec.edu.ups.tresk.Bean.UsuarioBean;
import ec.edu.ups.tresk.Bean.ProductoBean;


@Path("/Usu")
public class UsuarioSrv {

	/*@Inject 
	private UsuarioBean conon;
	@Inject
	private ProductoBean pcon;
	@Inject
	private CategoriaBean ccon;

	@GET
	@Path("/lista")
	@Produces ("application/json")
	public List<Usuario> listarusuario(){
		return conon.listarusuario();
	}
	
	@GET
	@Path("/listaprod")
	@Produces ("application/json")
	public List<Productos> listarproducto(){
		return pcon.listarP();
	}
	
	@GET
	@Path("/listacat")
	@Produces ("application/json")
	public List<Categorias> listarcat(){
		return ccon.listarCategorias();
	}

	@POST
	@Path("/login")
	@Consumes("application/json")
	@Produces("application/json")
	public Respuesta login(Usuario usuario) {
		Respuesta re = new Respuesta();
		try {
			Usuario u = conon.login(usuario.getCedula());
			if(usuario.getContrasena().equals(u.getContrasena())) {
				re.setId(1);
				re.setMens("Credenciales Correctas");
			}else {
				re.setId(99);
				re.setMens("Error, Contrasea incorrecta");
			}
			
		}catch (Exception e) {
			re.setId(0);
			re.setMens("Error");
		}
		return re;
	}
	
	@POST
	@Path("/insertar")
	@Produces("application/json")
	@Consumes("application/json")
	public Respuesta insertar(Usuario usuario) {
		Respuesta r= new Respuesta();
		try {
			String nue = conon.Guardarusu(usuario);
			r.setId(1);
			r.setMens("Guardado");
					
		}catch (Exception e) {
			r.setId(99);
			r.setMens("Error, al guardar");
			System.out.println(e);
		}
		return r;
	}*/
		
}
