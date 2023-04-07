package com.example.adaad.Controller;

import com.example.adaad.DTO.CalisanDto;
import com.example.adaad.Entity.Calisan;

import com.example.adaad.Service.CalisanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CalisanControll {
    @Autowired
    private final CalisanService calisanService;
    @PostMapping("/Calisan")
    public ResponseEntity<CalisanDto> CalisanEkle(@RequestBody CalisanDto calisan){
        CalisanDto resultCalisan = calisanService.calisanEkle(calisan);
        return ResponseEntity.ok(calisan);
    }

    @GetMapping("/CalisanAll")
    public ResponseEntity<List<CalisanDto>> CalisanAllGetir(){
        List<CalisanDto> calisan = calisanService.calisanAllGetir();
        return ResponseEntity.ok(calisan);
    }

    @GetMapping("/CalisanByID/{CalisanId}")
    public ResponseEntity<CalisanDto> CalisanGetir(@PathVariable("CalisanId") Long CalisanId){
        CalisanDto calisan = calisanService.calisanGetir(CalisanId);
        return ResponseEntity.ok(calisan);
    }

    @PutMapping("CalisanGuncelle/{CalisanId}")
    public ResponseEntity<Calisan> CalisanGuncelle(@PathVariable("CalisanId") Long CalisanId,@RequestBody Calisan calisan){
        Calisan editCalisan = calisanService.calisanGuncelle(CalisanId,calisan);
        return ResponseEntity.ok(editCalisan);
    }

    @DeleteMapping("CalisanSil/{CalisanId}")
    public ResponseEntity<Calisan> CalisanSil(@PathVariable("CalisanId") Long CalisanId){
        Calisan deleteCalisan = calisanService.calisanSil(CalisanId);
        return ResponseEntity.ok(deleteCalisan);
    }

}
