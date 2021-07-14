package com.epm.crazyfruits.domain.category;

import com.epm.crazyfruits.utilities.FruitType;


public class NeutralFruits extends AbsFruit{
	
	public NeutralFruits(FruitType ft, int daysToExpire) {
		super(ft);
		setDaysToExpire(daysToExpire);
	}

	protected void setDaysToExpire(int daysToExpire) {
		this.daysToExpire=daysToExpire;
	}
}
