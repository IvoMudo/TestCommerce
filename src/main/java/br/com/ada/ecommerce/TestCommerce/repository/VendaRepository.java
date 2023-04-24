package br.com.ada.ecommerce.TestCommerce.repository;

import br.com.ada.ecommerce.TestCommerce.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda,Long> {
}
