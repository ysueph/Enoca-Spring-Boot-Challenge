package com.example.adaad.Service;


import com.example.adaad.DTO.SirketDto;
import com.example.adaad.Entity.Sirket;

import java.util.List;

public interface SirketServiceIN {
    SirketDto sirketEkle(SirketDto sirket);
    List<SirketDto> sirketAllGetir();
    SirketDto sirketGetir(Long Id);
    Sirket sirketGuncelle(Long Id, Sirket sirket);
    Sirket sirketSil(Long Id);
}
