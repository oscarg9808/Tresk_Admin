package ec.edu.ups.tesk.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Clientes {
	
	
	@Id 
	private int id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String correo;
	private String usuario;
	private String contrasena;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", correo=" + correo + ", usuario=" + usuario + ", contrasena=" + contrasena + "]";
	}

}
