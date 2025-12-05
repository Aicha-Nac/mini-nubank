package miniNubank;


	import java.io.Serializable;
import java.util.HashMap;
	import java.util.Map;

	public class ContaRepositorio implements Serializable {
		private static final long serialVersionUID=1l;
 

	    private Map<String, ModelConta> contas = new HashMap<>();

	    public void salvar(ModelConta conta) {
	        contas.put(conta.getNumero(), conta);
	    }

	    public ModelConta buscarPorNumero(String numero) {
	        return contas.get(numero);
	    }
	}
