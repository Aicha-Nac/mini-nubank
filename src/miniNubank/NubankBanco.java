package miniNubank;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class NubankBanco implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, ModelCliente> clientes = new HashMap<>();
    private Map<String, ModelConta> contas = new HashMap<>();
    private Map<String, Cartao> cartoes = new HashMap<>();

    // sequenciadores simples (para gerar ids)
    private int nextClienteId = 1;
    private int nextContaNumero = 1;

    // ---------- CRUD cliente/conta ----------
    public String gerarNovoClienteId() {
        return String.valueOf(nextClienteId++);
    }

    public String gerarNovoNumeroConta() {
        return String.format("%04d", nextContaNumero++);
    }

    public void adicionarCliente(ModelCliente c) {
        clientes.put(c.getId(), c);
        // salvar automaticamente
        Serializacao.salvarBanco(this);
    }

    public ModelCliente buscarCliente(String id) {
        return clientes.get(id);
    }

    public void adicionarConta(ModelConta conta) {
        contas.put(conta.getNumero(), conta);
        Serializacao.salvarBanco(this);
    }

    public ModelConta buscarConta(String numeroConta) {
        return contas.get(numeroConta);
    }

    // autenticação por id do cliente e senha
    public boolean autenticar(String clienteId, String senha) {
        ModelCliente c = buscarCliente(clienteId);
        if (c == null) return false;
        return c.getSenha() != null && c.getSenha().equals(senha);
    }

    // ---------- operações com autosave ----------
    public boolean depositar(String numeroConta, double valor) {
        ModelConta c = buscarConta(numeroConta);
        if (c == null) return false;
        c.depositar(valor);
        Serializacao.salvarBanco(this);
        return true;
    }

    public boolean sacar(String numeroConta, double valor) {
        ModelConta c = buscarConta(numeroConta);
        if (c == null) return false;
        boolean ok = c.sacar(valor);
        if (ok) Serializacao.salvarBanco(this);
        return ok;
    }

    public boolean transferir(String numeroOrigem, String numeroDestino, double valor) {
        ModelConta origem = buscarConta(numeroOrigem);
        ModelConta destino = buscarConta(numeroDestino);
        if (origem == null || destino == null) return false;
        boolean ok = origem.transferirPara(destino, valor);
        if (ok) Serializacao.salvarBanco(this);
        return ok;
    }

    // vincular cartão à conta
    public boolean vincularCartao(String numeroCartao, String numeroConta, double limite) {
        ModelConta c = buscarConta(numeroConta);
        if (c == null) return false;
        Cartao cartao = new Cartao(numeroCartao, numeroConta, limite);
        cartoes.put(numeroCartao, cartao);
        c.vincularCartao(numeroCartao);
        Serializacao.salvarBanco(this);
        return true;
    }

    // compra por cartão (débito imediato no saldo da conta) - não estamos implementando crédito/fatura aqui
    public boolean compraComCartao(String numeroCartao, double valor) {
        Cartao card = cartoes.get(numeroCartao);
        if (card == null || !card.isAtivo()) return false;
        ModelConta conta = buscarConta(card.getContaNumero());
        if (conta == null) return false;
        boolean ok = conta.sacar(valor);
        if (!ok) return false;
        conta.adicionarTransacao(new Transacao("Compra Cartão", valor, "cartão " + numeroCartao));
        Serializacao.salvarBanco(this);
        return true;
    }

    // exibir extrato
    public void exibirExtrato(String numeroConta) {
        ModelConta c = buscarConta(numeroConta);
        if (c == null) {
            System.out.println("Conta não encontrada!");
            return;
        }
        c.mostrarExtrato();
    }

    // getters para uso externo / UI
    public Map<String, ModelCliente> getClientes() { return clientes; }
    public Map<String, ModelConta> getContas() { return contas; }
    public Map<String, Cartao> getCartoes() { return cartoes; }

    // método utilitário para criar um banco vazio com sequências corretas
    public static NubankBanco novoBancoVazio() {
        return new NubankBanco();
    }
}
