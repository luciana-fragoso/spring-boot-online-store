package com.demo.OnlineStore.Controller;

import com.demo.OnlineStore.Controller.Dto.ItemDto;
import com.demo.OnlineStore.Service.ItemService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store/item")
public class ItemController {


    @Autowired
    ItemService itemService;

    @PutMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public void save(@RequestBody ItemDto itemDto){
        itemService.save(itemDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> get(@PathVariable Long id){
        return ResponseEntity.ok(itemService.getItem(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ItemDto>> list() {
        return ResponseEntity.ok(itemService.list());
    }

    @PostMapping("/edit")
    @ResponseStatus(HttpStatus.OK)
    public void edit(@RequestBody ItemDto itemDto){
        itemService.edit(itemDto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        itemService.delete(id);
    }
}
