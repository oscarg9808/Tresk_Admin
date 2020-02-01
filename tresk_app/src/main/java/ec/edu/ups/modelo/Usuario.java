package ec.edu.ups.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "usuario")
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@Column (length = 10)
	private String cedula;
	@Column (length = 25)
	private String nombre;
	@Column ( length = 25)
	private String apellido;
	@Column (length = 10)
	private String telefono;
	@Column (length = 45)
	private String correo;
	@Column (length = 45)
	private String contrasena;
	private Boolean admin;
	
	
	/*@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="usuarioTarjeta", referencedColumnName = "cedula")
	private List<Tarjeta> trajeta;*/
	
	
	/*@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="usuarioDireccion", referencedColumnName = "cedula")
	private List<Direccion> direccion;*/
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="usuarioFactura", referencedColumnName = "cedula")
	private List<Factura_Cabecera> factura_Cabeceras;
	
	/*@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="usuarioCarrito", referencedColumnName = "cedula")
	private List<Carrito> listCarrito;*/

	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuarioId", referencedColumnName = "cedula")
	private Carrito carrito;*/
	

	/*public List<Factura_Cabecera> getFactura_Cabeceras() {
		return factura_Cabeceras;
	}*/

	/*public void setFactura_Cabeceras(List<Factura_Cabecera> factura_Cabeceras) {
		this.factura_Cabeceras = factura_Cabeceras;
	}*/

/*	public List<Carrito> getListCarrito() {
		return listCarrito;
	}

	public void setListCarrito(List<Carrito> listCarrito) {
		this.listCarrito = listCarrito;
	}*/

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

/*	public List<Tarjeta> getTrajeta() {
		return trajeta;
	}

	public void setTrajeta(List<Tarjeta> trajeta) {
		this.trajeta = trajeta;
	}

	public List<Direccion> getDireccion() {
		return direccion;
	}

	public void setDireccion(List<Direccion> direccion) {
		this.direccion = direccion;
	}
*/
	public List<Factura_Cabecera> getFactura_Cabeceras() {
		return factura_Cabeceras;
	}

	public void setFactura_Cabeceras(List<Factura_Cabecera> factura_Cabeceras) {
		this.factura_Cabeceras = factura_Cabeceras;
	}

	
	
	/*@OneToMany
	@JoinColumn(name="producto", referencedColumnName = "id")
	private List<Voto> voto;*/
	
	
}
