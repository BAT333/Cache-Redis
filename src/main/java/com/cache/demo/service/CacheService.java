package com.cache.demo.service;

import com.cache.demo.domain.Empresa;
import com.cache.demo.model.DataEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CacheService {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private EmpresaService empresaService;

    public void evictAllCacheValues(String cacheName) {
        Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
    }

    @CachePut(value = "empresas", unless = "#result.size() <= 10000")
    public List<DataEmpresa> atualizarCacheEmpresas() {
        return empresaService.all();
    }
}
