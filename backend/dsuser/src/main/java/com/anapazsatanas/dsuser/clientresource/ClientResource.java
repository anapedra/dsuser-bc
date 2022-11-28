package com.anapazsatanas.dsuser.clientresource;

import com.anapazsatanas.dsuser.clientuser.ClientService;
import com.anapazsatanas.dsuser.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    private final ClientService clientService ;
    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
       List<Client>clients=clientService.findAll();
       return ResponseEntity.ok().body(clients);
    }


}
