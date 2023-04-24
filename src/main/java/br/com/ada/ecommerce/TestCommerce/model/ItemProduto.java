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

    @ManyToOne
    @JoinColumn(name = "id_carrinho")
    private Long idCarrinho;

    @OneToOne
    @JoinColumn(name = "id_produto")
    private Long idProduto;

    private int quantidade;

}
