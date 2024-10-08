package com.cache.demo.model;

import com.cache.demo.domain.Empresa;

import java.io.Serializable;

public record DataEmpresa(
        Long id,
        String name
)implements Serializable {
    public DataEmpresa(Empresa empresa){
        this(empresa.getId(), empresa.getNome());
    }

}
