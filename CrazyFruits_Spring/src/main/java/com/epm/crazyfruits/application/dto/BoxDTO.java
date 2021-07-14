package com.epm.crazyfruits.application.dto;

import java.util.List;

import com.epm.crazyfruits.domain.Box;
import com.epm.crazyfruits.domain.category.AbsFruit;
import com.epm.crazyfruits.persistence.InvalidParamException;

public class BoxDTO {

	private String id,fruit1,fruit2,fruit3;
	private String shopID;
	private List<AbsFruit> fruits;

	public BoxDTO(Box box) {
		this.shopID=box.getShopID();
		this.fruits = box.getFruits();
		this.id=box.getId();
		this.fruit1=box.getFruit1();
		this.fruit2=box.getFruit2();
		this.fruit3=box.getFruit3();
	}

	public List<AbsFruit> getFruits() {
		return fruits;
	}

	public String getId() throws InvalidParamException {
		if(id==null)throw new InvalidParamException();
		return id;
	}

	public String getFruit1() {
		return fruit1;
	}

	public String getFruit2() {
		return fruit2;
	}

	public String getFruit3() {
		return fruit3;
	}

	public String getShopID() throws InvalidParamException {
		if(shopID==null)throw new InvalidParamException();
		return shopID;
	}


}