package com.epicode.U5D2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
//@DiscriminatorValue("pizza")
@Getter
@NoArgsConstructor
public class Pizza extends Item {
//	@Column(unique = true)
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pizza_topping", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "topping_id"))
	private List<Topping> toppingList;

	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;

	private boolean isXl = false;

	public Pizza(String name, List<Topping> toppingList, boolean isXl) {
		super(700, 4.3);
		this.name = name;
		this.toppingList = toppingList;
		this.isXl = isXl;
	}

	@Override
	public int getCalories() {
		return super.getCalories() + this.getToppingList().stream().mapToInt(Topping::getCalories).sum();
	}

	@Override
	public double getPrice() {
		return super.getPrice() + this.getToppingList().stream().mapToDouble(Topping::getPrice).sum();
	}

	@Override
	public String toString() {
		return "Pizza{" +
				"name='" + name + '\'' +
				", calories=" + calories +
				", price=" + price +
				", toppingList=" + toppingList +
				", isXl=" + isXl +
				'}';
	}
}
