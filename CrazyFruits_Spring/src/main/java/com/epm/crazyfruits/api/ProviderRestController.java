package com.epm.crazyfruits.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epm.crazyfruits.application.ProviderController;
import com.epm.crazyfruits.application.dto.ProviderDTO;
import com.epm.crazyfruits.persistence.NotFoundException;
import com.google.gson.Gson;

@RestController
public class ProviderRestController {
	
	@GetMapping("/suppliers")
	public String getAllSuppliers() throws Exception {
		List<ProviderDTO> allSuppliers = new ProviderController().getAllSuppliers();
		Gson gson= new Gson();
		return gson.toJson(allSuppliers);
	}
	@GetMapping("/suppliers/{id}")
	public String getSupplier(@PathVariable String id) throws Exception {
		ProviderDTO supplier = new ProviderController().getSupplier(id);
		Gson gson= new Gson();
		return gson.toJson(supplier);
	}
	@PutMapping("/suppliers/{id}")
	public void updateSupplier(@PathVariable String id,@RequestBody ProviderDTO jUser) throws Exception {
		new ProviderController().updateSupplier(id, jUser);
	}
	@DeleteMapping("/suppliers/{id}")
	public void deleteSupplier(@PathVariable String id) throws NotFoundException {
		new ProviderController().deleteSupplier(id);
	}
	
	@PostMapping("/suppliers")
	public String createSupplier(@RequestBody String jUser) throws Exception {
		Gson gson= new Gson();
		ProviderDTO user =gson.fromJson(jUser, ProviderDTO.class);
		user =new ProviderController().createSupplier(user);
		return gson.toJson(user);
	}
}