package ec.ups.edu.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.Categorias;
import ec.edu.ups.modelo.Estadisticas;
import ec.edu.ups.modelo.Factura_Cabecera;
import ec.edu.ups.modelo.Factura_Detalle;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.negociointerface.TreskRemote;
import ec.edu.ups.negociointerface.Tresklocal;
import ec.ups.edu.datos.CarritoDAO;
import ec.ups.edu.datos.CategoriaDAO;
import ec.ups.edu.datos.FacturaDAO;
import ec.ups.edu.datos.FacturaDetalleDAO;
import ec.ups.edu.datos.ProductoDAO;
import ec.ups.edu.datos.UsuarioDAO;

@Stateless
public class TreskON implements Tresklocal, TreskRemote {

	private Usuario usu;
	/**
	 * inyeccion para las clases DAO de dactura, carrito, usuario, producto y
	 * categoria.
	 */

	@Inject
	private FacturaDAO facturaDAO;

	@Inject
	private CarritoDAO carritoDAO;

	@Inject
	private UsuarioDAO usuarioDAO;

	@Inject
	private ProductoDAO productoDAO;

	@Inject
	private CategoriaDAO categoriaDAO;
	
	@Inject
	private FacturaDetalleDAO facturaDetalleDAO;

	/*
	 * metodos para el usuario
	 */

	public void CrearUsuario(Usuario usuario) {
		usuarioDAO.insertar(usuario);
	}

	public List<Usuario> getUsuarioList() {
		try {
			return usuarioDAO.getlistar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Usuario> totalusuarios() {
		try {
			return usuarioDAO.getlistar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Usuario getUsuarioLogin(String contrasena, String correo) {
		return usuarioDAO.login(contrasena, correo);

	}
	
	public List<Usuario> UsuarioList() {
		try {
			return usuarioDAO.getlistar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void BuscarUsuario(String cedula) {
		this.usu = usuarioDAO.leer(cedula);
	}
	
	public String eliminar(String cedula) {
		usuarioDAO.borrar(cedula);
		return null;
	}
	
	public String update() {
		usuarioDAO.actualizar(usu);
		return null;
	}

	/*
	 * metodos para la factura
	 */

	public void insertFacturaCabecera(Factura_Cabecera factura_Cabecera) {
		facturaDAO.insertarFactura(factura_Cabecera);

	}

	public List<Factura_Cabecera> getfactura_Cabeceras() {
		return facturaDAO.getListFacturaCabecer();
	}

	public List<Factura_Detalle> getfactura_Detalle() {
		return facturaDAO.getListFacturaDetalle();
	}

	public List<Carrito> getListaCarrito() {
		return carritoDAO.getListaCarrito();
	}

	public boolean insertarFacturaCabecera(String cedula, Factura_Cabecera factura_Cabecera) {
		Usuario usuario = usuarioDAO.leer(cedula);
		usuario.getFactura_Cabeceras().add(factura_Cabecera);
		usuarioDAO.actualizar(usuario);
		return true;
	}

	public boolean insertarFacturaDetalle(String cedula, int id_factura, Factura_Detalle detalle) {
		Usuario usuario = usuarioDAO.leer(cedula);
		List<Factura_Cabecera> lis = usuario.getFactura_Cabeceras();
		/*
		 * Factura_Cabecera factura_Cabecera =
		 * facturaDAO.leerFactuarCabecera(id_factura); factura_Cabecera
		 * .setSubtotal(factura_Cabecera.getSubtotal() + detalle.getP_total());
		 * factura_Cabecera.setTotal(factura_Cabecera.getSubtotal() * 0.12);
		 * 
		 * factura_Cabecera.getFdetalle().add(detalle);
		 * usuario.getFactura_Cabeceras().add(factura_Cabecera);
		 * usuarioDAO.actualizar(usuario);
		 */

		for (int i = 0; i < lis.size(); i++) {
			Factura_Cabecera fac = lis.get(i);
			if (fac.isEstado() == false) {
				fac.setSubtotal(fac.getSubtotal() + detalle.getP_total());
				fac.setTotal(fac.getSubtotal() * 0.12 + (fac.getSubtotal()));
				fac.getFdetalle().add(detalle);
				usuario.getFactura_Cabeceras().add(fac);
				usuarioDAO.actualizar(usuario);
				return true;
			}
		}
		return false;
	}

	public boolean realizarPago(String cedula) {
		Usuario usuario = usuarioDAO.leer(cedula);
		List<Factura_Cabecera> lis = usuario.getFactura_Cabeceras();
		Factura_Cabecera factura_Cabecera;
		for (int i = 0; i < lis.size(); i++) {
			factura_Cabecera = lis.get(i);
			if (factura_Cabecera.isEstado() == false) {
				factura_Cabecera.setEstado(true);
				usuarioDAO.actualizar(usuario);
				return true;
			}
		}
		return false;
	}

	public int numeroFacruraId() {
		return facturaDAO.idFacturaCabecera() + 1;
	}

	public int getidFacturaCabecera(String cedula) {
		return facturaDAO.getUsuarioFacturas(cedula);
	}

	public int numeroFacruradetId() {
		return facturaDAO.idFacturaDetalle() + 1;
	}

	public boolean borrarFacturaDetalle(int facdetalle) {
		/*
		 * Factura_Detalle detalle = facturaDAO.leerFacturaDetalle(facdetalle);
		 * facturaDAO.borrarFacturaDetalle(detalle);
		 */
		facturaDAO.borrarFacturaDetalleBase(facdetalle);
		return true;
	}
	
	/*
	 * metodos para categoria
	 */
	public List<Categorias> getCategoriasL() {
		return categoriaDAO.listar();
	}
	
	public void guardarcat(Categorias cate) {
		categoriaDAO.insertar(cate);;
	}
	
	public void delete(int cate) {
		categoriaDAO.borrar(cate);
	}
	
	/*
	 * metodos para producto
	 */
	public List<Productos> getProductos() {
		return productoDAO.listar();
	}
	
	public Productos getProducto(int id) {
		return productoDAO.leer(id);
	}
	
	/*public static void main(String arg []) {
		CategoriasON c = new CategoriasON();
		System.out.println(c.getCategoriasL());
	}*/
	
	public List<Estadisticas> resporteDeProductos() {
		List<Productos> productosLisT = productoDAO.listar();
		List<Factura_Detalle> detallesList = facturaDAO.getListFacturaDetalle();
		List<Estadisticas> estadisticasLista = new ArrayList<Estadisticas>();
		Estadisticas estadisticas;
		int canitdad = 0;
		for (Productos productos : productosLisT) {
			estadisticas = new Estadisticas();
			canitdad = 0;
			for (Factura_Detalle factura_Detalle2 : detallesList) {
				if (productos.getId() == factura_Detalle2.getId()) {
					canitdad = canitdad + 1;
				}
			}
			estadisticas.setCantidad(canitdad);
			estadisticas.setIdProducto(productos.getId());
			estadisticas.setNombre(productos.getNombre());
			estadisticasLista.add(estadisticas);
		}
		for (Estadisticas estadisticas2 : estadisticasLista) {
			System.out.println(estadisticas2.toString());
		}
		return estadisticasLista;
	}

	public void nuevoprod(Productos prod) {
		productoDAO.insertar(prod);
	}

	public void eliminar(int prod) {
		productoDAO.borrar(prod);
	}

	public void actualizar(Productos prod) {
		productoDAO.actualizar(prod);
	}
	
	public List<Productos> listarp(){
		return productoDAO.listar();
	}
	
	public List<Factura_Detalle> factlist(){
		return facturaDetalleDAO.getlistar();
	}
}
