package com.example.homeworkspring.repository;

import com.example.homeworkspring.model.Item;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StoreRepository {
    private int IdCounter = 1;
    private final Map<Integer, Item> store = new HashMap<>();
    @PostConstruct
    public void init(){
        store.put(IdCounter, new Item(IdCounter++, "Ноутбук"));
        store.put(IdCounter, new Item(IdCounter++, "Телефон"));
        store.put(IdCounter, new Item(IdCounter++, "Книга"));
    }
    public void add(Item item){
        store.put(item.getId(), item);
    }
    public Item get(int id){
        return store.get(id);
    }
    public List<Item> getAll(){
        return new ArrayList<>(store.values());
    }
    public void update(int id, Item item){
        if (store.containsKey(id)) {
            store.replace(id, item);
        }
    }
    public Item delete(int id){
        return store.remove(id);
    }
}
