package br.com.ada.ecommerce.TestCommerce.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "carrinho",cascade = CascadeType.ALL)
    private Set<ItemProduto> itemProdutos;

    private double valorTotal;

    public void adicionarProduto(ItemProduto itemProduto){
        itemProdutos.add(itemProduto);
    }
}

