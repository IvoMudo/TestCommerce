package br.com.ada.ecommerce.TestCommerce.service;

import br.com.ada.ecommerce.TestCommerce.model.Cliente;
import br.com.ada.ecommerce.TestCommerce.model.Produto;
import br.com.ada.ecommerce.TestCommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Optional<Produto> adicionarProduto(Produto produto) {
        return Optional.of(produtoRepository.save(produto));
    }

    public void removerProdutoPorId(Long id) {
        produtoRepository.deleteById(id);
    }

    public Optional<Produto> atualizaProduto(Produto produtoNovo) {
        Optional<Produto> produtoAntigo = buscarProdutoPorId(produtoNovo.getId());

        produtoAntigo.ifPresent(produto ->
                removerProdutoPorId(produto.getId()));

        return adicionarProduto(produtoNovo);
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }
}
