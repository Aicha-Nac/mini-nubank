package miniNubank;


	import java.io.Serializable;
import java.util.UUID;

	public class ModelCliente implements Serializable {
		private static final long serialVersionUID=1l;
 
	    private String id;
	    private String nome;
	    private String cpf;
	    private String email;

	    public ModelCliente(String nome, String cpf, String email) {
	        this.id = UUID.randomUUID().toString(); // gera id automático
	        this.setNome(nome);
	        this.cpf = cpf;
	        this.setEmail(email);
	    }

	    // getters...
	    public String getId1() { return id; }
	    public String getCpf() { return cpf; }
	    // ...

		public String getId() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}



