package com.appmarket.domain.repository;

import com.appmarket.domain.dto.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getAll();
    Optional <List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);



}
