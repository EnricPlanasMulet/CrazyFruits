package com.epm.crazyfruits.domain.person;

import java.util.ArrayList;
import java.util.List;

import com.epm.crazyfruits.application.dto.ProviderDTO;
import com.epm.crazyfruits.domain.Order;
import com.epm.crazyfruits.persistence.InvalidParamException;

public class Provider {

	private String id, name, lastName, dni, username, password;

	public List<Order> orders;

	public Provider(ProviderDTO supplierDTO) throws Exception {
		if(supplierDTO==null)throw new InvalidParamException();
		this.id=supplierDTO.getId();
		this.name=supplierDTO.getName();
		this.lastName=supplierDTO.getLastName();
		this.dni=supplierDTO.getDni();
		this.username=supplierDTO.getUsername();
		this.password=supplierDTO.getPassword();
		orders=new ArrayList<Order>();
		this.orders=supplierDTO.getOrders();
	}
	public void update(ProviderDTO p) throws InvalidParamException {
		setDni(p.getDni());
		setName(p.getName());
		setLastName(p.getLastName());
		setPassword(p.getPassword());
		setUsername(p.getUsername());
	}
	public void setName(String name) throws InvalidParamException {
		if(name.isEmpty())throw new InvalidParamException();
		this.name = name;
	}

	public void setLastName(String lastName) throws InvalidParamException {
		if(lastName.isEmpty())throw new InvalidParamException();
		this.lastName = lastName;
	}

	public void setDni(String dni) throws InvalidParamException {
		if(dni.isEmpty())throw new InvalidParamException();
		this.dni = dni;
	}

	public void setUsername(String username) throws InvalidParamException {
		if(username.isEmpty())throw new InvalidParamException();
		this.username = username;
	}

	public void setPassword(String password) throws InvalidParamException {
		if(password.isEmpty())throw new InvalidParamException();
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDni() {
		return dni;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	public Order getOrder(Order o) {
		if(orders==null)orders=new ArrayList<Order>();
		for(Order order:orders) {
			if(order.getId().equals(o.getId())) {
				return order;
			}
		}
		return null;
	}

	public List<Order> getOrders() {
		if(orders==null)orders=new ArrayList<Order>();
		return orders;
	}
	public boolean addOrder(Order o) {
		if(o==null)return false;
		if(orders==null)orders=new ArrayList<Order>();
		return orders.add(o);
	}
}