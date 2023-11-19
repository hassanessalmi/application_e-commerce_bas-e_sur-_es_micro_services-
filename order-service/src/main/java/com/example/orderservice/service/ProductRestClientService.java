package com.example.orderservice.service;

import com.example.orderservice.model.Customer;
import com.example.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClientService {
    @GetMapping("/products/{id}?projection=fullProduct")
    public Product productById(@PathVariable Long id);
@GetMapping("/products?projection=fullProduct")
    public PagedModel<Product> allProducts();
}
