package com.epicode.U5D2.dao;

import com.epicode.U5D2.entities.Drink;
import com.epicode.U5D2.entities.Menu;
import com.epicode.U5D2.entities.Pizza;
import com.epicode.U5D2.entities.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuDAO menuDAO;

//    public void saveMenu(List<Pizza> pizzas, List<Drink> drinks, List<Topping> toppings) {
//        Menu menu = new Menu(pizzas, drinks, toppings);
//        menuDAO.save(menu);
//    }
}
