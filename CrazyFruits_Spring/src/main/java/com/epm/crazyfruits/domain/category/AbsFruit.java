package com.epm.crazyfruits.domain.category;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

import com.epm.crazyfruits.utilities.FruitType;


public abstract class AbsFruit {

	private String name,id;
	private FruitType fruitType;
	protected int daysToExpire;
	protected Calendar entryDate;


	public AbsFruit(FruitType fruitType) {
		id = UUID.randomUUID().toString();
		this.fruitType=fruitType;
		this.name = fruitType.toString();
		entryDate = Calendar.getInstance();
		entryDate.setTime(new java.util.Date());
	}

	public String getId() {
		return id;
	}

	public FruitType getFruitType() {
		return fruitType;
	}

	protected abstract void setDaysToExpire(int d);
	public String getName() {return name;}
	public Date getEntryDate() {return entryDate.getTime();}

	public int isExpired() {
		Calendar c = (Calendar) entryDate.clone();
		c.add(c.DAY_OF_MONTH, daysToExpire);
		return getDifferenceDays(new java.util.Date(), c.getTime());
	}

	private int getDifferenceDays(Date d1, Date d2) {
		if(d2.getTime()<d1.getTime()) {
			return -1;
		}
		int diff = (int) (d2.getTime() - d1.getTime());
		return (int) ChronoUnit.DAYS.between(d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
				, d2.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
	}

	@Override
	public boolean equals(Object o) {
		AbsFruit a=(AbsFruit) o;

		if(a.id==this.id &&	a.name==this.name) {
			return true;
		}
		else {
			return false;
		}
	}

}