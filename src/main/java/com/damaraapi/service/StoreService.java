package com.damaraapi.service;

import com.damaraapi.dto.StoreDTO;
import com.damaraapi.models.Store;

public interface StoreService {

    Store addStore(Long merchantId, Store store);
    Store mapToEntity(StoreDTO storeDTO);
    StoreDTO mapToDTO(Store store);
}
