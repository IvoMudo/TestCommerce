package br.com.ada.ecommerce.TestCommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_item_produto",uniqueConstraints = @UniqueConstraint(columnNames = {"id_carrinho","id_produto"}))
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ItemProduto {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_carrinho")
    private Carrinho carrinho;

    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    private int quantidade;

}