package com.bootcampfinish.afp.service;

import com.bootcampfinish.afp.mapper.ClientMapper;
import com.bootcampfinish.afp.mapper.RequestAfpMapper;
import com.bootcampfinish.afp.model.ClientModel;
import com.bootcampfinish.afp.model.RequestAfpModel;
import com.bootcampfinish.afp.repositorie.ClientRepository;
import com.bootcampfinish.afp.repositorie.RequestAfpRepository;
import com.bootcampfinish.afp.repositorie.domain.Client;
import com.bootcampfinish.afp.repositorie.domain.RequestAfp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestAfpService implements  IRequestAfpService {

    private final RequestAfpRepository requestAfpRepository;
    private final RequestAfpMapper requestAfpMapper;

    private  final ClientRepository clientRepository;
    private  final ClientMapper clientMapper;

    @Override
    public List<RequestAfpModel> findAll() throws Exception{
        List<RequestAfp> requestAfps= requestAfpRepository.findAll();
        return requestAfpMapper.requestAfpsToRequestAfpModels(requestAfps);
    }

    @Override
    public RequestAfpModel findById(Long id) throws Exception {
        Optional<RequestAfp> requestAfp = requestAfpRepository.findById(id);
        if(requestAfp.isPresent()) return requestAfpMapper.requestAfpToRequestAfpModel(requestAfp.get());
        else throw new Exception("No se encontrarón datos") ;
    }

    @Override
    public RequestAfpModel create(RequestAfpModel requestAfpModel) throws Exception {

        ClientModel client = clientRepository.findByDni(requestAfpModel.getDni());

        if (client.getAmount()< requestAfpModel.getAmount())
        {
            throw new Exception("No se puede registrar la solicitud. Monto mayor que lo permitido");
        }
        else if (requestAfpModel.getAmount() < client.getAmount() * 0.5)
        {
            throw new Exception("Monto mínimo no cubierto. Por favor revise el monto mínimo a retirar");
        }
        else
        {
            RequestAfp requestAfp =requestAfpMapper.requestAfpModelToRequestAfp(requestAfpModel);
            RequestAfp requestAfpCreated= requestAfpRepository.save(requestAfp);
            return requestAfpMapper.requestAfpToRequestAfpModel(requestAfpCreated);
        }
    }

    @Override
    public void update(Long id, RequestAfpModel requestAfpModel) throws Exception {
        Optional<RequestAfp> requestAfp = requestAfpRepository.findById(id);
        if(requestAfp.isPresent())
        {
            RequestAfp requestAfpToUpdate = requestAfp.get();
            requestAfpMapper.update(requestAfpToUpdate, requestAfpModel);
            requestAfpRepository.save(requestAfpToUpdate);
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        requestAfpRepository.deleteById(id);
    }

}
