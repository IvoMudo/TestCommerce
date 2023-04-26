package br.com.ada.ecommerce.TestCommerce.controller;

import br.com.ada.ecommerce.TestCommerce.model.Produto;
import br.com.ada.ecommerce.TestCommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    @PostMapping("/novo")
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto){
        Optional<Produto> produtoOp = produtoService.adicionarProduto(produto);
        return produtoOp.map(value -> new ResponseEntity<>(value, HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @GetMapping("/{idProduto}")
    public ResponseEntity<?> buscarProdutoPorId(@PathVariable("idProduto") Long idProduto){
        Optional<Produto> produtoOp = produtoService.buscarProdutoPorId(idProduto);
        return produtoOp.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @DeleteMapping("/deletar/{idProduto}")
    public ResponseEntity<?> removerProdutoPorId(@PathVariable("idProduto") Long idProduto){
        produtoService.removerProdutoPorId(idProduto);
        return ResponseEntity.ok(null);
    }
    @PutMapping("atualizar")
    public ResponseEntity<?> atualizaProduto(@RequestBody Produto produto){
        Optional<Produto> produtoOp = produtoService.atualizaProduto(produto);
        return produtoOp.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
