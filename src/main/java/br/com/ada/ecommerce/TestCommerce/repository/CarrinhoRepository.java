package br.com.ada.ecommerce.TestCommerce.repository;

import br.com.ada.ecommerce.TestCommerce.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
