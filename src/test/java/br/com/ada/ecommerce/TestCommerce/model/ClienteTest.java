package br.com.ada.ecommerce.TestCommerce.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClienteTest {
    //Testando a camada model(entity) do Cliente

    @Test
    public void testCliente() {
        // Criando um clienteTeste
        Cliente cliente = Cliente.builder()
                .nome("John Doe")
                .email("john.doe@example.com")
                .build();

        // Testando Atributos e getters
        assertEquals("John Doe", cliente.getNome());
        assertEquals("john.doe@example.com", cliente.getEmail());

        assertNull(cliente.getCarrinho());

        //Fazer um mock de carrinho
        /*
        Carrinho carrinho = Carrinho.builder()
                .itemVendas(null)
                .build();

        cliente.setCarrinho(carrinho);
        assertEquals(carrinho, cliente.getCarrinho());
         */
    }
}
