package miniNubank;

import java.io.Serializable;

public class Cartao implements Serializable {
	private static final long serialVersionUID=1l;

	    private int numero;
	    private String nomeTitular;
	    private double limite;
	    private String validade;
	    private int cvv;

	    // construtor
	    public Cartao(int numero, String nomeTitular, double limite, String validade, int cvv) {
	        this.numero = numero;
	        this.nomeTitular = nomeTitular;
	        this.limite = limite;
	        this.validade = validade;
	        this.cvv = cvv;
	    }

	    // getters e setters
	    public int getNumero() { return numero; }
	    public void setNumero(int numero) { this.numero = numero; }

	    public String getNomeTitular() { return nomeTitular; }
	    public void setNomeTitular(String nomeTitular) { this.nomeTitular = nomeTitular; }

	    public double getLimite() { return limite; }
	    public void setLimite(double limite) { this.limite = limite; }

	    public String getValidade() { return validade; }
	    public void setValidade(String validade) { this.validade = validade; }

	    public int getCvv() { return cvv; }
	    public void setCvv(int cvv) { this.cvv = cvv; }
	}



