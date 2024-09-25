package ola.samkabogom.basketspringdemo.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@SessionScope()
public class Cart {
    private final List<Integer> repository = new ArrayList<>();

    public void addToItems(List<Integer> itemsId) {
        repository.addAll(itemsId);
    }

    public List<Integer> getItems() {
        return Collections.unmodifiableList(repository);
    }
}
