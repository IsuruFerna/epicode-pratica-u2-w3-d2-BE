package com.epicode.U5D2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@DiscriminatorValue("drink")
@Getter
@Setter
@NoArgsConstructor
public class Drink extends Item {
	private String name;

	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menu;

	public Drink(String name, int calories, double price) {
		super(calories, price);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Drink{" +
				"name='" + name + '\'' +
				", calories=" + calories +
				", price=" + price +
				'}';
	}
}
