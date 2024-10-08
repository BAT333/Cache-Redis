package com.cache.demo.controller;

import com.cache.demo.model.DataEmpresa;
import com.cache.demo.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpresaController {
    @Autowired
    private EmpresaService service;

    @GetMapping
    @Cacheable(value = "empresas")
    public ResponseEntity<List<DataEmpresa>> allEmpresa (){
        return ResponseEntity.ok(service.all());
    }
    @GetMapping("/add")
    public void addempresa (){
        this.service.add();
    }
}
