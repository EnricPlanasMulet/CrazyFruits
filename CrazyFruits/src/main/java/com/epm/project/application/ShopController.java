package com.epm.project.application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.epm.project.application.dto.ShopDTO;
import com.epm.project.domain.Order;
import com.epm.project.domain.Shop;
import com.epm.project.domain.category.AbsFruit;
import com.epm.project.persistence.InvalidParamException;
import com.epm.project.persistence.NotFoundException;
import com.epm.project.persistence.ShopRepository;
import com.epm.project.utilities.FruitType;

public class ShopController {

	public ShopDTO createShop(ShopDTO shop) throws Exception {
		Shop shopp = new Shop(shop);
		new ShopRepository().createShop(shopp);
		return new ShopDTO(shopp);
	}
	public void updateShop(String id,ShopDTO shop) throws Exception {
		new ShopRepository().updateShop(id,shop);
	}

	public void deleteShop(String id) throws Exception {
		new ShopRepository().deleteShop(id);
	}

	public ShopDTO getShop(String id) throws NotFoundException, InvalidParamException {
		Shop shop =new ShopRepository().getShop(id);
		return new ShopDTO(shop);
	}
	public List<ShopDTO> getAllShops() throws InvalidParamException {
		List<Shop> allShops=new ShopRepository().getAllShops();
		return convertShopsToDTO(allShops);
	}
	private List<ShopDTO> convertShopsToDTO(List<Shop> allShops) throws InvalidParamException {
		List<ShopDTO> result = new ArrayList<>();
		for(Shop shop:allShops) {
			result.add(new ShopDTO(shop));
		}
		return result;
	}

	public List<AbsFruit> getAllStock(String id) throws InvalidParamException, NotFoundException{
		return new ShopRepository().getAllStock(id);
	}
	public List<AbsFruit> getAllFruitTypesAvailable(String id, String fruitType) throws InvalidParamException, NotFoundException{
		return new ShopRepository().getAllFruitTypesAvailable(id, fruitType);
	}
	public AbsFruit addFruit(String id, String fruitType) throws Exception {
		AbsFruit f=FruitFactory.getInstance().createFruit(fruitType,FruitType.valueOf(fruitType).getStandarExpireDate());
		new ShopRepository().addFruit(id,f);
		return f;
	}
	private void weeklyDeliver() throws Exception {
		Calendar with = Calendar.getInstance();
		Map<Integer, Integer> dayToDelay = new HashMap<Integer, Integer>();
		dayToDelay.put(Calendar.FRIDAY, 2);
		dayToDelay.put(Calendar.SATURDAY, 1);
		dayToDelay.put(Calendar.SUNDAY, 0);
		dayToDelay.put(Calendar.MONDAY, 6);
		dayToDelay.put(Calendar.TUESDAY, 5);
		dayToDelay.put(Calendar.WEDNESDAY, 4);
		dayToDelay.put(Calendar.THURSDAY, 3);
		int dayOfWeek = with.get(Calendar.DAY_OF_WEEK);
		int hour = with.get(Calendar.HOUR_OF_DAY);
		int delayInDays = dayToDelay.get(dayOfWeek);
		int delayInHours = 0;
		if(delayInDays == 6 && hour<11){
			delayInHours = 11 - hour;
		}else{
			delayInHours = delayInDays*24+((24-hour)+11);
		}
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);            
		scheduler.scheduleAtFixedRate(new WeeklyTask(), delayInHours,179, TimeUnit.HOURS);
	}
}
class WeeklyTask implements Runnable {

	private Order o;
	private String id;

	public WeeklyTask() throws Exception {
		this.o=new Order();
		this.o.fillOrder();
		this.id=id;
	}

	@Override
	public void run() {	
		try {
			new ShopRepository().getShop(id).addList(o.getFruits());

		} catch (NotFoundException e) {
		}
	}
}
