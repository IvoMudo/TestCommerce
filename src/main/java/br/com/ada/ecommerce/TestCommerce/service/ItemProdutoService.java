package br.com.ada.ecommerce.TestCommerce.service;

import br.com.ada.ecommerce.TestCommerce.model.Carrinho;
import br.com.ada.ecommerce.TestCommerce.model.ItemProduto;
import br.com.ada.ecommerce.TestCommerce.model.Produto;
import br.com.ada.ecommerce.TestCommerce.repository.ItemProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemProdutoService {
    @Autowired
    ItemProdutoRepository itemProdutoRepository;

    @Autowired
    private CarrinhoService carrinhoService;
    @Autowired
    private ProdutoService produtoService;


    public Optional<ItemProduto> buscarPorCarrinhoEProduto(Carrinho carrinho, Produto produto) {
        return itemProdutoRepository.findByCarrinhoAndProduto(carrinho, produto);
    }

    public Optional<ItemProduto> buscarItemProdutoPorId(Long id) {
        return itemProdutoRepository.findById(id);
    }

    public void removerItemProdutoPorId(Long id) {
        itemProdutoRepository.deleteById(id);
    }


    public Optional<ItemProduto> adicionarItemProduto(Long idCarrinho, Long idProduto, int quantidade) {
        Carrinho carrinho = carrinhoService.buscarCarrinhoPorId(idCarrinho).orElse(null);
        Produto produto = produtoService.buscarProdutoPorId(idProduto).orElse(null);

        if (carrinho == null || produto == null)
            return Optional.empty();

        Optional<ItemProduto> itemProduto = buscarPorCarrinhoEProduto(carrinho, produto);

        if (itemProduto.isPresent()) {
            itemProduto.get().setQuantidade(itemProduto.get().getQuantidade() + quantidade);
            carrinhoService.atualizarCarrinho(carrinho);
            return Optional.of(itemProdutoRepository.save(itemProduto.get()));
        } else {
            ItemProduto novoItemProduto = ItemProduto.builder()
                    .carrinho(carrinho)
                    .produto(produto)
                    .quantidade(quantidade)
                    .build();
            carrinhoService.atualizarCarrinho(carrinho);
            return Optional.of(itemProdutoRepository.save(novoItemProduto));
        }
    }

    Optional<ItemProduto> atualizarItemProduto(ItemProduto novoItemProduto) {
        Optional<ItemProduto> itemProdutoAntigo = buscarItemProdutoPorId(novoItemProduto.getId());
        if (itemProdutoAntigo.isPresent()) {
            removerItemProdutoPorId(itemProdutoAntigo.get().getId());

            ItemProduto adicionarItemProduto = itemProdutoAntigo.get();
            return adicionarItemProduto(adicionarItemProduto.getCarrinho().getId(),
                    novoItemProduto.getProduto().getId(),
                    adicionarItemProduto.getQuantidade());
        }
        return Optional.empty();
    }
}
