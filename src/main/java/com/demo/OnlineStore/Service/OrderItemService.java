package com.demo.OnlineStore.Service;

import com.demo.OnlineStore.Controller.Dto.ItemDto;
import com.demo.OnlineStore.Controller.Dto.OrderItemDto;
import com.demo.OnlineStore.Model.Item;
import com.demo.OnlineStore.Model.OrderItem;
import com.demo.OnlineStore.Repository.OrderItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    public void save(OrderItemDto orderItemDto) {
        orderItemRepository.save(new OrderItem(orderItemDto.getId(),orderItemDto.getItem(),orderItemDto.getQuantity()));
    }


    private static List<OrderItemDto> itemMapper(List<OrderItem> list){

        return list.parallelStream().map(a-> new ModelMapper().map(a,OrderItemDto.class))
                .collect(Collectors.toList());

    }

    public List<OrderItemDto> list() {
        List<OrderItem> list = orderItemRepository.findAll();
        return itemMapper(list);
    }
}
