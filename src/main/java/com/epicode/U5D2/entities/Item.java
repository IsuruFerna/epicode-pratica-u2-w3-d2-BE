package com.epicode.U5D2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "item")
@Getter
@NoArgsConstructor
public abstract class Item {
	@Id
	@GeneratedValue
	private long id;

	protected int calories;
	protected double price;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public Item(int calories, double price) {
		this.calories = calories;
		this.price = price;
	}

}
