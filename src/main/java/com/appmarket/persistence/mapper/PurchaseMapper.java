package com.appmarket.persistence.mapper;


import com.appmarket.domain.Purchase;
import com.appmarket.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings(
            {       @Mapping(source = "idCompra", target = "purchaeId"),
                    @Mapping(source = "idCliente", target = "clientId"),
                    @Mapping(source = "fecha", target = "date"),
                    @Mapping(source = "medioPago", target = "paymentMethod"),
                    @Mapping(source = "comentario", target = "coment"),
                    @Mapping(source = "estado", target = "state"),
                    @Mapping(source = "compras", target = "item")
            }
    )
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchases(List<Compra> compras);



    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra (Purchase purchase);

}
