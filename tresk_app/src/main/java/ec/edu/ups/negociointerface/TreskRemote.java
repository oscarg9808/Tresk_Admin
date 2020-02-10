package ec.edu.ups.negociointerface;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.Categorias;
import ec.edu.ups.modelo.Direccion;
import ec.edu.ups.modelo.Estadisticas;
import ec.edu.ups.modelo.Factura_Cabecera;
import ec.edu.ups.modelo.Factura_Detalle;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.Tarjeta;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.modelo.Voto;

@Remote
public interface TreskRemote {
	
	/**
	 * 
	 * @param usuario metodo qye lleva de parametro la variable de un usuario 
	 */
	public void CrearUsuario(Usuario usuario);
	public String BuscarUsuario(String cedula);
	public List<Usuario> getUsuarioList();
	public List<Usuario> totalusuarios();
	public Usuario getUsuarioLogin(String contrasena, String correo);
	public Usuario getAdminlogin(String usuariolog, String contra);
	public String eliminar(String cedula);
	public String update();
	public boolean registarTarjetaUsuario(String cedula, Tarjeta tarjeta);
	public boolean registrarDireccionUsuario(String cedula, Direccion direccion);

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
	public List<Estadisticas> resporteDeProductos();
	public boolean borrarFacturaDetalle(int facdetalle, int idFactura);
	
	/**
	 * 
	 * @return retorna una lisat de catagotria que son llamadas en la interfaz
	 */
	public List<Categorias> getCategoriasL();
	public void guardarcat(Categorias cate);
	public void delete(int cate);
	
	/**
	 * 
	 * @return
	 */
	public List<Productos> getProductos();
	public Productos getProducto(int id);
	public void nuevoprod(Productos prod);
	public void eliminar(int prod);
	public void actualizar(Productos prod);
	public List<Productos> listarp();
	public List<Factura_Detalle> factlist();
	public void busprod(String prod);
	public boolean getProductoVotado (String cedula, int idP) ;
	
	public boolean insertarVoto(String cedula, int idP, Voto voto);

}
