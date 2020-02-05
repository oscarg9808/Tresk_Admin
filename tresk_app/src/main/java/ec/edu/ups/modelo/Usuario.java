package ec.edu.ups.modelo;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.crypto.Data;

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
	@Temporal(TemporalType.DATE)
	private Date fnacimi;
	@Column (length = 45)
	private String correo;
	@Column (length = 45)
	private String contrasena;
	private String admin;
	
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="usuarioTarjeta", referencedColumnName = "cedula")
	private List<Tarjeta> tarjeta;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="usuariodir", referencedColumnName = "cedula")
	private List<Direccion> direccion;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="usuarioFactura", referencedColumnName = "cedula")
	private List<Factura_Cabecera> factura_Cabeceras;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="usuarioCarrito", referencedColumnName = "cedula")
	private List<Carrito> listCarrito;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="usuariovoto", referencedColumnName = "cedula")
	private List<Voto> voto;	

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

	public Date getFnacimi() {
		return fnacimi;
	}

	public void setFnacimi(Date fnacimi) {
		this.fnacimi = fnacimi;
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

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public List<Tarjeta> getTrajeta() {
		return tarjeta;
	}

	public void setTrajeta(List<Tarjeta> trajeta) {
		this.tarjeta = trajeta;
	}

	public List<Direccion> getDireccion() {
		return direccion;
	}

	public void setDireccion(List<Direccion> direccion) {
		this.direccion = direccion;
	}

	public List<Factura_Cabecera> getFactura_Cabeceras() {
		return factura_Cabeceras;
	}

	public void setFactura_Cabeceras(List<Factura_Cabecera> factura_Cabeceras) {
		this.factura_Cabeceras = factura_Cabeceras;
	}

	public List<Carrito> getListCarrito() {
		return listCarrito;
	}

	public void setListCarrito(List<Carrito> listCarrito) {
		this.listCarrito = listCarrito;
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", fnacimi=" + fnacimi + ", correo=" + correo + ", contrasena=" + contrasena + ", admin=" + admin
				+ "]";
	}
}
