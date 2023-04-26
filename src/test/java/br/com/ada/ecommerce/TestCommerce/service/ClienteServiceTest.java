package br.com.ada.ecommerce.TestCommerce.service;

import br.com.ada.ecommerce.TestCommerce.model.Carrinho;
import br.com.ada.ecommerce.TestCommerce.model.Cliente;
import br.com.ada.ecommerce.TestCommerce.repository.ClienteRepository;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClienteServiceTest {
    /*
    Funcionalidades da ClienteService:
        cadastrarNovoCliente
        listarTodos
        buscarPorId
        removerClientePorId
        atualizarCliente
     */

    @Mock //Classe a ser mockada(classe falsa)
    private ClienteRepository clienteRepository;

    @Mock
    private CarrinhoService carrinhoService;

    @InjectMocks //Classe em que os mocks são injetados
    private ClienteService clienteService;


    @Test
    public void testeCadastrarCliente() {
        //
        // Cria uma entidade Cliente para ser testada
        Cliente cliente = Cliente.builder()
                .id(1L)
                .nome("John Doe")
                .email("john.doe@example.com")
                .build();
        System.out.println(cliente);

        // Usa mockito para simular um comportamento em clienteRepository
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        when(carrinhoService.criarCarrinho(any(Cliente.class)))
                .thenReturn(Carrinho.builder()
                        .cliente(cliente)
                        .build()
                );

        // Chama o método do service cadastrarNovoCliente()
        Optional<Cliente> resultado = clienteService.cadastrarNovoCliente(cliente);

        //
        assertThat(resultado).isPresent();
        System.out.println(resultado.get());

        assertThat(resultado.get()).isEqualTo(cliente);
        Assertions.assertNull(resultado.get().getCarrinho().getItemProdutos());

    }

    @Test
    public void testeCadastrarClienteInvalido() {
        // Criar uma entidade Cliente para ser testada
        Cliente cliente = Cliente.builder()
                .id(1L)
                .nome("John Doe")
                .email("")
                .build();

        // Usa mockito para simular um comportamento em clienteRepository
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        // Chama o método do service cadastrarNovoCliente()
        Optional<Cliente> resultado = clienteService.cadastrarNovoCliente(cliente);

        System.out.println(resultado);
        assertThat(resultado).isEmpty();
    }

    @Test
    public void testeBuscarPorId() {
        // Create a new Cliente entity
        Cliente cliente = Cliente.builder()
                .id(1L)
                .nome("John Doe")
                .email("john.doe@example.com")
                .build();

        // Use Mockito to mock the behavior of the repository method findById()
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(cliente));

        // Call the service method findById() and assert that the returned object is equal to the original object
        Optional<Cliente> found = clienteService.buscarPorId(1L);
        assertThat(found).isPresent();
        assertThat(found.get()).isEqualTo(cliente);

        System.out.println(found.get());
    }
}

