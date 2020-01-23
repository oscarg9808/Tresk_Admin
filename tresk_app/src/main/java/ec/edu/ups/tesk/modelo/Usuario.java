package ec.edu.ups.tesk.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
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
	
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="usuario", referencedColumnName = "cedula")
	private List<Tarjeta> trajeta;
	
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="usuario", referencedColumnName = "cedula")
	private List<Direccion> direccion;
	
	
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
	
	public List<Tarjeta> getTrajeta() {
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
	
	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", usuario=" + ", correo=" + correo + ", contrasena=" + contrasena + ", admin=" + admin
				+ ", trajeta=" + trajeta + ", direccion=" + direccion + "]";
	}
}
