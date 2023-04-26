package br.com.ada.ecommerce.TestCommerce.service;

import br.com.ada.ecommerce.TestCommerce.model.Carrinho;
import br.com.ada.ecommerce.TestCommerce.model.Cliente;
import br.com.ada.ecommerce.TestCommerce.model.ItemProduto;
import br.com.ada.ecommerce.TestCommerce.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    CarrinhoRepository carrinhoRepository;

    public Carrinho criarCarrinho(Cliente cliente) {
        return Carrinho.builder().build();
    }

    public Optional<Carrinho> buscarCarrinhoPorId(Long id) {
        return carrinhoRepository.findById(id);
    }

    public void atualizarCarrinho(Carrinho carrinho){
        Double total = carrinho.getItemProdutos().stream().map(itemProduto -> {
            return itemProduto.getQuantidade()*itemProduto.getProduto().getValor();
        }).reduce(0.0, Double::sum);
        carrinho.setValorTotal(total);
        carrinhoRepository.save(carrinho);
    }

    Optional<ItemProduto> fitrarPorIdProduto(Carrinho carrinho, Long id) {
        return carrinho.getItemProdutos().stream()
                .filter(ip -> ip.getProduto().getId().equals(id))
                .findFirst();
    }

}
