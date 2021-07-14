package com.epm.crazyfruits.persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.epm.crazyfruits.application.dto.ShopDTO;
import com.epm.crazyfruits.domain.Shop;
import com.epm.crazyfruits.domain.category.AbsFruit;
import com.epm.crazyfruits.utilities.FruitType;

public class ShopRepository {

	private static Set<Shop> shops = new HashSet<>();

	public Shop getShop(String id) throws NotFoundException {
		for(Shop c:shops) {
			if(c.getId().equals(id)) {
				return c;
			}
		}
		throw new NotFoundException();
	}
	public void updateShop(String id,ShopDTO shop) throws Exception {
		for(Shop c:shops) {
			if(c.getId().equals(id)) {
				shops.remove(c);
				shops.add(new Shop(shop));return;
			}
		}
		throw new NotFoundException();
	}
	public List<Shop> getAllShops(){
		return new ArrayList<>(shops);
	}
	public void createShop(Shop shop) throws InvalidParamException {
		if(shop==null)throw new InvalidParamException();
		shops.add(shop);
	}

	public void deleteShop(String id) throws Exception {
		for(Shop c:new ArrayList<>(shops)) {
			if(c.getId().equals(id)) {
				shops.remove(c);
				return;
			}
		}
		throw new NotFoundException();
	}
	public List<AbsFruit> getAllStock(String id) throws InvalidParamException, NotFoundException{
		if(id==null)throw new InvalidParamException();
		return getShop(id).getStock();
	}
	public List<AbsFruit> getAllFruitTypesAvailable(String id,String fruitType) throws InvalidParamException, NotFoundException{
		if(id==null)throw new InvalidParamException();
		if(fruitType.isEmpty())throw new InvalidParamException();
		return getShop(id).getFruitWithType(FruitType.valueOf(fruitType));
	}

	public void addFruit(String id, AbsFruit f) throws NotFoundException, InvalidParamException {
		if(id==null)throw new InvalidParamException();
		getShop(id).addFruit(f);
	}


}