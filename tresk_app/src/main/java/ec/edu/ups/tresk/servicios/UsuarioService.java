package ec.edu.ups.tresk.servicios;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.tesk.ON.UsuarioON;
import ec.edu.ups.tesk.modelo.Usuario;
import ec.edu.ups.tresk.Bean.UsuarioBean;

@Path("/Usuario")
public class UsuarioService {

	@Inject 
	private UsuarioBean conon;
	@Inject
	private UsuarioON usuarioON;
	
	
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
	@Path("/usuario")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean  insertUsuario(Usuario usuario) {
		System.out.println(usuario.toString()+"  **************");
		try {
			
			usuarioON.CrearUsuario(usuario);
			
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	
	}
}
