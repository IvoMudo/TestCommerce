package br.com.ada.ecommerce.TestCommerce.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CarrinhoTest {
    @Test
    public void testCarrinho() {

        // Criar um carrinho Test
        Carrinho carrinho = Carrinho.builder()
                .id(1L)
                .build();

        assertEquals(1L,carrinho.getId());

        assertNull(carrinho.getItemProduto());
    }
}
