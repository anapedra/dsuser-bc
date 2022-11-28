package com.anapazsatanas.dsuser.clientresource;

import com.anapazsatanas.dsuser.clientRepository.ClientRepository;
import com.anapazsatanas.dsuser.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    private final ClientRepository clientRepository;
    public ClientResource(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
       List<Client>clients=new ArrayList<>();
        Client client1=new Client(1l,"Ana","015999864632",56.9,Instant.now(),5);
        Client client2=new Client(2l,"Ana Lucia","015999864632",56.9,Instant.now(),5);
        Client client5=new Client(3L,"Ana MARIA","015999864632",56.9,Instant.now(),5);
        clients.addAll(Arrays.asList(client1,client2,client5));
       return ResponseEntity.ok().body(clients);
    }


}
