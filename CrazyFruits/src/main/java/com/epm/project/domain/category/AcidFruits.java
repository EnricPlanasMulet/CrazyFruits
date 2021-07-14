package com.epm.project.domain.category;

import com.epm.project.utilities.FruitType;



public class AcidFruits extends AbsFruit{

	public AcidFruits(FruitType ft, int daysToExpire) {
		super(ft);
		setDaysToExpire(daysToExpire);
	}

	protected void setDaysToExpire(int daysToExpire) {
		this.daysToExpire=daysToExpire;
	}
}
