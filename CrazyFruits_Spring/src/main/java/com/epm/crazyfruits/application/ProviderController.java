package com.epm.crazyfruits.application;

import java.util.ArrayList;
import java.util.List;

import com.epm.crazyfruits.application.dto.ProviderDTO;
import com.epm.crazyfruits.domain.person.Provider;
import com.epm.crazyfruits.persistence.NotFoundException;
import com.epm.crazyfruits.persistence.ProviderRepository;

public class ProviderController {

	public List<ProviderDTO> getAllSuppliers() throws Exception {
		List<Provider> allSuppliers=new ProviderRepository().getAllSupplier();
		return convertUsersToDTO(allSuppliers);
	}

	public ProviderDTO getSupplier(String id) throws Exception {
		Provider supplier =new ProviderRepository().getSupplier(id);
		return new ProviderDTO(supplier);
	}
	public void updateSupplier(String id,ProviderDTO supplier) throws Exception {
		new ProviderRepository().getSupplier(id).update(supplier);
	}

	public void deleteSupplier(String id) throws NotFoundException {
		new ProviderRepository().deleteSupplier(id);
	}

	public ProviderDTO createSupplier(ProviderDTO supplier) throws Exception {
		Provider user = new Provider(supplier);
		new ProviderRepository().saveSupplier(user);
		return new ProviderDTO(user);
	}
	private List<ProviderDTO> convertUsersToDTO(List<Provider> allClients) throws Exception {
		List<ProviderDTO> result = new ArrayList<>();
		for(Provider user:allClients) {
			result.add(new ProviderDTO(user));
		}
		return result;
	}

}
