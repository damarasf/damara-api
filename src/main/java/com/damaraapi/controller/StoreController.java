package com.damaraapi.controller;

import com.damaraapi.dto.StoreDTO;
import com.damaraapi.models.Store;
import com.damaraapi.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping("/add/{merchantId}")
    public StoreDTO addStoreToMerchant(@PathVariable Long merchantId, @RequestBody StoreDTO request) {
        final Store store = storeService.mapToEntity(request);
        final Store result = storeService.addStore(merchantId, store);
        return storeService.mapToDTO(result);
    }
}
