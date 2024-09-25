package ola.samkabogom.basketspringdemo.controller;

import ola.samkabogom.basketspringdemo.service.CartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/store/order")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/add")
    public void addItems(@RequestParam("itemsId") ArrayList<Integer> itemsId) {
        cartService.addToItems(itemsId);
    }

    @GetMapping("/get")
    public List<Integer> getItems() {
        return cartService.getItems();
    }

}
