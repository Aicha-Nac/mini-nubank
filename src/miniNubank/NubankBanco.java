package miniNubank;


	import java.io.Serializable;
import java.util.HashMap;
	import java.util.Map;

	public class NubankBanco implements Serializable {
		private static final long serialVersionUID=1l;


	    // Map → chave = número da conta | valor = objeto Conta
	    private static Map<String, ModelConta> contas = new HashMap<>();

	    public static void adicionarConta(ModelConta conta) {
	        contas.put(conta.getNumero(), conta);
	    }

	    public ModelConta buscarConta(String numeroConta) {
	        return contas.get(numeroConta);
	    }

	    public Map<String, ModelConta> getContas() {
	        return contas;
	    }

		public void adicionarCliente(ModelCliente c1) {
			// TODO Auto-generated method stub
			
		}
	}



