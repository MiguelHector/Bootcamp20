package com.bootcampfinish.afp.service.impl;

import com.bootcampfinish.afp.service.CalculeCantidadRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CalculaCantidadRequestTest {
    @Mock
    CalculeCantidadRequest calculeCantidadRequest;


    @InjectMocks
    CalculaCantidadRequest calculaCantidadRequest;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        when(calculeCantidadRequest.calcularCantidadRequest()).thenReturn(5);
    }

    @Test
    void CantidadRequestPrima(){
        Assertions.assertEquals(5,calculaCantidadRequest.CantidadRequestPrima());
    }

}