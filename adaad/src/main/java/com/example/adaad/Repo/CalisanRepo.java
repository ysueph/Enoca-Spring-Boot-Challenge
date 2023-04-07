package com.example.adaad.Repo;

import com.example.adaad.Entity.Calisan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalisanRepo extends JpaRepository<Calisan, Long> {
    List<Calisan> findAll();
}
