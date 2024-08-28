package com.innspark.postgresql_based.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innspark.postgresql_based.entity.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{

}
