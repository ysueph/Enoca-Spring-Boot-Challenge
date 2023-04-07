package com.example.adaad.Controller;

import com.example.adaad.DTO.SirketDto;
import com.example.adaad.Entity.Sirket;
import com.example.adaad.Service.SirketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SirketControll {
    private final SirketService sirketService;

    @PostMapping("/Sirket")
    public ResponseEntity<SirketDto> SirketEkle(@RequestBody SirketDto sirket){
        SirketDto resultsirket = sirketService.sirketEkle(sirket);
        return ResponseEntity.ok(sirket);
    }

    @GetMapping("/SirketAll")
    public ResponseEntity<List<SirketDto>> SirketAllGetir(){
        List<SirketDto> sirket = sirketService.sirketAllGetir();
        return ResponseEntity.ok(sirket);
    }

    @GetMapping("/SirketByID/{Id}")
    public ResponseEntity<SirketDto> SirketGetir(@PathVariable("Id") Long Id){
        SirketDto sirket = sirketService.sirketGetir(Id);
        return ResponseEntity.ok(sirket);
    }

    @PutMapping("SirketGuncelle/{Id}")
    public ResponseEntity<Sirket> SirketGuncelle(@PathVariable("Id") Long Id,@RequestBody Sirket sirket){
        Sirket editSirket = sirketService.sirketGuncelle(Id,sirket);
        return ResponseEntity.ok(editSirket);
    }

    @DeleteMapping("SirketSil/{Id}")
    public ResponseEntity<Sirket> SirketSil(@PathVariable("Id") Long Id){
        Sirket deleteSirket = sirketService.sirketSil(Id);
        return ResponseEntity.ok(deleteSirket);
    }

}