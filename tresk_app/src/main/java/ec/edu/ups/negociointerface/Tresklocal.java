package ec.edu.ups.negociointerface;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.Categorias;
import ec.edu.ups.modelo.Estadisticas;
import ec.edu.ups.modelo.Factura_Cabecera;
import ec.edu.ups.modelo.Factura_Detalle;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.Usuario;

@Local
public interface Tresklocal {
	

	/**
	 * llamado a metodos para el usuario
	 */
	public void CrearUsuario(Usuario usuario);
	public void BuscarUsuario(String cedula);
	public List<Usuario> getUsuarioList();
	public List<Usuario> totalusuarios();
	public Usuario getUsuarioLogin(String contrasena, String correo);
	public String eliminar(String cedula);
	public String update();

	/**
	 * llamado a metodos para la Factura
	 */
	public void insertFacturaCabecera(Factura_Cabecera factura_Cabecera);
	public List<Factura_Cabecera> getfactura_Cabeceras();
	public List<Factura_Detalle> getfactura_Detalle();
	public List<Carrito> getListaCarrito();
	public boolean insertarFacturaCabecera(String cedula, Factura_Cabecera factura_Cabecera);
	public boolean insertarFacturaDetalle(String cedula, int id_factura, Factura_Detalle detalle);
	public boolean realizarPago(String cedula);
	public int numeroFacruraId();
	public int getidFacturaCabecera(String cedula);
	public int numeroFacruradetId();
	public boolean borrarFacturaDetalle(int facdetalle);
	public List<Estadisticas> resporteDeProductos();
	
	/**
	 * llamado a metodos para categorias
	 */
	public List<Categorias> getCategoriasL();
	public void guardarcat(Categorias cate);
	public void delete(int cate);
	
	/**
	 * llamado a metodos para el producto
	 */
	public List<Productos> getProductos();
	public Productos getProducto(int id);
	public void nuevoprod(Productos prod);
	public void eliminar(int prod);
	public void actualizar(Productos prod);
	public List<Productos> listarp();
	public List<Factura_Detalle> factlist();
	
}
