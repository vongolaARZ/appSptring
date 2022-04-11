package com.appmarket.persistence.entity;

import com.appmarket.domain.dto.Purchase;
import com.appmarket.domain.repository.PurchaseRepository;
import com.appmarket.persistence.crud.CompraCrudRepository;

import com.appmarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;




    @Override
    public List<Purchase> getAll() {
        return purchaseMapper.toPurchases(compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> purchaseMapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {

        Compra compra = purchaseMapper.toCompra(purchase);
        compra.getCompras().forEach(comprasProducto -> comprasProducto.setCompra(compra));


        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));

    }
}
