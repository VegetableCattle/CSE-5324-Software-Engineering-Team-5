package com.example.demo.repository;

import com.example.demo.entity.Details;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailsRepository extends JpaRepository<Details,Integer> {
    List<Details> findAllByModel(String model);
}
