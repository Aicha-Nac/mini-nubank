/**
 * Classe de testes unitários da ModelConta.
 */


package miniNubank;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class ModelContaTest {

    private ModelConta conta;

    @BeforeEach
    void setUp() {
        conta = new ModelConta(1, 0.0);
    }
    
    /**
     * Testa operação de depósito.
     */

    @Test
    void testDeposito() {
        conta.depositar(100.0);
        assertEquals(100.0, conta.getSaldo());
    }

    private void assertEquals(double d, double saldo) {
		// TODO Auto-generated method stub
		
	}

	@Test
    void testSaqueComSaldo() {
        conta.depositar(200.0);
        boolean resultado = conta.sacar(50.0);

        assertTrue(resultado);
        assertEquals(150.0, conta.getSaldo());
    }

    private void assertTrue(boolean resultado) {
		// TODO Auto-generated method stub
		
	}

	@Test
    void testSaqueSemSaldo() {
        boolean resultado = conta.sacar(100.0);

        assertFalse(resultado);
        assertEquals(0.0, conta.getSaldo());
    }

    private void assertFalse(boolean resultado) {
		// TODO Auto-generated method stub
		
	}

	@Test
    void testTransferencia() {
        ModelConta destino = new ModelConta(2, 0.0);

        conta.depositar(300.0);
        boolean resultado = conta.transferirPara(destino, 100.0);

        assertTrue(resultado);
        assertEquals(200.0, conta.getSaldo());
        assertEquals(100.0, destino.getSaldo());
    }

    @Test
    void testTransferenciaSemSaldo() {
        ModelConta destino = new ModelConta(2, 0.0);

        boolean resultado = conta.transferirPara(destino, 50.0);

        assertFalse(resultado);
        assertEquals(0.0, conta.getSaldo());
        assertEquals(0.0, destino.getSaldo());
    }
}
