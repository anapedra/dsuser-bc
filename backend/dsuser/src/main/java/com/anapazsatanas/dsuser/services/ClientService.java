package com.anapazsatanas.dsuser.services;

import com.anapazsatanas.dsuser.DTO.ClientDTO;
import com.anapazsatanas.dsuser.resources.ClientRepository;
import com.anapazsatanas.dsuser.model.Client;
import com.anapazsatanas.dsuser.services.exceptions.DataBaseException;
import com.anapazsatanas.dsuser.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
        Page<Client> list=clientRepository.findAll(pageRequest);
        return list.map(x -> new ClientDTO(x));
    }
    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Optional<Client> obj=clientRepository.findById(id);
        Client entity=obj.orElseThrow(
                ()-> new ResourceNotFoundException("Id "+id+" not found"));
        return new ClientDTO(entity);
    }
    @Transactional
    public ClientDTO saveClient(ClientDTO clientDTO) {
        var client=new Client();
        copyDtoToEntity(clientDTO,client);
       // BeanUtils.copyProperties(clientDTO,client);
        client=clientRepository.save(client);
        return new ClientDTO(client);
    }
    @Transactional
    public ClientDTO upDateClient(Long id, ClientDTO clientDTO){
        try {
            var client= clientRepository.getReferenceById(id);
            // BeanUtils.copyProperties(clientDTO,client);
            copyDtoToEntity(clientDTO,client);
            client=clientRepository.save(client);
            return new ClientDTO(client);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id " + id + " not found :(");
        }

    }

    public void delet(Long id){

        try {
            clientRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id "+id+" not found!");
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException("Integrity violation");
        }

    }

    private void copyDtoToEntity(ClientDTO clientDTO, Client client){
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setChildren(clientDTO.getChildren());
        client.setBirthDate(clientDTO.getBirthDate());

    }

}
