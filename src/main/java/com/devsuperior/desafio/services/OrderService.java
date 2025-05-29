package com.devsuperior.desafio.services;

import org.springframework.stereotype.Service;

import com.devsuperior.desafio.entities.Order;

@Service
public class OrderService {

    public double total(Order order){

        return  order.getBasic() - (order.getBasic() * order.getDiscount() / 100.0);
    }
    
}
