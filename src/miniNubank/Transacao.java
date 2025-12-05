package miniNubank;


	import java.io.Serializable;
import java.time.LocalDateTime;

	public class Transacao implements Serializable {
		private static final long serialVersionUID=1l;
 
	    private String tipo;
	    private double valor;
	    private LocalDateTime dataHora;

	    public Transacao(String tipo, double valor) {
	        this.tipo = tipo;
	        this.valor = valor;
	        this.dataHora = LocalDateTime.now();
	    }

	    public void Transacao1(String descricao2, double valor2) {
			// TODO Auto-generated constructor stub
		}

		public String gettipo() { return tipo; }
	    public double getValor() { return valor; }
	    public LocalDateTime getData() { return dataHora; }
	    
	    @Override
	    public String toString() {
		return "Transação{" +
	    "tipo='" + tipo + '\'' +
	    ", valor=" + valor +
	    ", dataHora=" + dataHora +
	    '}';
	    }
	    }
	



