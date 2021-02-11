package org.acme.springbootbackend.controller;

import java.util.Optional;

import org.acme.springbootbackend.model.Item;
import org.acme.springbootbackend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // return all
    @GetMapping("")
    @ApiOperation(value = "Returns all items",
    notes = "Use to get all items in stock",
    response = Item.class)
    public Iterable<Item> getAllItems() {
        return itemService.findAll();
    }

    // return by id
    @GetMapping("/{id}")
    @ApiOperation(value = "Returns an item by id",
    notes = "Use id to get one item in stock",
    response = Item.class)
    public Optional<Item> searchItem(@ApiParam(value = "item_no for the item you need to retrieve", required = true)
    @PathVariable Long id) {
        return itemService.FindById(id);
    }

    // add item
    @PostMapping(value = "")
    @ApiOperation(value = "Adds one item",
    notes = "Post JSON item with name, amount, and inventory code")
    public String addItem(@RequestBody Item item) {
        itemService.insert(item);
        return " Added successfully ";
    }

    // update quantity by id
    @PatchMapping( value = "/{id}")
    @ApiOperation(value = "Withdraw or deposit",
    notes = "Have only a negative or positive number(without curly braces) depicting how much you want to deposit or withdraw")
    public @ResponseBody void updateQuantity(@ApiParam(value = "item_no for the item you need to update", required = true)
    @PathVariable Long id, 
    @ApiParam(value = "negative/positive number which needs to be deposited or withdrawn", required = true)
    @RequestBody Long quantity) {

        // use isPresent to find optional item of id from the itemService.FindById
        if (itemService.FindById(id).isPresent()) {

            // use .get() to get the actual object from the Optional
            Item item = itemService.FindById(id).get();

            // deposit or withdraw and send to service to update
            item.changeAmount(quantity);
            itemService.updateItem(item);
        }

        // if optional is null
        else {
            System.out.println("Item_no not found");
        }

    }

    // delete item by id
    @DeleteMapping( value = "/{id}")
    @ApiOperation(value = "Deletes an item by id",
    notes = "Use id to delete one item in stock",
    response = Item.class)
    public void deleteItem(@ApiParam(value = "item_no for the item you need to delete", required = true)
    @PathVariable Long id) {
        
        // use isPresent to find optional item of id from the itemService.FindById
        if (itemService.FindById(id).isPresent()) {

            // use .get() to get the actual object from the Optional
            Item item = itemService.FindById(id).get();

            // send item to service to delete
            itemService.deleteItem(item);
        }

        // if optional is null
        else {
            System.out.println("Item_no not found");
        }
        
    }

}
