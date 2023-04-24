package br.com.ada.ecommerce.TestCommerce.repository;

import br.com.ada.ecommerce.TestCommerce.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
