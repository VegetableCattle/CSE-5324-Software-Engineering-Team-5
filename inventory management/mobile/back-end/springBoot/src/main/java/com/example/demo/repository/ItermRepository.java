package com.example.demo.repository;

import com.example.demo.entity.Iterm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItermRepository extends JpaRepository<Iterm,Integer> {
    List<Iterm> findAllByWarehouseAndCategory(String warehouse,String category);
    List<Iterm> findAllByWarehouse(String warehouse);
    List<Iterm> findAllByCategory(String category);
    List<Iterm> findAllByModel(String model);
    Iterm findItermByWarehouseAndModelAndBrandAndCategory(String warehouse,String model,String brand,String category);
}
