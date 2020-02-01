package ec.ups.edu.ON;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.modelo.Usuario;
import ec.ups.edu.DAO.UsuarioDAO;




@Stateless
public class UsuarioON {
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	
	
	
	public void CrearUsuario(Usuario usuario) {
		usuarioDAO.insertar(usuario);
	}
	
	public List<Usuario> getUsuarioList(){
		return usuarioDAO.getlistar();
	}
	
	
	public Usuario getUsuarioLogin(String contrasena, String correo) {
		return usuarioDAO.getUsuario(contrasena, correo);
		
	}
	
	

}
