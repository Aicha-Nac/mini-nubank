package miniNubank;


	import static org.junit.jupiter.api.Assertions.*;
	import org.junit.jupiter.api.Test;

	public class TransacaoTest {

	    @Test
	    void testCriacaoTransacao() {
	        Transacao t = new Transacao("DEPÓSITO", 100, "null");

	        assertEquals("DEPÓSITO", t.getTipo());
	        assertEquals(100, t.getValor());
	        assertNotNull(t.getDataHora());
	    }
	}


