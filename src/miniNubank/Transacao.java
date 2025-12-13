package miniNubank;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * Representa uma transação bancária.
 * Pode ser depósito, saque ou transferência.
 */

public class Transacao implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Tipo da transação.
     */

    private String tipo; // Depósito, Saque, Transferência, Compra Cartão, Pagamento Fatura...
    
    /**
     * Valor da transação.
     */
    private double valor;
    /**
     * Data da transação.
     */
    
    private LocalDateTime dataHora;
    private String info; // texto extra (ex: conta destino, número do cartão)

    public Transacao(String tipo, double valor, String info) {
        this.tipo = tipo;
        this.valor = valor;
        this.info = info;
        this.dataHora = LocalDateTime.now();
    }

    public String getTipo() { return tipo; }
    public double getValor() { return valor; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getInfo() { return info; }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + dataHora.format(f) + "] " + tipo + " - R$" + String.format("%.2f", valor)
               + (info != null && !info.isEmpty() ? " (" + info + ")" : "");
    }
}
