package com.bootcampfinish.afp.repositorie.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;

    private  String lastname;

    private  String dni;

    private  String telephone;

    private  String email;

    private  String accountNumber;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private  Afp afp;

    private  Double amount;
}
