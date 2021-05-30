package com.demo.OnlineStore.Service;


import com.demo.OnlineStore.Controller.Dto.ClientDto;
import com.demo.OnlineStore.Controller.Dto.ItemDto;
import com.demo.OnlineStore.Exception.NotFoundException;
import com.demo.OnlineStore.Model.Item;
import com.demo.OnlineStore.Repository.ItemRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void save(ItemDto itemDto) {
        itemRepository.save(new Item(itemDto.getId(),itemDto.getPrice(),itemDto.getName()));

    }

    public ItemDto getItem(Long id) {

        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()){
            return new ItemDto(item.get().getId(), item.get().getName(),item.get().getPrice());
        } else {
            throw new NotFoundException("Item not found");
        }

    }

    private static List<ItemDto> itemMapper(List<Item> list){

        return list.parallelStream().map(a-> new ModelMapper().map(a,ItemDto.class))
                .collect(Collectors.toList());

    }

    public List<ItemDto> list() {
        List<Item> list = itemRepository.findAll();
        return itemMapper(list);
    }

    public void edit(ItemDto itemDto) {
        Optional<Item> item = itemRepository.findById(itemDto.getId());
        if (item.isPresent()){
            itemRepository.save(new Item(itemDto.getId(),itemDto.getPrice(),itemDto.getName()));
        } else {
            throw new NotFoundException("Item not found");
        }
    }

    public void delete(Long id) {
        try {
            itemRepository.deleteById(id);
        } catch(Exception e) {
            throw new NotFoundException("Item not found");
        }

    }
}
