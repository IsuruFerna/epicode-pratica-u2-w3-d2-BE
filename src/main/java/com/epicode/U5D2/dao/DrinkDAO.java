package com.epicode.U5D2.dao;

import com.epicode.U5D2.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkDAO extends JpaRepository<Drink, Long> {
}
