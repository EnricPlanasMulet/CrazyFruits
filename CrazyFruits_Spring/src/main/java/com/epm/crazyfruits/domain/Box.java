package com.epm.crazyfruits.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epm.crazyfruits.application.dto.BoxDTO;
import com.epm.crazyfruits.domain.category.AbsFruit;
import com.epm.crazyfruits.persistence.NotFoundException;
import com.epm.crazyfruits.persistence.ShopRepository;
import com.epm.crazyfruits.utilities.FruitType;

public class Box {

	private String id,fruit1,fruit2,fruit3;
	private String shopID;
	private List<AbsFruit> fruits;

	public Box() {}
	public Box(BoxDTO boxDTO) throws Exception {
		this.shopID=boxDTO.getShopID();
		this.fruits = boxDTO.getFruits();
		this.id=boxDTO.getId();
		this.fruit1=boxDTO.getFruit1();
		this.fruit2=boxDTO.getFruit2();
		this.fruit3=boxDTO.getFruit3();
	}

	public void completeBox(String f1,String f2,String f3) throws Exception {//afegir la caixa a client, box controller
		Shop shop=new ShopRepository().getShop(shopID);
		String [] list=new String[]{f1,f2,f3};
		int counter=0;
		while(list.length>counter && !(list[counter].equals("EMPTY"))) {
			if(shop.getFruitWithType(FruitType.valueOf(list[counter])).size()>0) {
				add(shop.getFruitWithType(FruitType.valueOf(list[counter])).get(0));counter++;
			}
			else {
				while(counter>0) {
					remove(getFruits().get(counter-1));
					counter--;
				}
				throw new Exception("Error. Try selecting a different fruit");
			}
		}
		fillBox();
	}

	public void fillBox() throws Exception {
		Shop shop=new ShopRepository().getShop(shopID);
		if(shop.getStock().size()<8)throw new Exception();
		List<FruitType> sameTypes = getTemoralBox();
		fillExpireDate(shop);
		fillSameTypes(shop,sameTypes);
		fillRandom(shop);
	}

	private void fillSameTypes(Shop shop,List<FruitType> sameTypes) throws NotFoundException {
		int counter=0;
		if(!counterTypes(sameTypes).equals("null") && !counterTypes(sameTypes).equals("empty")) {
			while(getFruits().size()<8) {
				int i=new Random().nextInt(shop.getStock().size());
				if(shop.getStock().get(i).getFruitType().getCategoryType()==counterTypes(sameTypes)) {
					if(!hasThisFruit(shop.getStock().get(i).getFruitType())) {
						add(shop.getStock().get(i));
					}}
				if(counter==500) {
					break;
				}counter++;
			}
		}
	}

	private void fillRandom(Shop shop) throws NotFoundException {
		int counter=0;
		while(getFruits().size()<8) {
			int i=new Random().nextInt(shop.getStock().size());
			if(!hasThisFruit(shop.getStock().get(i).getFruitType())) {
				add(shop.getStock().get(i));
			}
			if(counter==500) {
				break;
			}counter++;
		}
	}
	private void fillExpireDate(Shop shop) throws NotFoundException {
		List<AbsFruit> expired = shop.closeFruitsToExpire(5);
		int r=0;
		while(getFruits().size()<8) {
			if(expired.size()==0)break;
			if(!hasThisFruit(expired.get(r).getFruitType())) {
				add(expired.get(r));
				r++;
			}
		}
	}
	private List<FruitType> getTemoralBox() {
		List<FruitType> sameTypes = new ArrayList<FruitType>();
		if(fruits==null)fruits=new ArrayList<AbsFruit>();
		for(AbsFruit a: fruits) {
			sameTypes.add(a.getFruitType());
		}
		return sameTypes;
	}


	private String counterTypes(List<FruitType> list) {
		int maxValue=0,counter=0;FruitType result=null;
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(list.get(i).getCategoryType().equals(list.get(j).getCategoryType())) {
					counter++;
					if(counter>maxValue) {
						maxValue=counter;result=list.get(i);
					}
				}
			}counter=0;
		}
		if(maxValue==1 && list.size()>1)return "null";
		if(list.size()==0)return "empty";
		return result.getCategoryType();
	}

	public boolean add(AbsFruit e) throws NotFoundException {
		Shop shop=new ShopRepository().getShop(shopID);
		if(fruits==null)fruits=new ArrayList<AbsFruit>();
		if(e==null || fruits.size()>=8 || fruits.contains(e))return false;
		shop.removeFruitWithId(e.getId());
		return fruits.add(e);
	}

	public boolean remove(AbsFruit e) throws NotFoundException {
		Shop shop=new ShopRepository().getShop(shopID);
		shop.addFruit(e);
		return fruits.remove(e);
	}

	public List<AbsFruit> getFruits() {
		if(fruits==null)fruits=new ArrayList<AbsFruit>();
		return fruits;
	}	

	public String getId() {
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

	public String getShopID() {
		return shopID;
	}
	public AbsFruit getFruit(AbsFruit f) {
		if(fruits.contains(f)) {
			return f;
		}
		else return null;
	}
	public boolean hasThisFruit(FruitType f) {
		for(AbsFruit a:fruits) {
			if(a.getFruitType().equals(f)) {
				return true;
			}
		}
		return false;
	}
} 