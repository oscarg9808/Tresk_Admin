package ec.ups.edu.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.Categorias;
import ec.edu.ups.modelo.Factura_Cabecera;
import ec.edu.ups.modelo.Factura_Detalle;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.Usuario;
import ec.ups.edu.ON.CategoriasOn;
import ec.ups.edu.ON.FacturaON;
import ec.ups.edu.ON.UsuarioON;
import ec.ups.edu.vista.CategoriaBean;
import ec.ups.edu.vista.ProductoBean;



@Path("/Tresk")
public class ServiciosTodos {

	@Inject
	private CategoriaBean cc;
	@Inject
	private ProductoBean pc;
	@Inject
	private CategoriasOn ca;
	@Inject
	private UsuarioON usuarioON;
	@Inject
	private FacturaON facturaON;
	
	
	@GET
	@Path("/categorias")
	@Produces("application/json")
	public List<Categorias> getCategorias(){
		return ca.getCategoriasL(); 
	}
	
	@GET
	@Path("/productosLis")
	@Produces("application/json")
	public List<Productos> getProductos(){
		return pc.listarP();
	}
	
	@GET
	@Path("/carritoLista")
	@Produces("application/json")
	public List<Carrito> geCarritos(){
		return facturaON.getListaCarrito();
	}
	
	
	@POST
	@Path("/productos")
	@Consumes("application/json")
	@Produces("application/json")
	public Productos  producto(Productos p) {
		Productos pr = new Productos();
		try {
			pr = ca.getProducto(p.getId());
			return pr;
		}catch (Exception e) {
			System.out.println("error en curso");
		}
		return pr;
	}
	
	@POST
	@Path("/usuario")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean insertUsuario(Usuario usuario) {
	 usuarioON.CrearUsuario(usuario);
		
		return true;
	}
	

	@POST
	@Path("/facturaCabecera")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean insertFactura(Factura_Cabecera factura_Cabecera) {

		facturaON.insertFacturaCabecera(factura_Cabecera);
		
		return true;
	}
	
	
	@POST
	@Path("/insertarfacturaCabecera")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean insertFacturaCabecera(@QueryParam("cedula") String cedula ,Factura_Cabecera factura_Cabecera) {

		facturaON.insertarFacturaCabecera(cedula,factura_Cabecera);
		
		return true;
	}
	
	
	@POST
	@Path("/insertarfacturaDetalle")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean insertFacturaDetalle(@QueryParam("cedula") String cedula,@QueryParam("id") int id ,Factura_Detalle factura_Detalle) {

		facturaON.insertarFacturaDetalle(cedula,id,factura_Detalle);
		
		return true;
	}
	
	
	@GET
	@Path("/realizarPago")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean realizarPago(@QueryParam("cedula") String cedula) {

		facturaON.realizarPago(cedula);
		
		return true;
	}
	
	@GET
	@Path("/facturaCabeceraList")
	@Produces("application/json")
	public List<Factura_Cabecera> factura_Cabeceras(){
		return facturaON.getfactura_Cabeceras();
	}
	
	@GET
	@Path("/facturaDetalleList")
	@Produces("application/json")
	public List<Factura_Detalle> getfactura_Detalle(){
		return facturaON.getfactura_Detalle();
	}
	
	@GET
	@Path("/usuarioListar")
	@Produces("application/json")
	public List<Usuario> listUsuario(){
		return usuarioON.getUsuarioList();
	}
	
	@GET
	@Path("/usuarioLogin")
	@Produces("application/json")
	public Usuario getUsuarioLogin(@QueryParam("contrasena") String contrasena,@QueryParam("correo") String correo){
		return usuarioON.getUsuarioLogin(contrasena, correo);
	}
	
	@GET
	@Path("/getidFactura")
	@Produces("application/json")
	public int getIdfacturaCa(){
		return facturaON.numeroFacruraId();
	}
	
	@GET
	@Path("/getidFacturaDetalle")
	@Produces("application/json")
	public int getIdfacturaDetalle(){
		facturaON.resporteDeProductos();
		return facturaON.numeroFacruradetId();
	}
	
	@GET
	@Path("/elimimarDetalleBase")
	@Produces("application/json")
	public boolean elimarDetalle(@QueryParam("facdetalle") int facdetalle){
		facturaON.borrarFacturaDetalle(facdetalle);
		return true;
	}
	
	
	
	@GET
	@Path("/usuarioFacturas")
	@Produces("application/json")
	public int  getUsuarFactura(@QueryParam("cedula") String contrasena){
		return facturaON.getidFacturaCabecera(contrasena);
	}
		
		
}
