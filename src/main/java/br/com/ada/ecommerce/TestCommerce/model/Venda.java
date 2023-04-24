package br.com.ada.ecommerce.TestCommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_vendas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private boolean foiEntregue;

    @OneToMany(mappedBy = "id_venda",cascade = CascadeType.ALL)
    private List<ItemVenda> itemVendas;
}
