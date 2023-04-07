package com.example.adaad.Entity;

import jakarta.persistence.*;
import lombok.*;




@Data
@Entity
@Table(name = "Sirket")
public class Sirket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    @Column(name = "ad")
    public String Sirket_ad;


}