package br.com.ada.ecommerce.TestCommerce.controller;

import br.com.ada.ecommerce.TestCommerce.model.Cliente;
import br.com.ada.ecommerce.TestCommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/novo")
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        Optional<Cliente> novocliente = clienteService.cadastrarNovoCliente(cliente);
        return novocliente.map(value ->
                new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() ->
                        new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
    @GetMapping("/")
    public ResponseEntity<List<Cliente>> listar() {
        return new ResponseEntity<>(clienteService.listarTodos(), HttpStatus.OK);
    }

    @DeleteMapping("/remove/{idCliente}")
    public ResponseEntity<?> removerClientePorId(@PathVariable("idCliente")Long idCliente){
        clienteService.removerClientePorId(idCliente);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable("idCliente")Long idCliente){
        Optional<Cliente> cliente = clienteService.buscarPorId(idCliente);
        return cliente.map(value ->
                new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                        new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
