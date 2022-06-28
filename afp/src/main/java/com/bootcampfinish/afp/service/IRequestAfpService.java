package com.bootcampfinish.afp.service;

import com.bootcampfinish.afp.model.RequestAfpModel;
import com.bootcampfinish.afp.repositorie.domain.RequestAfp;

import java.util.List;

public interface IRequestAfpService {

    List<RequestAfpModel> findAll() throws Exception;
    RequestAfpModel findById (Long id) throws Exception;
    RequestAfpModel create (RequestAfpModel requestAfpModel) throws Exception;
    void update(Long id, RequestAfpModel requestAfpModel) throws Exception;
    void deleteById(Long id) throws Exception;

}
