package com.demo.OnlineStore.Controller;

import com.demo.OnlineStore.Controller.Dto.OrderDto;
import com.demo.OnlineStore.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/store/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PutMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody OrderDto orderDto){
        orderService.save(orderDto);
    }
}
