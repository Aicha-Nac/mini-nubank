package miniNubank;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RepositorioCartao implements Serializable {
	private static final long serialVersionUID=1l;
 

	    private Map<String, Cartao> cartoes = new HashMap<>();

	    public void salvar(Cartao cartao) {
	        cartoes.put(cartao.getNumero(),cartao);
	    }

	    public Cartao buscar(int numero) {
	        return cartoes.get(numero);
	    }

	    public void remover(int numero) {
	        cartoes.remove(numero);
	    }
	}



