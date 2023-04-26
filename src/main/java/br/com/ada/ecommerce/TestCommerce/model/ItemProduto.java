package br.com.ada.ecommerce.TestCommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_item_produto", uniqueConstraints = @UniqueConstraint(columnNames = {"id_carrinho", "id_produto"}))
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ItemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_carrinho", nullable = false)
    private Carrinho carrinho;

    @OneToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    private int quantidade;

    @Override
    public String toString() {
        return "ItemProduto{" +
                "id=" + id +
                ", carrinhoId=" + carrinho.getId() +
                ", produtoNome=" + produto.getNome() +
                ", quantidade=" + quantidade +
                '}';
    }
}