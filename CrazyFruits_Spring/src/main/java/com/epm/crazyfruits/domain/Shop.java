package com.epm.crazyfruits.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.epm.crazyfruits.application.dto.ShopDTO;
import com.epm.crazyfruits.domain.category.AbsFruit;
import com.epm.crazyfruits.utilities.FruitType;

public class Shop {

	private List<AbsFruit> stock;
	private String id,name;

	public Shop(ShopDTO shopDTO) throws Exception {
		this.name=shopDTO.getName();
		this.stock= shopDTO.getStock();
		this.id = shopDTO.getId();
	}

	public String getName() {
		return name;
	}

	public List<AbsFruit> getStock() {
		if(stock==null)stock=new ArrayList<AbsFruit>();
		return stock;
	}

	public String getId() {
		return id;
	}

	public boolean addFruit(AbsFruit f){
		if(f!=null) {
			if(this.stock==null)this.stock=new ArrayList<AbsFruit>();
			if(getFruitWithType(f.getFruitType()).size()<15) {
				stock.add(f);return true;
			}
		}
		return false;

	}
	public void addList(List<AbsFruit> listFruits){
		for(AbsFruit a:removeExpiredFruits(listFruits)) {
			if(getFruitWithType(a.getFruitType()).size()<15) {
				addFruit(a);
			}
		}
	}

	public List<AbsFruit> removeExpiredFruits(List<AbsFruit> listFruits) {
		for(AbsFruit a:listFruits) {
			if(a.isExpired()==-1) {
				listFruits.remove(a);
			}
		}
		return listFruits;
	}

	public List<AbsFruit> closeFruitsToExpire(int expireDays){
		List<AbsFruit> closeExpirationFruits= new ArrayList<AbsFruit>();
		for(AbsFruit a:stock) {
			if(a.isExpired()<=expireDays) {
				closeExpirationFruits.add(a);
			}
		}
		closeExpirationFruits.sort(new ExpireDateComparator());
		return closeExpirationFruits;
	}
	public List<AbsFruit> getFruitWithType(FruitType f) {
		List<AbsFruit> fruitsWithType= new ArrayList<AbsFruit>();
		for(AbsFruit a:stock) {
			if(a.getFruitType()==f) {
				fruitsWithType.add(a);
			}
		}
		return fruitsWithType;
	}
	public List<AbsFruit> getFruitWithCategory(String category) {
		List<AbsFruit> fruitsWithType= new ArrayList<AbsFruit>();
		for(AbsFruit a:stock) {
			if(a.getFruitType().getCategoryType().equals(category)) {
				fruitsWithType.add(a);
			}
		}
		return fruitsWithType;
	}
	public AbsFruit getFruitWithId(String id) {
		for(AbsFruit a:stock) {
			if(a.getId().equals(id)) {
				return a;
			}
		}
		return null;
	}
	public void removeFruitWithId(String id) {
		for(AbsFruit a:stock) {
			if(a.getId().equals(id)) {
				stock.remove(a);
				break;
			}
		}
	}
	public Map<FruitType,Integer> getCountStock() {
		int counter=0;
		Map<FruitType,Integer> inventory= new HashMap<FruitType,Integer>();

		for(FruitType t : FruitType.values()) {
			for(int i=0;i<stock.size();i++) {
				if(stock.get(i).getFruitType()==t) {
					counter++;
				}
			}
			if(counter!=0)inventory.put(t, counter);
			counter=0;
		}
		return inventory;
	}
}

class ExpireDateComparator implements Comparator<AbsFruit> {

	@Override
	public int compare(AbsFruit s1, AbsFruit s2)
	{
		if (s1.isExpired() == s2.isExpired())
			return 0;
		else if (s1.isExpired() > s2.isExpired())
			return 1;
		else
			return -1;
	}
}