package br.com.ada.ecommerce.TestCommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_item_produto",uniqueConstraints = @UniqueConstraint(columnNames = {"id_venda","id_produto"}))
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ItemVenda {

    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Long idVenda;

    @OneToOne
    @JoinColumn(name = "id_produto")
    private Long idProduto;

    private int quantidade;

    private String valorItem;

}