package com.demo.OnlineStore.Controller;

import com.demo.OnlineStore.Controller.Dto.ClientDto;

import com.demo.OnlineStore.Service.ClientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/store/client")
public class ClientController {

    @Autowired
    ClientService clientService;


    @PutMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody ClientDto clientDto){
        clientService.create(clientDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable  Long id){
        return ResponseEntity.ok(clientService.get(id));

    }

    @GetMapping("/list")
    public ResponseEntity<List<ClientDto>> getClients(){
        return ResponseEntity.ok(clientService.getClients());
    }


    @PostMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public void editClient(@RequestBody ClientDto clientDto){
        clientService.edit(clientDto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        clientService.delete(id);
    }


}
