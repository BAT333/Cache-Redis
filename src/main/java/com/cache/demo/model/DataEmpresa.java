package com.cache.demo.model;

import com.cache.demo.domain.Empresa;

public record DataEmpresa(
        Long id,
        String name
) {
    public DataEmpresa(Empresa empresa){
        this(empresa.getId(), empresa.getNome());
    }

}
