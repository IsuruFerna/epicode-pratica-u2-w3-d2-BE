package com.epicode.U5D2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Getter
@ToString
@AllArgsConstructor
@Component
@NoArgsConstructor
public class Menu {
	@Id
	@GeneratedValue
	private long id;

	@OneToMany(mappedBy = "menu")
	private List<Pizza> pizzaList;

	@OneToMany(mappedBy = "menu")
	private List<Drink> drinkList;

	@OneToMany(mappedBy = "menu")
	private List<Topping> toppingList;

	public void printMenu() {
		System.out.println("******* Menu *******");
		System.out.println("PIZZAS");
		this.pizzaList.forEach(System.out::println);
		System.out.println();

		System.out.println("TOPPINGS");
		this.toppingList.forEach(System.out::println);
		System.out.println();

		System.out.println("DRINKS");
		this.drinkList.forEach(System.out::println);
		System.out.println();

	}
}
