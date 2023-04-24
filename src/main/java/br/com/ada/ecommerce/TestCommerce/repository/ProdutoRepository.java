package br.com.ada.ecommerce.TestCommerce.repository;

import br.com.ada.ecommerce.TestCommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
