package miniNubank;



	import java.io.Serializable;
import java.util.HashMap;
	import java.util.Map;

	public class ClienteRepositorio implements Serializable {
		private static final long serialVersionUID=1l;
 

	    private Map<String, ModelCliente> clientes = new HashMap<>();

	    public void salvar(ModelCliente cliente) {
	        clientes.put(cliente.getId(), cliente);
	    }

	    public ModelCliente buscarPorId(String id) {
	        return clientes.get(id);
	    }
	}


