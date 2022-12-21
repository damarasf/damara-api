package com.damaraapi.controller;

import com.damaraapi.dto.MerchantDTO;
import com.damaraapi.models.Merchant;
import com.damaraapi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @PostMapping("/create")
    public MerchantDTO create(@RequestBody MerchantDTO request) {
        final Merchant merchant = merchantService.mapToEntity(request);
        final Merchant result = merchantService.create(merchant);
        return merchantService.mapToDTO(result);
    }

    @PutMapping("/update/{id}")
    public  MerchantDTO update(@PathVariable Long id, @RequestBody MerchantDTO request) {
        final Merchant merchant = merchantService.mapToEntity(request);
        final Merchant result = merchantService.update(id, merchant);
        return merchantService.mapToDTO(result);
    }

    @GetMapping("/all")
    public List<MerchantDTO> findAll() {
        return merchantService.findAll().stream().map(merchant -> merchantService.mapToDTO(merchant))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id) {
        return merchantService.delete(id);
    }
}
