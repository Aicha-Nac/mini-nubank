package miniNubank;

import java.util.Map;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NubankBanco banco = Serializacao.carregarBanco();

        // se não houver clientes, cria exemplo (opcional)
        if (banco.getClientes().isEmpty()) {
            ModelCliente c1 = new ModelCliente("1", "Aicha", "000.000.000-00", "aicha@email.com", "1234");
            banco.adicionarCliente(c1);
            ModelConta conta1 = new ModelConta("0001", "1", 1000);
            banco.adicionarConta(conta1);
            Serializacao.salvarBanco(banco);
            System.out.println("Conta de exemplo criada: idCliente=1, conta=0001, senha=1234");
        }

        while (true) {
            System.out.println("\n=== Mini Nubank ===");
            System.out.println("1) Login");
            System.out.println("2) Criar cliente + conta");
            System.out.println("0) Sair");
            System.out.print("Opção: ");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    System.out.print("ID do cliente: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine().trim();
                    if (!banco.autenticar(id, senha)) {
                        System.out.println("Login inválido.");
                        break;
                    }
                    clienteMenu(banco, sc, id);
                    break;

                case "2":
                    criarClienteUI(banco, sc);
                    break;

                case "0":
                    Serializacao.salvarBanco(banco);
                    System.out.println("Saindo.");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void clienteMenu(NubankBanco banco, Scanner sc, String clienteId) {
        // pega a primeira conta do cliente (se tiver várias, você pode adaptar)
        String contaNumero = null;
        for (Map.Entry<String, ModelConta> e : banco.getContas().entrySet()) {
            if (e.getValue().getClienteId().equals(clienteId)) {
                contaNumero = e.getKey();
                break;
            }
        }
        if (contaNumero == null) {
            System.out.println("Nenhuma conta vinculada a esse cliente.");
            return;
        }

        while (true) {
            System.out.println("\n--- Menu Conta (conta=" + contaNumero + ") ---");
            System.out.println("1) Depositar");
            System.out.println("2) Sacar");
            System.out.println("3) Transferir");
            System.out.println("4) Extrato");
            System.out.println("5) Vincular cartão");
            System.out.println("6) Compra com cartão");
            System.out.println("9) Salvar banco");
            System.out.println("0) Logout");
            System.out.print("Opção: ");
            String opc = sc.nextLine().trim();

            switch (opc) {
                case "1":
                    System.out.print("Valor: ");
                    double v = Double.parseDouble(sc.nextLine());
                    if (banco.depositar(contaNumero, v)) System.out.println("Depósito OK.");
                    else System.out.println("Erro no depósito.");
                    break;

                case "2":
                    System.out.print("Valor: ");
                    double vs = Double.parseDouble(sc.nextLine());
                    if (banco.sacar(contaNumero, vs)) System.out.println("Saque OK.");
                    else System.out.println("Saque negado (saldo insuficiente).");
                    break;

                case "3":
                    System.out.print("Conta destino (número): ");
                    String dest = sc.nextLine().trim();
                    System.out.print("Valor: ");
                    double vt = Double.parseDouble(sc.nextLine());
                    if (banco.transferir(contaNumero, dest, vt)) System.out.println("Transferência OK.");
                    else System.out.println("Falha na transferência.");
                    break;

                case "4":
                    banco.exibirExtrato(contaNumero);
                    break;

                case "5":
                    System.out.print("Número do cartão (qualquer string): ");
                    String num = sc.nextLine().trim();
                    System.out.print("Limite do cartão (ex: 500): ");
                    double limite = Double.parseDouble(sc.nextLine());
                    if (banco.vincularCartao(num, contaNumero, limite)) System.out.println("Cartão vinculado.");
                    else System.out.println("Erro ao vincular cartão.");
                    break;

                case "6":
                    System.out.print("Número do cartão: ");
                    String cart = sc.nextLine().trim();
                    System.out.print("Valor da compra: ");
                    double valc = Double.parseDouble(sc.nextLine());
                    if (banco.compraComCartao(cart, valc)) System.out.println("Compra realizada.");
                    else System.out.println("Falha na compra (cartão inválido ou saldo insuficiente).");
                    break;

                case "9":
                    Serializacao.salvarBanco(banco);
                    System.out.println("Banco salvo.");
                    break;

                case "0":
                    Serializacao.salvarBanco(banco);
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void criarClienteUI(NubankBanco banco, Scanner sc) {
        System.out.print("ID desejado (string): ");
        String id = sc.nextLine().trim();
        if (banco.buscarCliente(id) != null) {
            System.out.println("ID já existe.");
            return;
        }
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        System.out.print("CPF: ");
        String cpf = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();
        System.out.print("Senha: ");
        String senha = sc.nextLine().trim();

        ModelCliente novo = new ModelCliente(id, nome, cpf, email, senha);
        banco.adicionarCliente(novo);

        System.out.print("Deseja criar uma conta agora para este cliente? (s/n): ");
        String r = sc.nextLine().trim();
        if (r.equalsIgnoreCase("s")) {
            System.out.print("Número da conta (ex: 0002): ");
            String num = sc.nextLine().trim();
            System.out.print("Saldo inicial: ");
            double s = Double.parseDouble(sc.nextLine());
            ModelConta conta = new ModelConta(num, id, s);
            banco.adicionarConta(conta);
            System.out.println("Conta criada: " + num);
        }

        Serializacao.salvarBanco(banco);
        System.out.println("Cliente criado: " + novo);
    }
}
