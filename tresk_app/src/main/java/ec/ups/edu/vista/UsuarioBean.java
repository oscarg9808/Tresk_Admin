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
import ec.ups.edu.datos.UsuarioDAO;
import ec.ups.edu.negocio.UsuarioON;

@ManagedBean
@SessionScoped
public class UsuarioBean {


	private Usuario usu;
	public String cedula;
	private Usuario usuarioLogin;
	@Inject
	private UsuarioON usuarioON;
	
	@Inject 
	private UsuarioDAO usdao;

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

	
	public String guardar() {
		System.out.println(usu);
		usdao.insertar(usu);
		return null;
	}

	
	public String Buscar() {
		System.out.println(usdao.leer(cedula));
		this.usu=usdao.leer(this.cedula);	
		return null;
	}
		
	
	public String eliminar(String cedula) {
		usdao.borrar(cedula);	
		return null;
	}
	
	public String update() {
		usdao.actualizar(usu);;
		return null;
	}

	public List<Usuario> listarusuario(){
		try {
			return usdao.getlistar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public List<Usuario> totalusuarios(){
		try {
			return usdao.listar();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	
	public String login(String correo, String contrasenia) {
		 System.out.println("correo: "+correo+"  contra: "+contrasenia);
		this.usuarioLogin = usuarioON.getUsuarioLogin(correo,contrasenia);
		System.out.println("usuariologin encontrado "+usuarioLogin);
		if(this.usuarioLogin != null) {
			if(usuarioLogin.getAdmin().equalsIgnoreCase("Administrador")) {
				return "PaginaPrincipal.xhtml";
				}else {
					this.usuarioLogin.setAdmin("");
					this.usuarioLogin.setApellido("");
					this.usuarioLogin.setCedula("");
					this.usuarioLogin.setContrasena("");
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

	public Usuario getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(Usuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public UsuarioON getUsuarioON() {
		return usuarioON;
	}

	public void setUsuarioON(UsuarioON usuarioON) {
		this.usuarioON = usuarioON;
	}
	
	public String logout() {
		
		this.usuarioLogin.setAdmin("");
		this.usuarioLogin.setApellido("");
		this.usuarioLogin.setCedula("");
		this.usuarioLogin.setContrasena("");
		this.usuarioLogin.setCorreo("");
		this.usuarioLogin.setDireccion(new ArrayList<Direccion>());
		this.usuarioLogin.setFnacimi(new Date());
		this.usuarioLogin.setListCarrito(new ArrayList<Carrito>());
		this.usuarioLogin.setNombre("");
		this.usuarioLogin.setTelefono("");
		this.usuarioLogin.setTrajeta(new ArrayList<Tarjeta>());
		
		return "Login.xhtml";
	}
}
