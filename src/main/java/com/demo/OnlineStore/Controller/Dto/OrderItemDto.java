package com.demo.OnlineStore.Controller.Dto;

import com.demo.OnlineStore.Model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private Long id;
    private Item item;
    private int quantity;
}
