import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTest {
    @Test
    void deveRetornarTextoSituacaoTributaria() {
        Produto produto = new Produto();
        produto.setFiscal("Nacional Isenta");

        assertEquals("Nacional Isenta", produto.getFiscal());
    }

    @Test
    void deveRetornarCodigoSituacaoTributaria() {
        Produto produto = new Produto();
        produto.setFiscal("Nacional Isenta");

        assertEquals("040", produto.getCodigo());
    }
}
