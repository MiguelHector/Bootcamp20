package com.bootcampfinish.afp.service;

import com.bootcampfinish.afp.mapper.ClientMapper;
import com.bootcampfinish.afp.model.ClientModel;
import com.bootcampfinish.afp.repositorie.ClientRepository;
import com.bootcampfinish.afp.repositorie.domain.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService implements  IClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientModel> findAll() throws Exception{
        List<Client> clients= clientRepository.findAll();
        return clientMapper.clientsToClientModels(clients);
    }

    @Override
    public ClientModel findById(Long id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()) return clientMapper.clientToClientModel(client.get());
        else throw new Exception("No se encontrarón datos") ;
    }

    @Override
    public ClientModel create(ClientModel clientModel) throws Exception {
        Client client =clientMapper.clientModelToClient(clientModel);
        Client clientCreated= clientRepository.save(client);
        return clientMapper.clientToClientModel(clientCreated);
    }

    @Override
    public void update(Long id, ClientModel clientModel) throws Exception {
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent())
        {
            Client clientToUpdate = client.get();
            clientMapper.update(clientToUpdate, clientModel);
            clientRepository.save(clientToUpdate);
        }
    }

    @Override
    public void deleteById(Long id) throws Exception {
        clientRepository.deleteById(id);
    }
}
