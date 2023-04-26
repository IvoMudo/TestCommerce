package br.com.ada.ecommerce.TestCommerce.controller;

import br.com.ada.ecommerce.TestCommerce.service.ItemProdutoService;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@Sql(scripts={"classpath:init-data.sql"})
public class ItemProdutoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ItemProdutoService itemProdutoService;

    @Test
    public void adicionarItemCarrinhoTest() throws Exception {

        String rota = "/item/adicionar/carrinho/1/produto/1?quantidade=1";

        mockMvc.perform(MockMvcRequestBuilders.post(rota)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }
    @Test
    public void adicionarItemCarrinhoTestMissdata() throws Exception {

        String rota = "/item/adicionar/carrinho/5/produto/1?quantidade=1";

        mockMvc.perform(MockMvcRequestBuilders.post(rota)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}