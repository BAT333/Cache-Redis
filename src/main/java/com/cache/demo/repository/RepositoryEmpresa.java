package com.cache.demo.repository;

import com.cache.demo.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmpresa extends JpaRepository<Empresa, Long> {
}
