package com.damaraapi.service;

import com.damaraapi.dto.MerchantDTO;
import com.damaraapi.models.Merchant;

import java.util.List;

public interface MerchantService {
    Merchant create(Merchant merchant);
    Merchant update(Long id, Merchant merchant);
    Boolean delete(Long id);
    List<Merchant> findAll();
    Merchant findById(Long id);

    MerchantDTO mapToDTO(Merchant merchant);
    Merchant mapToEntity(MerchantDTO merchantDTO);
}
