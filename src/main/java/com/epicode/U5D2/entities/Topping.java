package com.epicode.U5D2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
//@DiscriminatorValue("topping")
@Getter
@Setter
@NoArgsConstructor
public class Topping extends Item {

	private String name;

	@ManyToMany(mappedBy = "toppingList")
	private List<Pizza> pizzas;

	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;

	public Topping(String name, int calories, double price) {
		super(calories, price);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Topping{" +
				"name='" + name + '\'' +
				", calories=" + calories +
				", price=" + price +
				'}';
	}
}
