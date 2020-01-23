package ec.edu.ups.tresk.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import ec.edu.ups.tesk.modelo.Categorias;
import ec.edu.ups.tresk.Bean.CategoriaBean;

@Path("/categorias")
public class CategoriasService {

	@Inject
	private CategoriaBean cc;
	
	@GET
	@Path("/categorias")
	@Produces("application/json")
	public List<Categorias> getCategorias(){
		return cc.listarCategorias(); 
	}
}
