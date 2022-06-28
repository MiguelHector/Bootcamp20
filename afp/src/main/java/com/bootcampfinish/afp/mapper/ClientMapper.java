package com.bootcampfinish.afp.mapper;

import com.bootcampfinish.afp.model.ClientModel;
import com.bootcampfinish.afp.repositorie.domain.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client clientModelToClient (ClientModel model);
    ClientModel clientToClientModel (Client client);
    List<ClientModel> clientsToClientModels(List<Client> clients);
    void update(@MappingTarget Client entity, ClientModel updateEntity);
}
