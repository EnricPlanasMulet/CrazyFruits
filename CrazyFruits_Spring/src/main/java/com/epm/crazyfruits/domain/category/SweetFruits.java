package com.epm.crazyfruits.domain.category;

import com.epm.crazyfruits.utilities.FruitType;


public class SweetFruits extends AbsFruit {
	
	public SweetFruits(FruitType ft, int daysToExpire) {
		super(ft);
		setDaysToExpire(daysToExpire);
	}

	protected void setDaysToExpire(int daysToExpire) {
		this.daysToExpire=daysToExpire;
	}
}
