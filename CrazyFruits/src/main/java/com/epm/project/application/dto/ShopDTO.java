package com.epm.project.application.dto;

import java.util.List;

import com.epm.project.domain.Shop;
import com.epm.project.domain.category.AbsFruit;
import com.epm.project.persistence.InvalidParamException;

public class ShopDTO {

	private List<AbsFruit> stock;

	private String id,name;

	public ShopDTO(Shop shop) {
		this.name=shop.getName();
		this.stock= shop.getStock();
		this.id = shop.getId();
	}

	public List<AbsFruit> getStock() {
		return stock;
	}

	public String getId() throws InvalidParamException {
		if(id==null)throw new InvalidParamException();
		return id;
	}

	public String getName() throws InvalidParamException {
		if(name.isEmpty())throw new InvalidParamException();
		return name;
	}

}