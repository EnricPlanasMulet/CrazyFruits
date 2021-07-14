package com.epm.project.utilities;

public enum FruitType {
	
	LLIMONA("AcidFruits",20),POMELO("AcidFruits",20),TARONJA("AcidFruits",20),PINYA("AcidFruits",20),
	MADUIXA("SemiacidFruits",10),MANDARINA("SemiacidFruits",10),MANGO("SemiacidFruits",10),PRÉSSEC("SemiacidFruits",10),
	ALBERCOC("SweetFruits",15),CIRERA("SweetFruits",15),POMA("SweetFruits",15),MELÓ("SweetFruits",15),
	AMETLLA("NeutralFruits",40),AVELLANA("NeutralFruits",40),COCO("NeutralFruits",40),NOU("NeutralFruits",40);
	
	private String categoryType;
	private int standarExpireDate;
	
	FruitType(String s,int standarExpireDate){
		categoryType=s;
		this.standarExpireDate=standarExpireDate;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public int getStandarExpireDate() {
		return standarExpireDate;
	}
}
