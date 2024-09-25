package ola.samkabogom.basketspringdemo.service;

import ola.samkabogom.basketspringdemo.repository.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final Cart cart;

    public CartServiceImpl(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void addToItems(List<Integer> itemsId) {
        cart.addToItems(itemsId);
    }
    @Override
    public List<Integer> getItems() {
        return cart.getItems();
    }
}
