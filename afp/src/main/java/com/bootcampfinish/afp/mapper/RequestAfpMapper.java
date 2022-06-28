package com.bootcampfinish.afp.mapper;

import com.bootcampfinish.afp.model.RequestAfpModel;
import com.bootcampfinish.afp.repositorie.domain.RequestAfp;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestAfpMapper {
    RequestAfp requestAfpModelToRequestAfp (RequestAfpModel model);
    RequestAfpModel requestAfpToRequestAfpModel (RequestAfp requestAfp);
    List<RequestAfpModel> requestAfpsToRequestAfpModels(List<RequestAfp> requestAfps);
    void update(@MappingTarget RequestAfp entity, RequestAfpModel updateEntity);
}
