package br.com.ada.ecommerce.TestCommerce.controller;

import br.com.ada.ecommerce.TestCommerce.model.ItemProduto;
import br.com.ada.ecommerce.TestCommerce.service.ItemProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemPedidoController {

    @Autowired
    private ItemProdutoService itemProdutoService;

    @PostMapping("/carrinho/{idCarrinho}/produto/{idProduto}")
    public ResponseEntity<ItemProduto> adicionarItemCarrinho(
            @PathVariable Long idCarrinho,
            @PathVariable Long idProduto,
            @RequestParam(value = "quantidade") Integer quantidade
    ) {
        Optional<ItemProduto> itemProduto = itemProdutoService.adicionarItemProduto(idCarrinho, idProduto, quantidade);
        if (itemProduto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(itemProduto.get(),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemProduto> buscarItemProdutoPorId(@PathVariable("id")Long id){
        Optional<ItemProduto> itemProdutoOptional = itemProdutoService.buscarItemProdutoPorId(id);

        return itemProdutoOptional.map(itemProduto -> {
            return new ResponseEntity<>(itemProduto,HttpStatus.OK);
        }).orElseGet(()->{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        });
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> removerItemProdutoPorId(@PathVariable("id")Long id){
        itemProdutoService.removerItemProdutoPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
