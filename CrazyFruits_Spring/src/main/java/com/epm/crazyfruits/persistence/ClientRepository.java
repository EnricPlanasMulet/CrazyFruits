package com.epm.crazyfruits.persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.epm.crazyfruits.domain.person.Client;

public class ClientRepository {

	private static Set<Client> clients = new HashSet<>();

	public Client getClient(String id) throws NotFoundException {
		for(Client c:clients) {
			if(c.getId().equals(id)) {
				return c;
			}
		}
		throw new NotFoundException();
	}
	public List<Client> getAllClients(){
		return new ArrayList<>(clients);
	}
	public void createClient(Client client) throws InvalidParamException {
		if(client==null)throw new InvalidParamException();
		clients.add(client);
	}
	public void deleteClient(String id) throws NotFoundException {
		for(Client c:new ArrayList<>(clients)) {
			if(c.getId().equals(id)) {
				clients.remove(c);
				return;
			}
		}
		throw new NotFoundException();

	}
}