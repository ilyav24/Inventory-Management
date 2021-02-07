package org.acme.springbootbackend.repository;

import org.acme.springbootbackend.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
    
}
