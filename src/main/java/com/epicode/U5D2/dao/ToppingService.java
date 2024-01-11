package com.epicode.U5D2.dao;

import com.epicode.U5D2.entities.Pizza;
import com.epicode.U5D2.entities.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToppingService {
    @Autowired
    ToppingDAO toppingDAO;

    public void save(Topping topping) {
        toppingDAO.save(topping);
    }
}
