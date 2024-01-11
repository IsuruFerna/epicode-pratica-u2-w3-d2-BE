package com.epicode.U5D2.dao;

import com.epicode.U5D2.entities.Pizza;
import com.epicode.U5D2.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingDAO extends JpaRepository<Topping, Long> {
}
