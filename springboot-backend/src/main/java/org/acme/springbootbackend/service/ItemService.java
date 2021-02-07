package org.acme.springbootbackend.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.acme.springbootbackend.model.Item;
import org.acme.springbootbackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;

    // add item to stock
    public void insert(Item item){
        itemRepository.save(item);
    }

    // read one item's details
    public Optional<Item> FindById(Long id){
        return itemRepository.findById(id);
    }

    // list all items
    public Iterable<Item> findAll(){
        return itemRepository.findAll();
    }

    // update item
    public void updateItem(Item item) {
        itemRepository.save(item);
    }

    // delete item from stock
    public void deleteItem(Item item){
        itemRepository.delete(item);
    }
}
