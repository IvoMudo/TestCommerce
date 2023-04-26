package br.com.ada.ecommerce.TestCommerce.service;

import br.com.ada.ecommerce.TestCommerce.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

}
