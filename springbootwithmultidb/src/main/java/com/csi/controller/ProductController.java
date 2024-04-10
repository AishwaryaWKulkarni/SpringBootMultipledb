package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Product;
import com.csi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/signUp")
    public ResponseEntity<Product> signUp(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(productServiceImpl.signUp(product), HttpStatus.CREATED);
    }

    @GetMapping("/findById")
    public ResponseEntity<Optional<Product>> findById(@RequestParam int prodId) {
        return ResponseEntity.ok(productServiceImpl.findById(prodId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productServiceImpl.findAll());
    }

    @PutMapping("/update/{prodId}")
    public ResponseEntity<Product> update(@PathVariable int prodId, @Valid @RequestBody Product product) {

        Product product1 = productServiceImpl.findById(prodId).orElseThrow(() -> new RecordNotFoundException("Product ID does not exist"));

        product1.setProdName(product.getProdName());
        product1.setProdPrice(product.getProdPrice());
        product1.setProdLaunchDate(product.getProdLaunchDate());

        return new ResponseEntity<>(productServiceImpl.update(product1), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteById(@RequestParam int prodId) {
        productServiceImpl.deleteById(prodId);

        return ResponseEntity.ok("Data Deleted Successsfully");
    }
}
