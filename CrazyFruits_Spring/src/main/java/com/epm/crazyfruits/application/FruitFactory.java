package com.epm.crazyfruits.application;

import com.epm.crazyfruits.domain.category.AbsFruit;
import com.epm.crazyfruits.utilities.FruitType;

public class FruitFactory {

	private static FruitFactory instance = null;

	private FruitFactory() {

	}
	public static FruitFactory getInstance()
	{
		if(instance == null)
			instance = new FruitFactory();
		return instance;
	}

	public AbsFruit createFruit(String fruitName,int daysToExpire) throws Exception{
		fruitName=fruitName.toUpperCase();
		return (AbsFruit) Class.forName("com.tcm.project.domain.category."+FruitType.valueOf(fruitName).getCategoryType())
				.getDeclaredConstructor(FruitType.class,Integer.TYPE).newInstance(FruitType.valueOf(fruitName),daysToExpire);
	}

}
