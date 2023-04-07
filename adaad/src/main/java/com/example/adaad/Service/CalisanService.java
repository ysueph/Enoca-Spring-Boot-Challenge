package com.example.adaad.Service;

import com.example.adaad.Config.MapperConfig;
import com.example.adaad.DTO.CalisanDto;
import com.example.adaad.Entity.Calisan;
import com.example.adaad.Repo.CalisanRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalisanService implements CalisanServiceIN{
@Autowired
     private final CalisanRepo Ccc;
     private final ModelMapper modelMapper;

    //ekleme
    @Override
    public CalisanDto calisanEkle(CalisanDto calisanDto) {

            Calisan calisan = modelMapper.map(calisanDto,Calisan.class);
            return modelMapper.map(Ccc.save(calisan),CalisanDto.class);

    }

    @Override
    public List<CalisanDto> calisanAllGetir() {
        List<Calisan> calisan = Ccc.findAll();
        List<CalisanDto> calisanDto = calisan.stream().map(Calisan->modelMapper.map(Calisan,CalisanDto.class)).collect(Collectors.toList());
        return calisanDto;
    }

    @Override
    public CalisanDto calisanGetir(Long CalisanId) {
        Optional<Calisan> calisan= Ccc.findById(CalisanId);
        CalisanDto calisanDto = modelMapper.map(calisan, CalisanDto.class);
        if(calisan.isPresent()){
            return calisanDto;
        }
        throw new IllegalArgumentException("bulunamadı");
    }

    @Override
    public Calisan calisanGuncelle(Long CalisanId, Calisan calisan) {
        Optional<Calisan> editCalisan= Ccc.findById(CalisanId);
        editCalisan.get().setCalisanId(CalisanId);
        editCalisan.get().setCalisan_ad(calisan.getCalisan_ad());
        editCalisan.get().setCalisan_soyad(calisan.getCalisan_soyad());
        return editCalisan.orElseThrow(()-> new IllegalArgumentException("bulunamadı"));
    }

    @Override
    public Calisan calisanSil(Long CalisanId) {
        Optional<Calisan> calisan= Ccc.findById(CalisanId);
        Ccc.deleteById(CalisanId);
        return calisan.orElseThrow(()-> new IllegalArgumentException("bulunamadı"));
    }
}
