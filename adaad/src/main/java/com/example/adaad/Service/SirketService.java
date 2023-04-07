package com.example.adaad.Service;

import com.example.adaad.DTO.CalisanDto;
import com.example.adaad.DTO.SirketDto;
import com.example.adaad.Entity.Calisan;
import com.example.adaad.Entity.Sirket;
import com.example.adaad.Repo.CalisanRepo;
import com.example.adaad.Repo.SirketRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SirketService implements SirketServiceIN{
    @Autowired
    private final SirketRepo Sss;
    private final ModelMapper modelMapper;

    //ekleme
    @Override
    public SirketDto sirketEkle(SirketDto sirketDto) {
        Sirket sirket = modelMapper.map(sirketDto,Sirket.class);
        return modelMapper.map(Sss.save(sirket),SirketDto.class); }

    @Override
    public List<SirketDto> sirketAllGetir() {
        List<Sirket> sirket = Sss.findAll();
        List<SirketDto> sirketDto = sirket.stream().map(Sirket->modelMapper.map(Sirket,SirketDto.class)).collect(Collectors.toList());
        return sirketDto;
    }

    @Override
    public SirketDto sirketGetir(Long Id) {
        Optional<Sirket> sirket= Sss.findById(Id);
        SirketDto sirketDto = modelMapper.map(sirket, SirketDto.class);
        if(sirket.isPresent()){
            return sirketDto;
        }
        throw new IllegalArgumentException("bulunamadı");
    }

    @Override
    public Sirket sirketGuncelle(Long Id, Sirket sirket) {
        Optional<Sirket> editSirket= Sss.findById(Id);
        editSirket.get().setId(Id);
        editSirket.get().setSirket_ad(sirket.getSirket_ad());
        return editSirket.orElseThrow(()-> new IllegalArgumentException("bulunamadı"));
    }

    @Override
    public Sirket sirketSil(Long Id) {
        Optional<Sirket> sirket= Sss.findById(Id);
        Sss.deleteById(Id);
        return sirket.orElseThrow(()-> new IllegalArgumentException("bulunamadı"));
    }
}