package com.bootcampfinish.afp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AfpModel {
    @JsonProperty("afpId")
    @Builder.Default
    private Long id= null;

    private String name= null;
}
