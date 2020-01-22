package ec.edu.ups.tesk.ON;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.tesk.datos.UsuarioDAO;
import ec.edu.ups.tesk.modelo.Usuario;


@Stateless
public class UsuarioON {
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	
	
	public void CrearUsuario(Usuario usuario) {
		usuarioDAO.insertar(usuario);
	}


}
