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
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.Tarjeta;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.negociointerface.Tresklocal;
import ec.ups.edu.datos.UsuarioDAO;
import ec.ups.edu.negocio.TreskON;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	/**
	 * 
	 */
	private Usuario usu;
	private Usuario mvot;
	private Productos pvot;
	public String cedula;
	private Usuario usuarioLogin;

	@Inject
	private Tresklocal tresklocal;
	@Inject
	private UsuarioDAO usuarioDAO;

	/**
	 * 
	 */
	@PostConstruct
	private void init() {
		usu = new Usuario();
		mascompusu();
		masvotado();
		usuarioLogin = new Usuario();
	}

	/**
	 * 
	 * @return
	 */
	public String NuevoUsuario() {
		tresklocal.CrearUsuario(usu);
		limpiar();
		return null;
	}

	/**
	 * 
	 * @param cedu
	 * @return
	 */
	public Usuario Buscar(String cedu) {
		for (Usuario usua : listarusuario()) {
			if (usua.getCedula().compareToIgnoreCase(cedu) == 0) {
				System.out.println(usua);
				this.usu = usua;
				return usua;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param cedu
	 * @return
	 */
	public String eliminar(String cedu) {
		tresklocal.eliminar(cedu);
		return null;
	}

	/**
	 * 
	 * @param usua
	 * @return
	 */
	public String update(Usuario usua) {
		tresklocal.update(usua);
		System.out.println("**********************++++++++" + tresklocal.update(usua));
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public List<Usuario> listarusuario() {
		return tresklocal.getUsuarioList();

	}

	/**
	 * 
	 * @return
	 */
	public List<Usuario> totalusuarios() {
		tresklocal.totalusuarios();
		return null;
	}

	/**
	 * 
	 * @return
	 */

	public String mascompusu() {
		/*
		 * mvot=tresklocal.getusuarioMasComprado();
		 * System.out.println("*************************"+mvot.getNombre());
		 */
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public String masvotado() {
		/*
		 * pvot=tresklocal.getProductoasMasBotados();
		 * System.out.println("asdkjasldjalskdjas********************"+pvot.getNombre())
		 * ;
		 */
		return null;
	}

	/**
	 * 
	 * @param usuariolog
	 * @param contrasenia
	 * @return
	 */
	public String login(String usuariolog, String contrasenia) {
		System.out.println("usuario: " + usuariolog + "  contra: " + contrasenia);
		// this.usuarioLogin = tresklocal.getUsuarioLogin(contrasenia, usuariolog);
		// System.out.println("usuariologin encontrado " +
		// usuarioDAO.getUsuario(contrasenia, usuariolog).toString());
		usuarioLogin = usuarioDAO.getUsuario(contrasenia, usuariolog);
		if (usuarioDAO.getUsuario(contrasenia, usuariolog) != null) {
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
				// this.usuarioLogin.setTarjeta(new ArrayList<>());
			}
		}

		return "Login.xhtml";
	}

	/**
	 * 
	 * @return
	 */
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
		// this.usuarioLogin.setTrajeta(new ArrayList<Tarjeta>());

		return "Login.xhtml";
	}

	/**
	 * 
	 * @return
	 */
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
		// this.usu.setTrajeta(new ArrayList<Tarjeta>());

		return "Usuarios.xhtl";
	}

	/**
	 * 
	 * @return
	 */
	public String recargar() {
		mascompusu();
		masvotado();
		return "PaginaPrincipal.xhtml";
	}

	/**
	 * 
	 * @return
	 */

	public Usuario getUsu() {
		return usu;
	}

	/**
	 * 
	 * @param usu
	 */
	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	/**
	 * 
	 * @return
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * 
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * 
	 * @return
	 */
	public Usuario getMvot() {
		return mvot;
	}

	/**
	 * 
	 * @param mvot
	 */
	public void setMvot(Usuario mvot) {
		this.mvot = mvot;
	}

	public Productos getPvot() {
		return pvot;
	}

	/**
	 * 
	 * @param pvot
	 */
	public void setPvot(Productos pvot) {
		this.pvot = pvot;
	}

	/**
	 * 
	 * @return
	 */
	public Usuario getUsuarioLogin() {
		return usuarioLogin;
	}

	/**
	 * 
	 * @param usuarioLogin
	 */
	public void setUsuarioLogin(Usuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	/**
	 * 
	 * @return
	 */
	public Tresklocal getTresklocal() {
		return tresklocal;
	}

	/**
	 * 
	 * @param tresklocal
	 */
	public void setTresklocal(Tresklocal tresklocal) {
		this.tresklocal = tresklocal;
	}

}
