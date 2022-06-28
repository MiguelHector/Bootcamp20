package com.bootcampfinish.afp.model;

import com.bootcampfinish.afp.repositorie.domain.Afp;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {
    @JsonProperty("clientId")
    @Builder.Default
    private Long id = null;

    @Builder.Default
    private String name = null;

    @Builder.Default
    private String lastname = null;

    @Builder.Default
    private  String dni= null;

    @Builder.Default
    private  String telephone= null;

    @Builder.Default
    private  String email= null;

    @Builder.Default
    private Afp afp= null;

    @Builder.Default
    private  String accountNumber= null;

    private  Double amount= null;
}
