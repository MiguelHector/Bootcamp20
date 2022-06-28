package com.bootcampfinish.afp.model;

import com.bootcampfinish.afp.repositorie.domain.Afp;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestAfpModel {

    @JsonProperty("requestAfpId")
    @Builder.Default
    private Long id = null;

    @Builder.Default
    private Timestamp dateRetirement = null;

    @Builder.Default
    private Afp afp=null;

    @Builder.Default
    private String dni = null;

    @Builder.Default
    private Double amount= null;
}