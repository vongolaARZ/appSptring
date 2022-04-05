package com.appmarket.persistence.entity;

import com.appmarket.domain.dto.Product;
import com.appmarket.domain.repository.ProductRepository;
import com.appmarket.persistence.crud.ProductoCrudRespoitory;
import com.appmarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRespoitory productoCrudRespoitory;

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRespoitory.findAll();
        return productMapper.toProducts(productos);
    }
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {List<Producto> productos = productoCrudRespoitory.findByIdCategoriaOrderByNombreAsc(categoryId);return Optional.of(productMapper.toProducts(productos));}

    @Override
    public Optional<List<Product>> getScaseProducts(int quantity) {Optional<List<Producto>> productos = productoCrudRespoitory.findByCantidadStockLessThanAndEstado(quantity,true);return productos.map(prods -> productMapper.toProducts(prods));}

    @Override
    public Optional<Product> getProduct(int productId) {return productoCrudRespoitory.findById(productId).map(producto -> productMapper.toProduct(producto));}

    @Override
    public Product save(Product product) {Producto producto = productMapper.toProducto(product);return productMapper.toProduct(producto);}

    @Override
    public void delete( int idProducto){productoCrudRespoitory.deleteById(idProducto);}

    public Optional<Producto> getById(int idProducto){return productoCrudRespoitory.findById(idProducto);}






}
