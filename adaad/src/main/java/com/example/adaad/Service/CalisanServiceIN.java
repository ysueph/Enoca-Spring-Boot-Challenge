package com.example.adaad.Service;

import com.example.adaad.DTO.CalisanDto;
import com.example.adaad.Entity.Calisan;

import java.util.List;

public interface CalisanServiceIN {
    CalisanDto calisanEkle(CalisanDto calisan);
    List<CalisanDto> calisanAllGetir();
    CalisanDto calisanGetir(Long CalisanId);
    Calisan calisanGuncelle(Long CalisanId, Calisan calisan);
    Calisan calisanSil(Long CalisanId);
}
