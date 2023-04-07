package com.example.adaad.Repo;

import com.example.adaad.Entity.Sirket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SirketRepo extends JpaRepository<Sirket, Long> {
    List<Sirket> findAll();
}