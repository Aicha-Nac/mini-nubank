package miniNubank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Representa uma conta bancária.
 * Permite operações como depósito, saque e transferência.
 */

public class ModelConta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * Número da conta.
     */
    private String numero;    // ex "0001"
    private String clienteId; // id do dono
    
    /**
     * Saldo atual da conta.
     */
    private double saldo;
    
    /**
     * Lista de transações realizadas na conta.
     */
    private List<Transacao> transacoes = new ArrayList<>();
    private List<String> cartoes = new ArrayList<>(); // números de cartão vinculados

    public ModelConta(String numero, String clienteId, double saldoInicial) {
        this.numero = numero;
        this.clienteId = clienteId;
        this.saldo = saldoInicial;
        this.transacoes.add(new Transacao("Abertura de conta", saldoInicial, null));
    }

    public ModelConta(int i, double d) {
		// TODO Auto-generated constructor stub
	}

	public String getNumero() { return numero; }
    public String getClienteId() { return clienteId; }
    public double getSaldo() { return saldo; }
    public List<Transacao> getTransacoes() { return transacoes; }
    public List<String> getCartoes() { return cartoes; }
    /**
     * Realiza um depósito na conta.
     *
     * @param valor valor a ser depositado
     */
    public void depositar(double valor) {
        if (valor <= 0) return;
        saldo += valor;
        adicionarTransacao(new Transacao("Depósito", valor, null));
    }
    /**
     * Realiza um saque da conta.
     *
     * @param valor valor a ser sacado
     * @return true se o saque foi realizado com sucesso
     */

    public boolean sacar(double valor) {
        if (valor <= 0) return false;
        if (saldo < valor) return false;
        saldo -= valor;
        adicionarTransacao(new Transacao("Saque", valor, null));
        return true;
    }
    /**
     * Transfere um valor para outra conta.
     *
     * @param destino conta de destino
     * @param valor valor a ser transferido
     * @return true se a transferência foi realizada
     */
    public boolean transferirPara(ModelConta destino, double valor) {
        if (destino == null) return false;
        if (valor <= 0) return false;
        if (saldo < valor) return false;
        saldo -= valor;
        destino.saldo += valor;
        adicionarTransacao(new Transacao("Transferência - saída", valor, "para conta " + destino.getNumero()));
        destino.adicionarTransacao(new Transacao("Transferência - entrada", valor, "de conta " + this.getNumero()));
        return true;
    }

    public void adicionarTransacao(Transacao t) {
        transacoes.add(t);
    }

    public void vincularCartao(String numeroCartao) {
        if (!cartoes.contains(numeroCartao)) cartoes.add(numeroCartao);
    }

    public void mostrarExtrato() {
        System.out.println("\n--- Extrato da conta " + numero + " ---");
        for (Transacao t : transacoes) {
            System.out.println(t);
        }
        System.out.println("Saldo atual: R$" + String.format("%.2f", saldo));
        System.out.println("-------------------------------\n");
    }

    @Override
    public String toString() {
        return "Conta{numero='" + numero + "', clienteId='" + clienteId + "', saldo=R$" + String.format("%.2f", saldo) + "}";
    }
}
