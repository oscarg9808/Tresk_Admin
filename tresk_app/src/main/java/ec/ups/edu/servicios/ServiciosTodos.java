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
import ec.edu.ups.modelo.Direccion;
import ec.edu.ups.modelo.Factura_Cabecera;
import ec.edu.ups.modelo.Factura_Detalle;
import ec.edu.ups.modelo.Productos;
import ec.edu.ups.modelo.Tarjeta;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.modelo.Voto;
import ec.edu.ups.negociointerface.Tresklocal;



@Path("/Tresk")
public class ServiciosTodos {

	
	/**
	 * Variable usada para llamar a los metodos declarados en la Interfaza Local TreskLocal
	 */
	@Inject
	private Tresklocal tresk;
	
	/**
	 * Servicio REST tipo GET que obtiene los datos de las Categorias
	 * @return tresk.getCategoriasL() contine una lista de categorias
	 */
	@GET
	@Path("/categorias")
	@Produces("application/json")
	public List<Categorias> getCategorias(){
		return tresk.getCategoriasL(); 
	}
	/**
	 * 
	 * @return
	 */
	@GET
	@Path("/productosLis")
	@Produces("application/json")
	public List<Productos> getProductos(){
		return tresk.getProductos();
	}
	
	@GET
	@Path("/carritoLista")
	@Produces("application/json")
	public List<Carrito> geCarritos(){
		return tresk.getListaCarrito();
	}
	
	
	@POST
	@Path("/productos")
	@Consumes("application/json")
	@Produces("application/json")
	public Productos  producto(Productos p) {
		Productos pr = new Productos();
		try {
			pr = tresk.getProducto(p.getId());
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
	 tresk.CrearUsuario(usuario);
		
		return true;
	}
	

	@POST
	@Path("/facturaCabecera")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean insertFactura(Factura_Cabecera factura_Cabecera) {

		tresk.insertFacturaCabecera(factura_Cabecera);
		
		return true;
	}
	
	
	@POST
	@Path("/insertarfacturaCabecera")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean insertFacturaCabecera(@QueryParam("cedula") String cedula ,Factura_Cabecera factura_Cabecera) {

		tresk.insertarFacturaCabecera(cedula,factura_Cabecera);
		
		return true;
	}
	
	
	
	@POST
	@Path("/insertarTarjetaUsuario")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean insertarTarjetaUsuario(@QueryParam("cedula") String cedula ,Tarjeta tarjeta) {

		tresk.registarTarjetaUsuario(cedula, tarjeta);
		
		return true;
	}
	
	@POST
	@Path("/insertarDireccionUsuario")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean insertarDireccionUsuario(@QueryParam("cedula") String cedula ,Direccion direccion) {

		tresk.registrarDireccionUsuario(cedula, direccion);
		
		return true;
	}
	
	@POST
	@Path("/insertarfacturaDetalle")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean insertFacturaDetalle(@QueryParam("cedula") String cedula,@QueryParam("id") int id ,Factura_Detalle factura_Detalle) {

		tresk.insertarFacturaDetalle(cedula,id,factura_Detalle);
		
		return true;
	}
	
	
	@POST
	@Path("/realizarPago")
	@Consumes("application/json")
	@Produces("application/json")
	public boolean realizarPago(@QueryParam("cedula") String cedula) {

		tresk.realizarPago(cedula);
		
		return true;
	}
	
	@GET
	@Path("/facturaCabeceraList")
	@Produces("application/json")
	public List<Factura_Cabecera> factura_Cabeceras(){
		return tresk.getfactura_Cabeceras();
	}
	
	@GET
	@Path("/facturaDetalleList")
	@Produces("application/json")
	public List<Factura_Detalle> getfactura_Detalle(){
		return tresk.getfactura_Detalle();
	}
	
	@GET
	@Path("/usuarioListar")
	@Produces("application/json")
	public List<Usuario> listUsuario(){
		return tresk.getUsuarioList();
	}
	
	@GET
	@Path("/usuarioLogin")
	@Produces("application/json")
	public Usuario getUsuarioLogin(@QueryParam("contrasena") String contrasena,@QueryParam("correo") String correo){
		return tresk.getUsuarioLogin(contrasena, correo);
	}
	
	@GET
	@Path("/getidFactura")
	@Produces("application/json")
	public int getIdfacturaCa(){
		return tresk.numeroFacruraId();
	}
	
	@GET
	@Path("/getidFacturaDetalle")
	@Produces("application/json")
	public int getIdfacturaDetalle(){
		tresk.resporteDeProductos();
		return tresk.numeroFacruradetId();
	}
	
	@POST
	@Path("/elimimarDetalleBase")
	@Produces("application/json")
	public boolean elimarDetalle(@QueryParam("facdetalle") int facdetalle,@QueryParam("idFactura") int idFactura){
		tresk.borrarFacturaDetalle(facdetalle, idFactura);
		return true;
	}
	
	
	
	@GET
	@Path("/usuarioFacturas")
	@Produces("application/json")
	public int  getUsuarFactura(@QueryParam("cedula") String contrasena){
		return tresk.getidFacturaCabecera(contrasena);
	}
	
	@GET
	@Path("/getProductoVotado")
	@Produces("application/json")
	public boolean getProductoVotado(@QueryParam("cedula") String cedula,@QueryParam("idP") int idP){
		return tresk.getProductoVotado(cedula, idP);
	}
	
	
	@POST
	@Path("/insertarVoto")
	@Produces("application/json")
	public boolean insertarVoto(@QueryParam("cedula") String cedula,@QueryParam("idP") int idP,Voto voto){
		return tresk.insertarVoto(cedula, idP, voto);
	}
	

		
		
}
