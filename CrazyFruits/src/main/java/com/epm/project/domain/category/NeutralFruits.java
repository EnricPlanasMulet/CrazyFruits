package com.epm.project.domain.category;

import com.epm.project.utilities.FruitType;


public class NeutralFruits extends AbsFruit{
	
	public NeutralFruits(FruitType ft, int daysToExpire) {
		super(ft);
		setDaysToExpire(daysToExpire);
	}

	protected void setDaysToExpire(int daysToExpire) {
		this.daysToExpire=daysToExpire;
	}
}
