package com.bootcampfinish.afp.controller;

import com.bootcampfinish.afp.model.AfpModel;
import com.bootcampfinish.afp.service.IAfpService;
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
public class AfpController {

    private final IAfpService afpService;

    @GetMapping(path = { "afp" }, produces = { "application/json" })
    public ResponseEntity<Object> getAll() throws Exception {
        List<AfpModel> response =  afpService.findAll();
        log.info("getAll" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = { "afp/{id}" }, produces = { "application/json" })
    public ResponseEntity<AfpModel> getById(@PathVariable("id") Long id) throws Exception{
        AfpModel response = afpService.findById(id);
        log.info("getById" + "OK");
        log.debug(id.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(path = "afp")
    public ResponseEntity<Object> create(@RequestBody AfpModel afpModel) throws Exception {
        AfpModel response = afpService.create(afpModel);
        log.info("create" + "OK");
        log.debug(afpModel.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = { "afp/{id}" }, produces = { "application/json" })
    public void update(
            @PathVariable("id") Long id,
            @RequestBody AfpModel afpModel) throws Exception {
        afpService.update(id, afpModel);
        log.info("update" + "OK");
        log.debug(id.toString()+ "/" + afpModel.toString());
    }

    @DeleteMapping({ "afp/{id}" })
    public void deleteById(@PathVariable("id") Long id) throws Exception {
        afpService.deleteById(id);
    }



}
