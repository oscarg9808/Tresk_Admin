package ec.edu.ups.tresk.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.tesk.datos.UsuarioDAO;
import ec.edu.ups.tesk.modelo.Categorias;
import ec.edu.ups.tesk.modelo.Usuario;


@ManagedBean
@ViewScoped
public class ControladorUsuario {


	private Usuario usu;
	public String cedula;
	
	@Inject 
	private UsuarioDAO usdao;

	@PostConstruct
	private void init() {
		usu = new Usuario();
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

	/*public String Buscarusu(String cedu) {
		setCedula(usdao.actualizar(cedu));
		System.out.println("salida "+ cedula);
		return null;
	}*/
	
	
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
		return this.usdao.listar();
	}
		
}
