package org.acme.springbootbackend.controller;

import java.util.Optional;

import org.acme.springbootbackend.model.Item;
import org.acme.springbootbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    // return all
    @RequestMapping("")
    public Iterable<Item> getAllItems(){
        return itemService.findAll();
    }

    // return by id
    @RequestMapping("/{id}")
    public Optional<Item> searchItem(@PathVariable Long id){
        return itemService.FindById(id);
    }

    // add item
    @RequestMapping(method = RequestMethod.POST, value = "")
    public void addItem(@RequestBody Item item){
        itemService.insert(item);
    }

    // update quantity by id
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateItem(@RequestBody Item item){
        itemService.updateItem(item);
    }

    // delete item by id
    @RequestMapping(method = RequestMethod.DELETE, value="/{id}")
    public void deleteItem(@RequestBody Item item){
        itemService.deleteItem(item);
    }


}
