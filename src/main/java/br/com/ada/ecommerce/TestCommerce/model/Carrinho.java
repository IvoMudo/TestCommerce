package br.com.ada.ecommerce.TestCommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_carrinhos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany
    @JoinColumn(name = "id_produto")
    private List<ItemProduto> itemProdutos;
}

