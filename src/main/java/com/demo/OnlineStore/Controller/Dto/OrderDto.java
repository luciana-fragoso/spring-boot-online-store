package com.demo.OnlineStore.Controller.Dto;


import com.demo.OnlineStore.Model.Client;

import com.demo.OnlineStore.Model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private Client client;
    private List<OrderItem> item;
}
