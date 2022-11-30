package com.anapazsatanas.dsuser.resources.clientresource;

import com.anapazsatanas.dsuser.DTO.ClientDTO;
import com.anapazsatanas.dsuser.services.clientservice.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    private final ClientService clientService ;
    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAllProduct(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                          @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
                                                          @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                          @RequestParam(value = "orderBy", defaultValue = "id") String orderBy
    ){
        PageRequest pageRequest=PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction),orderBy);
        Page<ClientDTO>client=clientService.findAllPaged(pageRequest);
        return ResponseEntity.ok().body(client);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findProductById(@PathVariable Long id){
        ClientDTO client=clientService.findById(id);
        return ResponseEntity.ok().body(client);
    }
    @PostMapping
    public ResponseEntity<Object > insert(@RequestBody @Valid ClientDTO client){
        client=clientService.saveClient(client);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO>upDate(@PathVariable Long id,@RequestBody  @Valid ClientDTO client){
        client=clientService.upDateClient(id, client);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Valid> daletCategory(@PathVariable Long id){
        clientService.delet(id);
        return ResponseEntity.noContent().build();
    }






}
