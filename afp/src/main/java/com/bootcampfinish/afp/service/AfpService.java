package com.bootcampfinish.afp.service;

import com.bootcampfinish.afp.mapper.AfpMapper;
import com.bootcampfinish.afp.model.AfpModel;
import com.bootcampfinish.afp.repositorie.AfpRepository;

import com.bootcampfinish.afp.repositorie.domain.Afp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AfpService implements  IAfpService {

    private final AfpRepository afpRepository;
    private final AfpMapper afpMapper;

    @Override
    public List<AfpModel> findAll() throws Exception{
        List<Afp> afps= afpRepository.findAll();
        return afpMapper.afpsToAfpModels(afps);
    }

    @Override
    public AfpModel findById(Long id) throws Exception {
        Optional<Afp> afp = afpRepository.findById(id);
        if(afp.isPresent()) return afpMapper.afpToAfpModel(afp.get());
        else throw new Exception("No se encontrarón datos") ;
    }

    @Override
    public AfpModel create(AfpModel afpModel) throws Exception {
        Afp afp =afpMapper.afpModelToAfp(afpModel);
        Afp afpCreated= afpRepository.save(afp);
        return afpMapper.afpToAfpModel(afpCreated);
    }

    @Override
    public void update(Long id, AfpModel afpModel) throws Exception {
        Optional<Afp> afp = afpRepository.findById(id);
        if(afp.isPresent())
        {
            Afp afpToUpdate = afp.get();
            afpMapper.update(afpToUpdate, afpModel);
           afpRepository.save(afpToUpdate);
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        afpRepository.deleteById(id);
    }


}
