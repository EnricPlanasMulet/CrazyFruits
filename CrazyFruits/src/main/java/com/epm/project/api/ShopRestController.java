package com.epm.project.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epm.project.application.ShopController;
import com.epm.project.application.dto.ShopDTO;
import com.epm.project.domain.category.AbsFruit;
import com.epm.project.persistence.InvalidParamException;
import com.epm.project.persistence.NotFoundException;
import com.google.gson.Gson;

@RestController
public class ShopRestController {

	@GetMapping("/shops")
	public String getAllShops() throws InvalidParamException {
		List<ShopDTO> allShops = new ShopController().getAllShops();
		Gson gson= new Gson();
		return gson.toJson(allShops);
	}
	@GetMapping("/shops/{id}")
	public String getShop(@PathVariable String id) throws NotFoundException, InvalidParamException {
		ShopDTO shop = new ShopController().getShop(id);
		Gson gson= new Gson();
		return gson.toJson(shop);
	}

	@GetMapping("/shops-stock/{id}")
	public String getAllStock(@PathVariable String id) throws InvalidParamException, NotFoundException {
		List<AbsFruit> allStock = new ShopController().getAllStock(id);
		Gson gson= new Gson();
		return gson.toJson(allStock);
	}
	@GetMapping("/shops-stock/{id}/{fruitType}")
	public String getAllFruitTypes(@PathVariable String id,@PathVariable String fruitType) throws InvalidParamException, NotFoundException {
		List<AbsFruit> allStock = new ShopController().getAllFruitTypesAvailable(id, fruitType);
		Gson gson= new Gson();
		return gson.toJson(allStock);
	}
	@PutMapping("/shops/{id}")
	public void updateShop(@PathVariable String id,@RequestBody String jUser) throws Exception {
		Gson gson= new Gson();
		ShopDTO shop =  gson.fromJson(jUser, ShopDTO.class);
		new ShopController().updateShop(id,shop);
	}

	@DeleteMapping("/shops/{id}")
	public void deleteShop(@PathVariable String id) throws Exception {
		new ShopController().deleteShop(id);
	}

	@PostMapping("/shops")
	public String createShop(@RequestBody String jUser) throws Exception {
		Gson gson= new Gson();
		ShopDTO shop =gson.fromJson(jUser, ShopDTO.class);
		shop =new ShopController().createShop(shop);
		return gson.toJson(shop);
	}

	@PostMapping("/shops-stock/{id}/{fruitType}")
	public String addFruit(@PathVariable String id,@PathVariable String fruitType) throws Exception {
		Gson gson= new Gson();
		return gson.toJson(new ShopController().addFruit(id,fruitType));
	}

}