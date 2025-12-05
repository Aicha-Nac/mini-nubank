
package miniNubank;



public class Principal {

    public static void main(String[] args) {



        // 1️⃣ Carregar banco do arquivo (se existir)

        NubankBanco banco = Serializacao.carregarBanco("banco.dat");



        // 2️⃣ Criar dados novos para testar

        ModelCliente c1 = new ModelCliente("1", "Aïcha", "aicha@email.com");

        ModelConta conta1 = new ModelConta("0001", "1", 1000);



        banco.adicionarConta(conta1);



        conta1.depositar(500);
        conta1.sacar(200);

        conta1.adicionarCartao("1111-2222-3333-4444");



        System.out.println("Saldo atual: R$" + conta1.getSaldo());

        System.out.println("Cartões: " + conta1.getCartoes());

        System.out.println("Transações: " + conta1.getTransacoes());



        // 3️⃣ Salvar banco atualizado

        Serializacao.salvarBanco(banco, "banco.dat");
    }
}

