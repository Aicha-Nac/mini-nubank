package miniNubank;

import java.io.Serializable;
/**
 * Representa um cliente do banco digital.
 * Contém informações pessoais e credenciais de acesso.
 */

public class ModelCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Identificador único do cliente.
     */
    private String id;
    /**
     * Nome completo do cliente.
     */
    private String nome;
    
    /**
     * CPF do cliente.
     */
    private String cpf;
    
    /**
     * Email do cliente.
     */
    private String email;
    
    /**
     * Senha usada para autenticação do cliente.
     */
    private String senha;

    public ModelCliente(String id, String nome, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }

    @Override
    public String toString() {
        return "Cliente{id='" + id + "', nome='" + nome + "', cpf='" + cpf + "', email='" + email + "'}";
    }
}
