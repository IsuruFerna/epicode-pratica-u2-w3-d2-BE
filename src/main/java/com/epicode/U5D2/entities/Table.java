package com.epicode.U5D2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Table {
	@Id
	@GeneratedValue
	private int numTable;
	private int numMaxCoperti;
	private boolean isFree;
	private double costoCoperto;

	@OneToMany(mappedBy = "table")
	private List<Order> orders;
	public void print() {
		System.out.println("numero tavolo--> " + numTable);
		System.out.println("numero massimo coperti--> " + numMaxCoperti);
		System.out.println("occupato/libero--> " + (this.isFree ? "Libero" : "Occupato"));
	}

}
