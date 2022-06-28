package com.bootcampfinish.afp.controller;

import com.bootcampfinish.afp.model.ClientModel;
import com.bootcampfinish.afp.service.IClientService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Slf4j
public class ClientController {

    private final IClientService clientService;

    @GetMapping(path = { "client" }, produces = { "application/json" })
    public ResponseEntity<Object> getAll() throws Exception {
        List<ClientModel> response =  clientService.findAll();
        log.info("getAll" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

   @GetMapping(path = { "client/{id}" }, produces = { "application/json" })
    public ResponseEntity<ClientModel> getById(@PathVariable("id") Long id) throws Exception{
        ClientModel response = clientService.findById(id);
        log.info("getById" + "OK");
        log.debug(id.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "client")
    public ResponseEntity<Object> create(@RequestBody ClientModel clientModel) throws Exception {
        ClientModel response = clientService.create(clientModel);
        log.info("create" + "OK");
        log.debug(clientModel.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = { "client/{id}" }, produces = { "application/json" })
    public void update(
            @PathVariable("id") Long id,
            @RequestBody ClientModel clientModel) throws Exception {
        clientService.update(id, clientModel);
        log.info("update" + "OK");
        log.debug(id.toString()+ "/" + clientModel.toString());
    }

    @DeleteMapping({ "client/{id}" })
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        clientService.deleteById(id);
    }

}
