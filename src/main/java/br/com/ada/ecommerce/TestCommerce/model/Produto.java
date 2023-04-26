package br.com.ada.ecommerce.TestCommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_produtos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private double valor;

    private String descricao;
}
