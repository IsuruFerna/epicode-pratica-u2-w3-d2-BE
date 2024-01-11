package com.epicode.U5D2.dao;

import com.epicode.U5D2.entities.Drink;
import com.epicode.U5D2.entities.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {
    @Autowired
    DrinkDAO drinkDAO;

    public void save(Drink drink) {
        drinkDAO.save(drink);
    }
}
