package com.bootcampfinish.afp.repositorie;

import com.bootcampfinish.afp.model.ClientModel;
import com.bootcampfinish.afp.repositorie.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    /*List<Client> findByName(String name);*/
    ClientModel findByDni(String dni);
}
