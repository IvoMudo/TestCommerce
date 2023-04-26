package br.com.ada.ecommerce.TestCommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_item_vendas",uniqueConstraints = @UniqueConstraint(columnNames = {"id_venda","id_produto"}))
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ItemVenda {

    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_venda")
    private Venda venda;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produto")
    private Produto produto;

    private int quantidade;

    private String valorItem;

}