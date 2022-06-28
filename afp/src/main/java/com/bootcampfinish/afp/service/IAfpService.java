package com.bootcampfinish.afp.service;

import com.bootcampfinish.afp.model.AfpModel;

import java.util.List;

public interface IAfpService {
    List<AfpModel> findAll() throws Exception;
    AfpModel findById (Long id) throws Exception;
    AfpModel create (AfpModel afpModel) throws Exception;
    void update(Long id, AfpModel afpModel) throws Exception;
    void deleteById(Long id) throws Exception;
}
