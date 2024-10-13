package com.cache.demo.service;

import com.cache.demo.domain.Empresa;
import com.cache.demo.model.DataEmpresa;
import com.cache.demo.repository.RepositoryEmpresa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmpresaService {
    @Autowired
    private RepositoryEmpresa empresa;

    public List<DataEmpresa> all() {
        log.info("FAZENDO PESQUISA SEM CACHE");
        return empresa.findAll().stream().map(DataEmpresa::new).collect(Collectors.toList());
    }

    public void add() {
        log.info("ADD MAIS EMPRESA");
    }

    public DataEmpresa update(Long id) {
        log.info("ATUALIZANDO");
        var e =  this.empresa.findById(id);
        return e.map(DataEmpresa::new).get();
    }
}
