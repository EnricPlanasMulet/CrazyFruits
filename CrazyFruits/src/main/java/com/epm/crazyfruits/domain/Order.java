package com.epm.crazyfruits.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import com.epm.crazyfruits.application.FruitFactory;
import com.epm.crazyfruits.domain.category.AbsFruit;
import com.epm.crazyfruits.utilities.FruitType;


public class Order {

	private String id;
	private Calendar date;
	private List<AbsFruit> fruits;

	public Order() throws Exception {
		this.id = UUID.randomUUID().toString();
		date = Calendar.getInstance();
		date.setTime(new java.util.Date());
		this.fruits = new ArrayList<AbsFruit>();
	}

	public void fillOrder() throws Exception{
		int counter=0;
		for(FruitType f:FruitType.values()) {
			counter=0;
			while(counter<3) {
				fruits.add(FruitFactory.getInstance().createFruit(f.toString(), f.getStandarExpireDate()));
				counter++;
			}
		}
	}

	public void addFruit(AbsFruit f){
		fruits.add(f);
	}

	public String getId() {
		return id;
	}

	public Calendar getDate() {
		return date;
	}

	public List<AbsFruit> getFruits() {
		return fruits;
	}

}