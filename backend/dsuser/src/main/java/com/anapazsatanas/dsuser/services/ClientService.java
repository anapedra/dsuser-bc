package com.anapazsatanas.dsuser.services;

import com.anapazsatanas.dsuser.resources.ClientRepository;
import com.anapazsatanas.dsuser.model.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Transactional
    public List<Client> findAll(){
        List<Client> clients=clientRepository.findAll();
        return clients;
    }
    @Transactional
    public Client findById(Long id){
        Optional<Client>client =clientRepository.findById(id);
        return client.get();
    }
    @Transactional
    public Client save(Client client){
        clientRepository.save(client);
        return client;
    }
    public Client update(Long id, Client client){
        client.setId(id);
        return client;
    }
    @Transactional
    public void delet(Long id){
        clientRepository.deleteById(id);
    }
}
