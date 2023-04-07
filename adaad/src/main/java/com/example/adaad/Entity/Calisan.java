package com.example.adaad.Entity;

import jakarta.persistence.*;
import lombok.Data;




@Data
@Entity
@Table(name = "Calisan")
public class Calisan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long CalisanId;
    @Column(name = "ad")
    public String Calisan_ad;
    @Column(name = "soyad")
    public String Calisan_soyad;


}