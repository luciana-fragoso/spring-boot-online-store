package com.demo.OnlineStore.Service;
import com.demo.OnlineStore.Controller.Dto.OrderDto;
import com.demo.OnlineStore.Model.Order;
import com.demo.OnlineStore.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;


    public void save(OrderDto orderDto){

        orderRepository.save(new Order(orderDto.getId(),orderDto.getClient(),orderDto.getItem()));
    }
}
