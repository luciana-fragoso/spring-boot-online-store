package com.demo.OnlineStore.Service;


import com.demo.OnlineStore.Controller.Dto.ClientDto;
import com.demo.OnlineStore.Exception.NotFoundException;
import com.demo.OnlineStore.Model.Client;
import com.demo.OnlineStore.Repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {


    @Autowired
    ClientRepository clientRepository;


    public void create(ClientDto clientDto){
        Client client = new Client(clientDto.getId(),clientDto.getEmail(),clientDto.getPassword());
        clientRepository.save(client);
    }

    public ClientDto get(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()){
            return new ClientDto(id,client.get().getEmail(), client.get().getPassword());
        }
        else{
            throw new NotFoundException("Client not found");
        }

    }

    public void edit(ClientDto clientDto) {
        Optional<Client> client = clientRepository.findById(clientDto.getId());
        if (client.isPresent()){
            clientRepository.save(new Client(clientDto.getId(),clientDto.getEmail(),clientDto.getPassword()));
        } else {
            throw new NotFoundException("Client not found");
        }


    }

    public List<ClientDto> clientMapper(List<Client> clients){
        return clients.parallelStream().map(a-> new ModelMapper().map(a,ClientDto.class))
                .collect(Collectors.toList());

    }

    public List<ClientDto> getClients() {
        return clientMapper(clientRepository.findAll());
    }


    public void delete(Long id) {
        try {
           clientRepository.deleteById(id);
        } catch(Exception e){
            throw new NotFoundException("Client not found");
        }
    }

}
