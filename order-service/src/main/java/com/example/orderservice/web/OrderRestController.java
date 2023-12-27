package com.example.orderservice.web;

import com.example.orderservice.entities.Order;
import com.example.orderservice.model.Customer;
import com.example.orderservice.model.Product;
import com.example.orderservice.repo.OrderRepository;
import com.example.orderservice.repo.ProductItemRepository;
import com.example.orderservice.service.CustomerRestClientService;
import com.example.orderservice.service.ProductRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController

public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private ProductRestClientService productRestClientService;


    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, CustomerRestClientService customerRestClientService, ProductRestClientService productRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.productRestClientService = productRestClientService;
    }
    @GetMapping("/fullOrder/{id}")
       public Order getOrder(@PathVariable Long id){

      Order order=orderRepository.findById(id).get();

          Customer customer = customerRestClientService.customerById(order.getCustomerId());
          order.setCustomer(customer);
          order.getProductItem().forEach(pi -> {
              Product product = productRestClientService.productById(pi.getProductId());
              pi.setProduct(product);
          });
          return order;

    }

}
