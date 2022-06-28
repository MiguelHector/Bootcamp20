package com.bootcampfinish.afp.mapper;

import com.bootcampfinish.afp.model.AfpModel;
import com.bootcampfinish.afp.repositorie.domain.Afp;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AfpMapper {
    Afp afpModelToAfp (AfpModel model);
    AfpModel afpToAfpModel (Afp afp);
    List<AfpModel> afpsToAfpModels(List<Afp> afps);
    void update(@MappingTarget Afp entity, AfpModel updateEntity);
}
