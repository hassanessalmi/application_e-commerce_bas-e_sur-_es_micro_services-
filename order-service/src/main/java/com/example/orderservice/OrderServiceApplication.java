package com.example.orderservice;

import com.example.orderservice.entities.Order;
import com.example.orderservice.entities.ProductItem;
import com.example.orderservice.enums.OderStatus;
import com.example.orderservice.model.Customer;
import com.example.orderservice.model.Product;
import com.example.orderservice.repo.OrderRepository;
import com.example.orderservice.repo.ProductItemRepository;
import com.example.orderservice.service.CustomerRestClientService;
import com.example.orderservice.service.ProductRestClientService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
@Bean
	CommandLineRunner start(
			OrderRepository orderRepository,
			ProductItemRepository productItemRepository,
CustomerRestClientService customerRestClientService,
ProductRestClientService productRestClientService
){
		return args -> {
			List<Customer>customers= customerRestClientService.allCustomers().getContent().stream().toList();
				List<Product> products=productRestClientService.allProducts().getContent().stream().toList();
				Long customerId=1L;
			Random random=new Random();
Customer customer=customerRestClientService.customerById(customerId);
			for (int i = 0; i < 20; i++) {
				Order order=Order.builder()
						.customerId(customers.get(random.nextInt(customers.size())).getId())
						.status(Math.random()>0.5?OderStatus.CREATED:OderStatus.PENDING)
						.createdAt(new Date())
						.build();
			Order ordersave=orderRepository.save(order);

				for (int j = 0; j <products.size() ; j++) {
					if (Math.random()>0.70) {
						ProductItem productItem=ProductItem.builder()
								.order(ordersave)
								.productId(products.get(j).getId())
								.price(products.get(j).getPrice())
								.quantity(1+ random.nextInt(10))
								.discount(Math.random())
								.build();
						productItemRepository.save(productItem);
					}

				}
			}
		};
}

}
