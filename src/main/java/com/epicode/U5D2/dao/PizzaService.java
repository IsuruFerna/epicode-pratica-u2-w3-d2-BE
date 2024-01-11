package com.epicode.U5D2.dao;

import com.epicode.U5D2.entities.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    @Autowired
    PizzaDAO pizzaDAO;

    public void save(Pizza pizza) {
        pizzaDAO.save(pizza);
    }
}
