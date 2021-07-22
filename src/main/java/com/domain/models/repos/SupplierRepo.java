package com.domain.models.repos;

import java.util.List;

import com.domain.models.entities.Supplier;

import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<Supplier, Long> {

    public Supplier findByEmail(String email);

    public List<Supplier> findByNameContains(String name);

    public List<Supplier> findByNameStartingWith(String prefix);

}
