package br.com.ada.ecommerce.TestCommerce.repository;

import br.com.ada.ecommerce.TestCommerce.model.Carrinho;
import br.com.ada.ecommerce.TestCommerce.model.ItemProduto;
import br.com.ada.ecommerce.TestCommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemProdutoRepository extends JpaRepository<ItemProduto,Long> {
    public Optional<ItemProduto> findByCarrinhoAndProduto(Carrinho carrinho, Produto produto);
}
