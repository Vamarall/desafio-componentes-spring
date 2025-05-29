package com.devsuperior.desafio.services;

import org.springframework.stereotype.Service;

import com.devsuperior.desafio.entities.Order;

@Service
public class ShippingService {

    public double shipment(Order order) {
        double basic = order.getBasic();
    
        if (basic < 100.0) {
            return 20.0;
        } else if (basic <= 200.0) {
            return 12.0;
        } else {
            return 0.0;
        }
    }
    

}
