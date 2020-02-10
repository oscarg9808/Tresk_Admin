package ec.ups.edu.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

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
import ec.edu.ups.negociointerface.TreskRemote;
import ec.edu.ups.negociointerface.Tresklocal;
import ec.ups.edu.datos.CarritoDAO;
import ec.ups.edu.datos.CategoriaDAO;
import ec.ups.edu.datos.FacturaDAO;
import ec.ups.edu.datos.FacturaDetalleDAO;
import ec.ups.edu.datos.ProductoDAO;
import ec.ups.edu.datos.UsuarioDAO;

@Stateless
public class TreskON implements Tresklocal {

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

	
	public Usuario getUsuarioLogin(String contrasena, String correo) {
		return usuarioDAO.getUsuario(contrasena, correo);

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

	/*
	 * public Usuario getAdminlogin(String usuariolog, String contra) { return
	 * usuarioDAO.loginadmin(usuariolog, contra);
	 * 
	 * }
	 */
	
	public List<Usuario> UsuarioList() {
		try {
			return usuarioDAO.getlistar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public String BuscarUsuario(String cedula) {
		System.out.println("Busca usuario ON..........");
		usu = usuarioDAO.leer(cedula);
		System.out.println("Usuario Buscar...... " + usu);
		return null;

	}

	
	public String eliminar(String cedula) {
		usuarioDAO.borrar(cedula);
		return null;
	}

	
	public String update(Usuario usua) {
		usuarioDAO.actualizar(usua);
		return null;
	}

	
	public boolean registarTarjetaUsuario(String cedula, Tarjeta tarjeta) {

		Usuario usuario = usuarioDAO.leer(cedula);
		usuario.getTarjeta().add(tarjeta);
		usuarioDAO.actualizar(usuario);

		return true;
	}

	
	public boolean registrarDireccionUsuario(String cedula, Direccion direccion) {

		Usuario usuario = usuarioDAO.leer(cedula);
		usuario.getDireccion().add(direccion);
		usuarioDAO.actualizar(usuario);
		return true;
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
		Productos productos = productoDAO.leer(detalle.getProductos().getId());
		System.out.println(productos.toString());

		productos.setStock(productos.getStock() - detalle.getCantidad());

		List<Factura_Cabecera> lis = usuario.getFactura_Cabeceras();
		for (int i = 0; i < lis.size(); i++) {

			Factura_Cabecera fac = lis.get(i);

			if (fac.isEstado() == false) {

				fac.setSubtotal(fac.getSubtotal() + detalle.getP_total());
				fac.setTotal(fac.getSubtotal() * 0.12 + (fac.getSubtotal()));
				fac.getFdetalle().add(detalle);
				usuario.getFactura_Cabeceras().add(fac);
				usuarioDAO.actualizar(usuario);
				productoDAO.actualizar(productos);

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

	public boolean borrarFacturaDetalle(int facdetalle, int idFactura) {
		Factura_Cabecera factura_Cabecera = facturaDAO.leerFactuarCabecera(idFactura);
		Factura_Detalle factura_Detalle = facturaDetalleDAO.factura_Detalle(facdetalle);
		factura_Cabecera.setSubtotal(factura_Cabecera.getSubtotal() - (factura_Detalle.getP_total()));
		factura_Cabecera.setTotal(
				factura_Cabecera.getTotal() - ((factura_Detalle.getP_total() * 0.12) + factura_Detalle.getP_total()));
		Productos productos = productoDAO.leer(factura_Detalle.getProductos().getId());
		productos.setStock(productos.getStock() + factura_Detalle.getCantidad());

		facturaDAO.actualizarFacturaCabecera(factura_Cabecera);
		productoDAO.actualizar(productos);

		facturaDAO.borrarFacturaDetalleBase(facdetalle);
		return true;
	}

	/*
	 * metodos para categoria
	 */
	
	public Categorias buscate(String nombre) {

		return categoriaDAO.leernomcat(nombre);

	}

	
	public List<Categorias> getCategoriasL() {
		return categoriaDAO.listar();
	}

	
	public void guardarcat(Categorias cate) {
		categoriaDAO.insertar(cate);
		;
	}

	
	public void delete(int cate) {
		categoriaDAO.borrar(cate);
	}

	
	public Productos busprod(String nom) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++" + nom);
		return productoDAO.leernom(nom);
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

	/*
	 * public static void main(String arg []) { CategoriasON c = new CategoriasON();
	 * System.out.println(c.getCategoriasL()); }
	 */
	
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

	
	public void actualizarcate(Categorias categ) {
		categoriaDAO.actualizar(categ);
	}

	
	public List<Productos> listarp() {
		return productoDAO.listar();
	}

	
	public List<Factura_Detalle> factlist() {
		return facturaDetalleDAO.getlistar();
	}

	
	public boolean getProductoVotado(String cedula, int idP) {

		Productos prod = productoDAO.leer(idP);
		Usuario usuario = usuarioDAO.leer(cedula);

		List<Voto> lisvotP = prod.getVoto();
		List<Voto> usuat = usuario.getVoto();

		for (Voto voto : usuat) {
			for (Voto voto2 : lisvotP) {
				if (voto.equals(voto2)) {
					System.out.println("Texto True");
					return true;
				}

			}
		}
		return false;

	}

	
	public boolean insertarVoto(String cedula, int idP, Voto voto) {
		Productos prod = productoDAO.leer(idP);
		Usuario usuario = usuarioDAO.leer(cedula);

		prod.getVoto().add(voto);
		usuario.getVoto().add(voto);
		productoDAO.actualizar(prod);
		usuarioDAO.actualizar(usuario);
		try {
			// getusuarioMasComprado();
			// getProductoasMasBotados();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/*
	 * public Usuario getusuarioMasComprado() {
	 * 
	 * 
	 * List<Usuario> getListaUsuarios = usuarioDAO.getlistar(); Usuario usuario =
	 * new Usuario(); int facturas=0; int factutasAnteriores=0; for (Usuario
	 * usuarioLis : getListaUsuarios) {
	 * 
	 * facturas = usuarioLis.getFactura_Cabeceras().size();
	 * if(facturas>factutasAnteriores) { usuario = usuarioLis; } factutasAnteriores
	 * = usuarioLis.getFactura_Cabeceras().size();
	 * 
	 * } System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	 * System.out.println(usuario.toString());
	 * System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	 * 
	 * 
	 * 
	 * 
	 * return usuario; }
	 * 
	 * public Productos getProductoasMasBotados() {
	 * 
	 * 
	 * List<Productos> getListaproductos = productoDAO.listar(); Productos
	 * productosN = new Productos(); int productosV=0; int productosAnteriores=0;
	 * for (Productos productos : getListaproductos) {
	 * 
	 * productosV = productos.getVoto().size(); if(productosV>productosAnteriores) {
	 * productosN = productos; } productosAnteriores = productos.getVoto().size();
	 * 
	 * } System.out.println("BBBBBBBBBBBBBBBBBBBBBBB");
	 * System.out.println(productosN.toString());
	 * System.out.println("BBBBBBBBBBBBBBBBBBBBBB");
	 * 
	 * 
	 * 
	 * 
	 * return productosN; }
	 */

}
