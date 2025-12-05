package miniNubank;


	import java.io.Serializable;
import java.util.ArrayList;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Set;

	public class ModelConta implements Serializable {
		private static final long serialVersionUID=1l;
 
	    private String numero;
	    private String cliente;
	    private double saldo;

	    // List → histórico de transações
	    private List<Transacao> transacoes = new ArrayList<>();

	    // Set → cartões (não aceita duplicados)
	    private Set<String> cartoes = new HashSet<>();

	    public ModelConta(String numero, String cliente, double saldoInicial) {
	        this.numero = numero;
	        this.cliente = cliente;
	        this.saldo = saldoInicial;
	    }

	    public String getNumero1() { return numero; }
	    public String getCliente() { return cliente ; }
	    public double getSaldo() { return saldo; }

	    public List<Transacao> getTransacoes() { return transacoes; }
	    public Set<String> getCartoes() { return cartoes; }

	    public void depositar(double valor) {
	        saldo += valor;
	        transacoes.add(new Transacao("Depósito", valor));
	    }

	    public boolean sacar(double valor) {
	        if (valor > saldo) return false;

	        saldo -= valor;
	        transacoes.add(new Transacao("Saque", -valor));
	        return true;
	    }

	    public void adicionarCartao(String numeroCartao) {
	        cartoes.add(numeroCartao); // SET evita duplicados
	    }

		public String getNumero() {
			// TODO Auto-generated method stub
			return null;
		}
	}



