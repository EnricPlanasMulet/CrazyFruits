package com.epm.crazyfruits.persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.epm.crazyfruits.domain.person.Provider;

public class ProviderRepository {
	private static Set<Provider> suppliers = new HashSet<>();

	public Provider getSupplier(String id) throws NotFoundException {
		for(Provider c:suppliers) {
			if(c.getId().equals(id)) {
				return c;
			}
		}
		throw new NotFoundException();
	}
	public List<Provider> getAllSupplier(){
		return new ArrayList<>(suppliers);
	}
	public void saveSupplier(Provider supplier) throws InvalidParamException {
		if(supplier==null)throw new InvalidParamException();
		suppliers.add(supplier);
	}
	public void deleteSupplier(String id) throws NotFoundException {
		for(Provider c:new ArrayList<>(suppliers)) {
			if(c.getId().equals(id)) {
				suppliers.remove(c);
				return;
			}
		}
		throw new NotFoundException();

	}
}