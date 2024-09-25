package ola.samkabogom.basketspringdemo.service;

import java.util.List;

public interface CartService {
    void addToItems(List<Integer> itemsId);

    List<Integer> getItems();
}
