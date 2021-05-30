package com.demo.OnlineStore.Controller;



import com.demo.OnlineStore.Controller.Dto.OrderItemDto;
import com.demo.OnlineStore.Model.OrderItem;
import com.demo.OnlineStore.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store/orderitem")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;

    @PutMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody OrderItemDto orderItemDto){
        orderItemService.save(orderItemDto);
    }


    @GetMapping("/list")
    public ResponseEntity<List<OrderItemDto>> list() {
        return ResponseEntity.ok(orderItemService.list());
    }
}
