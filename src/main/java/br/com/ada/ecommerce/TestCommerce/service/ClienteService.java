package br.com.ada.ecommerce.TestCommerce.service;

import br.com.ada.ecommerce.TestCommerce.model.Cliente;
import br.com.ada.ecommerce.TestCommerce.model.Produto;
import br.com.ada.ecommerce.TestCommerce.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CarrinhoService carrinhoService;

    public Optional<Cliente> cadastrarNovoCliente(Cliente cliente) {
        if (cliente.getEmail().isEmpty())
            return Optional.empty();

        if (cliente.getCarrinho()==null)
            cliente.setCarrinho(carrinhoService.criarCarrinho(cliente));

        return Optional.of(clienteRepository.save(cliente));
    }

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id){
        return clienteRepository.findById(id);
    }

    public void removerClientePorId(Long id){
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> atualizarCliente(Cliente clienteNovo){
        Optional<Cliente> clienteAntigo = buscarPorId(clienteNovo.getId());
        if (clienteAntigo.isPresent()){
            removerClientePorId(clienteAntigo.get().getId());
            clienteNovo.setCarrinho(clienteAntigo.get().getCarrinho());
        }
        return cadastrarNovoCliente(clienteNovo);
    }
}
