package com.devsuperior.desafio;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.desafio.entities.Order;
import com.devsuperior.desafio.services.OrderService;
import com.devsuperior.desafio.services.ShippingService;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ShippingService shippingService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			Order order = readOrder(sc);
			double finalAmount = orderService.total(order) + shippingService.shipment(order);

			System.out.printf("Pedido código: %d\nValor total: R$ %.2f\n", order.getCode(), finalAmount);
		}
	}

	private Order readOrder(Scanner sc) {
		System.out.print("Order code: ");
		int code = sc.nextInt();

		System.out.print("Order basic: ");
		double basic = sc.nextDouble();

		System.out.print("Order discount: ");
		double discount = sc.nextDouble();

		return new Order(code, basic, discount);
	}
}
