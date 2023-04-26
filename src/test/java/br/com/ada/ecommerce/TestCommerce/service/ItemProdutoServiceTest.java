package br.com.ada.ecommerce.TestCommerce.service;

import br.com.ada.ecommerce.TestCommerce.model.Carrinho;
import br.com.ada.ecommerce.TestCommerce.model.ItemProduto;
import br.com.ada.ecommerce.TestCommerce.model.Produto;
import br.com.ada.ecommerce.TestCommerce.repository.ItemProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ItemProdutoServiceTest {
    /*
    Funcionalidades da ClienteService:
        cadastrarNovoCliente
        listarTodos
        buscarPorId
        removerClientePorId
        atualizarCliente
     */
    @Mock
    ItemProdutoRepository itemProdutoRepository;

    @Mock //Classe a ser mockada(classe falsa)
    private ProdutoService produtoService;

    @Mock
    private CarrinhoService carrinhoService;

    @InjectMocks //Classe em que os mocks são injetados
    private ItemProdutoService itemProdutoService;

    @Test
    public void adicionarItemProduto() {
        Long idCarrinho = 1L;
        Long idProduto = 1L;
        int quantidade = 1;

        Carrinho carrinho = Carrinho.builder()
                .id(idCarrinho)
                .build();

        Produto produto = Produto.builder()
                .id(idProduto)
                .nome("shampoo")
                .descricao("coisa para cabelo")
                .valor("15.50")
                .build();

        ItemProduto itemProduto = ItemProduto.builder().build();

        ItemProduto novoItemProduto = ItemProduto.builder()
                .carrinho(carrinho)
                .produto(produto)
                .quantidade(quantidade)
                .build();

        when(carrinhoService.buscarCarrinhoPorId(any()))
                .thenReturn(Optional.of(carrinho));

        when(produtoService.buscarProdutoPorId(any()))
                .thenReturn(Optional.of(produto));

        when(itemProdutoRepository.findByCarrinhoAndProduto(any(),any()))
                .thenReturn(Optional.empty());

        when(itemProdutoRepository.save(any()))
                .thenReturn(novoItemProduto);

        Optional<ItemProduto> retorno = itemProdutoService.adicionarItemProduto(idCarrinho,idProduto,quantidade);
        System.out.println(retorno);
        ;

        Assertions.assertTrue(retorno.isPresent());
        Assertions.assertEquals(retorno.get().getQuantidade(),quantidade);
        Assertions.assertEquals(retorno.get().getCarrinho().getId(),idCarrinho);
        Assertions.assertEquals(retorno.get().getCarrinho(),carrinho);
        Assertions.assertEquals(retorno.get().getProduto().getId(),idProduto);
        Assertions.assertEquals(retorno.get().getProduto(),produto);
    }

    @Test
    public void adicionarItemProdutoExistente() {
        Long idCarrinho = 1L;
        Long idProduto = 1L;
        int quantidade = 1;
        int quantidadeExistente = 1;

        Carrinho carrinho = Carrinho.builder()
                .id(idCarrinho)
                .build();

        Produto produto = Produto.builder()
                .id(idProduto)
                .nome("shampoo")
                .descricao("coisa para cabelo")
                .valor("15.50")
                .build();

        ItemProduto itemProduto = ItemProduto.builder()
                .carrinho(carrinho)
                .produto(produto)
                .quantidade(quantidadeExistente)
                .build();

        ItemProduto novoItemProduto = ItemProduto.builder()
                .carrinho(carrinho)
                .produto(produto)
                .quantidade(quantidade)
                .build();

        when(carrinhoService.buscarCarrinhoPorId(any()))
                .thenReturn(Optional.of(carrinho));

        when(produtoService.buscarProdutoPorId(any()))
                .thenReturn(Optional.of(produto));

        when(itemProdutoRepository.findByCarrinhoAndProduto(any(),any()))
                .thenReturn(Optional.of(itemProduto));

        when(itemProdutoRepository.save(any()))
                .thenReturn(itemProduto);

        Optional<ItemProduto> retorno = itemProdutoService.adicionarItemProduto(idCarrinho,idProduto,quantidade);
        System.out.println(retorno);
        ;

        Assertions.assertTrue(retorno.isPresent());
        Assertions.assertEquals(retorno.get().getQuantidade(),quantidade+quantidadeExistente);
        Assertions.assertEquals(retorno.get().getCarrinho().getId(),idCarrinho);
        Assertions.assertEquals(retorno.get().getCarrinho(),carrinho);
        Assertions.assertEquals(retorno.get().getProduto().getId(),idProduto);
        Assertions.assertEquals(retorno.get().getProduto(),produto);
    }
    @Test
    public void adicionarItemProdutoQuantidadeInvalida() {
        Long idCarrinho = 1L;
        Long idProduto = 1L;
        int quantidade = 1;
        int quantidadeExistente = 1;

        Carrinho carrinho = Carrinho.builder()
                .id(idCarrinho)
                .build();

        Produto produto = Produto.builder()
                .id(idProduto)
                .nome("shampoo")
                .descricao("coisa para cabelo")
                .valor("15.50")
                .build();

        ItemProduto itemProduto = ItemProduto.builder()
                .carrinho(carrinho)
                .produto(produto)
                .quantidade(quantidadeExistente)
                .build();

        ItemProduto novoItemProduto = ItemProduto.builder()
                .carrinho(carrinho)
                .produto(produto)
                .quantidade(quantidade)
                .build();

        when(carrinhoService.buscarCarrinhoPorId(any()))
                .thenReturn(Optional.of(carrinho));

        when(produtoService.buscarProdutoPorId(any()))
                .thenReturn(Optional.of(produto));

        when(itemProdutoRepository.findByCarrinhoAndProduto(any(),any()))
                .thenReturn(Optional.of(itemProduto));

        when(itemProdutoRepository.save(any()))
                .thenReturn(itemProduto);

        Optional<ItemProduto> retorno = itemProdutoService.adicionarItemProduto(idCarrinho,idProduto,quantidade);
        System.out.println(retorno);
        ;

        Assertions.assertTrue(retorno.isPresent());
        Assertions.assertEquals(retorno.get().getQuantidade(),quantidade+quantidadeExistente);
        Assertions.assertEquals(retorno.get().getCarrinho().getId(),idCarrinho);
        Assertions.assertEquals(retorno.get().getCarrinho(),carrinho);
        Assertions.assertEquals(retorno.get().getProduto().getId(),idProduto);
        Assertions.assertEquals(retorno.get().getProduto(),produto);
    }
}
