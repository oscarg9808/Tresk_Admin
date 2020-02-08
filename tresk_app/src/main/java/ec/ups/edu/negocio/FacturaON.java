package ec.ups.edu.negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.Estadisticas;
import ec.edu.ups.modelo.Factura_Cabecera;
import ec.edu.ups.modelo.Factura_Detalle;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.Usuario;
import ec.ups.edu.datos.CarritoDAO;
import ec.ups.edu.datos.FacturaDAO;
import ec.ups.edu.datos.ProductoDAO;
import ec.ups.edu.datos.UsuarioDAO;


@Stateless
public class FacturaON {

	@Inject
	private FacturaDAO facturaDAO;
	@Inject
	private CarritoDAO carritoDAO;
	@Inject
	private UsuarioDAO usuarioDAO;
	@Inject
	private ProductoDAO productoDAO;

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
			
			if(fac.isEstado()==false) {
				
				fac.setSubtotal(fac.getSubtotal()+ detalle.getP_total());
				fac.setTotal(fac.getSubtotal()*0.12+(fac.getSubtotal()));
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
	
	
	
	public List<Estadisticas> resporteDeProductos() {
		List<Productos> productosLisT = productoDAO.listar();
		List<Factura_Detalle> detallesList = facturaDAO.getListFacturaDetalle();
		List<Estadisticas> estadisticasLista = new ArrayList<Estadisticas>();
		Estadisticas estadisticas;
		int canitdad=0;

		for (Productos productos : productosLisT) {
			estadisticas = new Estadisticas();
			canitdad =0;
			for (Factura_Detalle factura_Detalle2 : detallesList) {
				
				if(productos.getId()==factura_Detalle2.getId()) {
					canitdad =canitdad+1;
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

	
}
