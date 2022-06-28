package com.bootcampfinish.afp.controller;

import com.bootcampfinish.afp.model.RequestAfpModel;
import com.bootcampfinish.afp.repositorie.domain.RequestAfp;
import com.bootcampfinish.afp.service.IRequestAfpService;
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
public class RequestAfpController {

    private final IRequestAfpService requestAfpService;

    @GetMapping(path = { "requestAfp" }, produces = { "application/json" })
    public ResponseEntity<Object> getAll() throws Exception {
        List<RequestAfpModel> response =  requestAfpService.findAll();
        log.info("getAll" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = { "requestAfp/{id}" }, produces = { "application/json" })
    public ResponseEntity<RequestAfpModel> getById(@PathVariable("id") Long id) throws Exception{
        RequestAfpModel response = requestAfpService.findById(id);
        log.info("getById" + "OK");
        log.debug(id.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "requestAfp")
    public ResponseEntity<Object> create(@RequestBody RequestAfpModel requestAfpModel) throws Exception {
        RequestAfpModel response = requestAfpService.create(requestAfpModel);
        log.info("create" + "OK");
        log.debug(requestAfpModel.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @PutMapping(path = { "requestAfp/{id}" }, produces = { "application/json" })
    public void update(
            @PathVariable("id") Long id,
            @RequestBody RequestAfpModel requestAfpModel) throws Exception {
        requestAfpService.update(id, requestAfpModel);
        log.info("update" + "OK");
        log.debug(id.toString()+ "/" + requestAfpModel.toString());
    }

    @DeleteMapping({ "requestAfp/{id}" })
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        requestAfpService.deleteById(id);
    }


}
