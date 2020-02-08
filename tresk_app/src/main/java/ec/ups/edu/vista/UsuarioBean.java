package ec.ups.edu.vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.Direccion;
import ec.edu.ups.modelo.Tarjeta;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.negociointerface.Tresklocal;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usu;
	public String cedula;
	private Usuario usuarioLogin;

	@Inject
	private Tresklocal tresklocal;


	@PostConstruct
	private void init() {
		usu = new Usuario();
		usuarioLogin = new Usuario();
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String NuevoUsuario() {
		tresklocal.CrearUsuario(usu);
		limpiar();
		return null;
	}

	public String Buscar() {
		tresklocal.BuscarUsuario(cedula);
		return null;
	}

	public String eliminar(String cedu) {
		tresklocal.eliminar(cedu);
		return null;
	}

	public String update() {
		tresklocal.update();
		return null;
	}

	public List<Usuario> listarusuario() {
		return tresklocal.getUsuarioList();
		
	}

	public List<Usuario> totalusuarios() {
		tresklocal.totalusuarios();
		return null;
	}

	public String login(String usuariolog, String contrasenia) {
		System.out.println("usuario: " + usuariolog + "  contra: " + contrasenia);
		this.usuarioLogin = tresklocal.getUsuarioLogin(usuariolog, contrasenia);
		System.out.println("usuariologin encontrado " + usuarioLogin);
		if (this.usuarioLogin != null) {
			if (usuarioLogin.getAdmin().equalsIgnoreCase("administrador")) {
				return "PaginaPrincipal.xhtml";
			} else {
				this.usuarioLogin.setAdmin("");
				this.usuarioLogin.setApellido("");
				this.usuarioLogin.setCedula("");
				this.usuarioLogin.setContrasena("");
				this.usuarioLogin.setUsuariolog("");
				this.usuarioLogin.setCorreo("");
				this.usuarioLogin.setDireccion(new ArrayList<Direccion>());
				this.usuarioLogin.setFnacimi(new Date());
				this.usuarioLogin.setListCarrito(new ArrayList<Carrito>());
				this.usuarioLogin.setNombre("");
				this.usuarioLogin.setTelefono("");
				this.usuarioLogin.setTrajeta(new ArrayList<Tarjeta>());
			}
		}

		return "Login.xhtml";
	}
	
	public String logout() {

		this.usuarioLogin.setAdmin("");
		this.usuarioLogin.setApellido("");
		this.usuarioLogin.setCedula("");
		this.usuarioLogin.setContrasena("");
		this.usuarioLogin.setUsuariolog("");
		this.usuarioLogin.setCorreo("");
		this.usuarioLogin.setDireccion(new ArrayList<Direccion>());
		this.usuarioLogin.setFnacimi(new Date());
		this.usuarioLogin.setListCarrito(new ArrayList<Carrito>());
		this.usuarioLogin.setNombre("");
		this.usuarioLogin.setTelefono("");
		this.usuarioLogin.setTrajeta(new ArrayList<Tarjeta>());

		return "Login.xhtml";
	}

	public Usuario getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(Usuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public Tresklocal getTresklocal() {
		return tresklocal;
	}

	public void setTresklocal(Tresklocal tresklocal) {
		this.tresklocal = tresklocal;
	}
	
	public String limpiar() {

		this.usu.setAdmin("");
		this.usu.setApellido("");
		this.usu.setCedula("");
		this.usu.setContrasena("");
		this.usu.setUsuariolog("");
		this.usu.setCorreo("");
		this.usu.setDireccion(new ArrayList<Direccion>());
		this.usu.setFnacimi(new Date());
		this.usu.setListCarrito(new ArrayList<Carrito>());
		this.usu.setNombre("");
		this.usu.setTelefono("");
		this.usu.setTrajeta(new ArrayList<Tarjeta>());

		return "Usuarios.xhtl";
	}
	
}
