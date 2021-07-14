package com.epm.crazyfruits.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epm.crazyfruits.application.ClientController;
import com.epm.crazyfruits.application.dto.ClientDTO;
import com.epm.crazyfruits.persistence.InvalidParamException;
import com.epm.crazyfruits.persistence.NotFoundException;
import com.google.gson.Gson;

@RestController
public class ClientRestController {

	@GetMapping("/clients")
	public String getAllClients() throws InvalidParamException {
		List<ClientDTO> allClients = new ClientController().getAllClients();
		Gson gson= new Gson();
		return gson.toJson(allClients);
	}
	@GetMapping("/clients/{id}")
	public String getClient(@PathVariable String id) throws NotFoundException, InvalidParamException {
		ClientDTO client = new ClientController().getClient(id);
		Gson gson= new Gson();
		return gson.toJson(client);
	}
	@PutMapping("/clients/{id}")
	public void updateClient(@PathVariable String id,@RequestBody ClientDTO jUser) throws Exception {
		new ClientController().updateClient(id,jUser);
	}
	@DeleteMapping("/clients/{id}")
	public void deleteClient(@PathVariable String id) throws NotFoundException {
		new ClientController().deleteClient(id);
	}

	@PostMapping("/clients")
	public String createClient(@RequestBody String jUser) throws Exception {
		Gson gson= new Gson();
		ClientDTO user =gson.fromJson(jUser, ClientDTO.class);
		user =new ClientController().createClient(user);
		return gson.toJson(user);
	}
}