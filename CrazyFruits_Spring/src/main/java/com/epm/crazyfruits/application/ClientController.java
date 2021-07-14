package com.epm.crazyfruits.application;

import java.util.ArrayList;
import java.util.List;

import com.epm.crazyfruits.application.dto.ClientDTO;
import com.epm.crazyfruits.domain.person.Client;
import com.epm.crazyfruits.persistence.ClientRepository;
import com.epm.crazyfruits.persistence.InvalidParamException;
import com.epm.crazyfruits.persistence.NotFoundException;

public class ClientController {

	public ClientDTO createClient(ClientDTO client) throws Exception {
		Client user = new Client(client);
		new ClientRepository().createClient(user);
		return new ClientDTO(user);
	}
	public void updateClient(String id,ClientDTO client) throws Exception {
		new ClientRepository().getClient(id).update(client);
	}

	public void deleteClient(String id) throws NotFoundException {
		new ClientRepository().deleteClient(id);
	}

	public ClientDTO getClient(String id) throws NotFoundException, InvalidParamException {
		Client client =new ClientRepository().getClient(id);
		return new ClientDTO(client);
	}
	public List<ClientDTO> getAllClients() throws InvalidParamException {
		List<Client> allClients=new ClientRepository().getAllClients();
		return convertUsersToDTO(allClients);
	}
	private List<ClientDTO> convertUsersToDTO(List<Client> allClients) throws InvalidParamException {
		List<ClientDTO> result = new ArrayList<>();
		for(Client user:allClients) {
			result.add(new ClientDTO(user));
		}
		return result;
	}
}
