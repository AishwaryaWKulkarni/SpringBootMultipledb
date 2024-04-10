package com.csi.service;

import com.csi.model.Product;
import com.csi.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepositoryImpl;

    public Product signUp(Product product) {
        return productRepositoryImpl.save(product);
    }

    public Optional<Product> findById(int prodId) {
        return productRepositoryImpl.findById(prodId);
    }

    public List<Product> findAll() {
        return productRepositoryImpl.findAll();
    }

    public Product update(Product product) {
        return productRepositoryImpl.save(product);
    }

    public void deleteById(int prodId) {
        productRepositoryImpl.deleteById(prodId);
    }


}
