package ec.ups.edu.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.modelo.Usuario;
import ec.ups.edu.datos.UsuarioDAO;


@Stateless
public class UsuarioON {
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	
	
	
	public void CrearUsuario(Usuario usuario) {
		usuarioDAO.insertar(usuario);
	}
	
	public List<Usuario> getUsuarioList(){
		try {
			return usuarioDAO.getlistar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public List<Usuario> totalusuarios(){
		try {
			return usuarioDAO.getlistar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Usuario getUsuarioLogin(String contrasena, String correo) {
		return usuarioDAO.getUsuario(contrasena, correo);
		
	}
	
	

}
