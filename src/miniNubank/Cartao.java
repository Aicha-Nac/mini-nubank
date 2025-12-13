package miniNubank;

import java.io.Serializable;

public class Cartao implements Serializable {
    private static final long serialVersionUID = 1L;

    private String numero;
    private String contaNumero;
    private double limite; // limite de crédito (opcional)
    private boolean ativo = true;

    public Cartao(String numeroCartao, String contaNumero, double limite) {
        this.numero = numeroCartao;
        this.contaNumero = contaNumero;
        this.limite = limite;
    }

    public String getNumero() { return numero; }
    public String getContaNumero() { return contaNumero; }
    public double getLimite() { return limite; }
    public boolean isAtivo() { return ativo; }

    public void bloquear() { ativo = false; }
    public void ativar() { ativo = true; }

    @Override
    public String toString() {
        return "Cartao{numero='" + numero + "', conta='" + contaNumero + "', limite=R$" + limite + ", ativo=" + ativo + "}";
    }
}


