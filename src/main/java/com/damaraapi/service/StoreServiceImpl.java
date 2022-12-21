package com.damaraapi.service;

import com.damaraapi.dto.StoreDTO;
import com.damaraapi.models.Merchant;
import com.damaraapi.models.Store;
import com.damaraapi.repository.StoreRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{

ObjectMapper mapper = new ObjectMapper();

@Autowired
MerchantService merchantService;

@Autowired
StoreRepository storeRepository;

    @Override
    public Store addStore(Long merchantId, Store store) {
        final Merchant merchant = merchantService.findById(merchantId);
        if (merchant != null) {
            store = storeRepository.save(store);
            if (merchant.getStores() == null) {
                final List<Store> stores = merchant.getStores();
                stores.add(store);
                merchant.setStores(stores);
            } else {
                merchant.setStores(Collections.singletonList(store));
            }
            merchantService.create(merchant);
            return store;
        }
        return null;
    }

    @Override
    public Store mapToEntity(StoreDTO storeDTO) {
        return mapper.convertValue(storeDTO, Store.class);
    }

    @Override
    public StoreDTO mapToDTO(Store store) {
        return mapper.convertValue(store, StoreDTO.class);
    }
}
