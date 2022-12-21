package com.damaraapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class MerchantDTO {
    private Long id;
    private String name;

    private List<StoreDTO> store;
}
