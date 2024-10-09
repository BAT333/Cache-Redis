package com.cache.demo.service;

import com.cache.demo.domain.Empresa;
import com.cache.demo.model.DataEmpresa;
import com.cache.demo.repository.RepositoryEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {
    @Autowired
    private RepositoryEmpresa empresa;

    public List<DataEmpresa> all() {
        return empresa.findAll().stream().map(DataEmpresa::new).collect(Collectors.toList());
    }

    public void add() {
        for (int i =0;i<=300000;i++){
            empresa.save(new Empresa(Integer.toUnsignedLong(i),"a"+i));
        }
    }

    public DataEmpresa update(Long id) {
        var e =  this.empresa.findById(id);
        return e.map(DataEmpresa::new).get();
    }
}
