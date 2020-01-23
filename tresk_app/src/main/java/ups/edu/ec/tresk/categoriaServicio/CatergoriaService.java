package ups.edu.ec.tresk.categoriaServicio;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.tesk.ON.CategoriasOn;
import ec.edu.ups.tesk.ON.UsuarioON;
import ec.edu.ups.tesk.modelo.Categorias;
import ec.edu.ups.tesk.modelo.Productos;
import ec.edu.ups.tesk.modelo.Usuario;
import ec.edu.ups.tresk.Bean.CategoriaBean;
import ec.edu.ups.tresk.Bean.UsuarioBean;
import ec.edu.ups.tresk.Bean.ProductoBean;

@Path("/tienda")
public class CatergoriaService {

	/*@Inject
	private CategoriaBean cc;
	@Inject
	private ProductoBean pc;
	@Inject
	private CategoriasOn ca;
	@Inject
	private UsuarioON usuarioON;
	
	@GET
	@Path("/categorias")
	@Produces("application/json")
	public List<Categorias> getCategorias(){
		return cc.listarCategorias(); 
	}
	
	@GET
	@Path("/ProductosLisss")
	@Produces("application/json")
	public List<Productos> getProductos(){
		return pc.listarP();
	}
	
	
	@POST
	@Path("/productos")
	@Consumes("application/json")
	@Produces("application/json")
	public Productos  producto(Productos p) {
		Productos pr = new Productos();
		try {
			pr = ca.getProducto(p.getId());
			return pr;
		}catch (Exception e) {
			System.out.println("error en curso");
		}
		return pr;
	}
	
	@GET
	@Path("/usuario")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean  insertUsuario(@QueryParam("nombre") String nombre
			,@QueryParam("apellido") String apellido
			,@QueryParam("cedula") String cedula
			,@QueryParam("telefono") String telefono
			,@QueryParam("correo") String correo
			,@QueryParam("contrasena") String contrasena
	
			) {
		System.out.println(nombre+"  ****************");
		try {
			Usuario u= new Usuario();
			u.setNombre(nombre);
			u.setAdmin(false);
			u.setApellido(apellido);
			u.setCedula(cedula);
			u.setContrasena(contrasena);
			u.setCorreo(correo);
			u.setTelefono(telefono);
			usuarioON.CrearUsuario(u);
			System.out.println(u.toString());
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return false;
		}
	
	}*/
		
}
