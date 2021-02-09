package org.acme.springbootbackend.controller;

import java.lang.reflect.Field;
import java.util.Optional;

import org.acme.springbootbackend.model.Item;
import org.acme.springbootbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // return all
    @RequestMapping("")
    public Iterable<Item> getAllItems() {
        return itemService.findAll();
    }

    // return by id
    @RequestMapping("/{id}")
    public Optional<Item> searchItem(@PathVariable Long id) {
        return itemService.FindById(id);
    }

    // add item
    @RequestMapping(method = RequestMethod.POST, value = "")
    public void addItem(@RequestBody Item item) {
        itemService.insert(item);
    }

    // update quantity by id
    @RequestMapping(method = RequestMethod.PATCH, value = "/{id}")
    public @ResponseBody void updateQuantity(@PathVariable Long id, @RequestBody Long newQuantity) {

        // use isPresent to find optional item of id from the itemService.FindById
        // function
        if (itemService.FindById(id).isPresent()) {

            // use .get() to get the actual object from the Optional
            Item item = itemService.FindById(id).get();
            
            item.changeAmount(newQuantity);
            itemService.updateItem(item);
        }

        // if optional is null
        else {
            System.out.println("Item_no not found");
        }

    }

    // delete item by id
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteItem(@RequestBody Item item) {
        itemService.deleteItem(item);
    }

}
