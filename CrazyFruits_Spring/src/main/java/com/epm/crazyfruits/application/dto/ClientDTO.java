package com.epm.crazyfruits.application.dto;

import java.util.ArrayList;
import java.util.List;

import com.epm.crazyfruits.domain.Box;
import com.epm.crazyfruits.domain.person.Client;
import com.epm.crazyfruits.persistence.InvalidParamException;

public class ClientDTO {
	private String id, name, lastName, dni, username, password;
	private List<Box> buyedBoxes;

	public ClientDTO() {}

	public ClientDTO(Client client) throws InvalidParamException {
		if(client==null)throw new InvalidParamException();
		this.id=client.getId();
		this.name=client.getName();
		this.lastName=client.getLastName();
		this.dni=client.getDni();
		this.username=client.getUsername();
		this.password=client.getPassword();
		buyedBoxes=new ArrayList<Box>();
		this.buyedBoxes=client.getBuyedBoxes();
	}
	public String getId() throws InvalidParamException {
		if(!checkEmpty(id))throw new InvalidParamException();
		return id;
	}
	public String getName() throws InvalidParamException {
		if(!checkName(name))throw new InvalidParamException();
		return name;
	}
	public String getLastName() throws InvalidParamException {
		if(!checkName(lastName))throw new InvalidParamException();
		return lastName;
	}
	public String getDni() throws InvalidParamException {
		if(!checkDni(dni))throw new InvalidParamException();
		return dni;
	}
	public String getUsername() throws InvalidParamException {
		if(!checkEmpty(username))throw new InvalidParamException();
		return username;
	}
	public String getPassword() throws InvalidParamException {
		if(!checkEmpty(password))throw new InvalidParamException();
		return password;
	}
	public List<Box> getBuyedBoxes() {
		return buyedBoxes;
	}
	private boolean checkEmpty(String s) {
		if(s==null||s.isEmpty())return false;
		else return true;
	}
	private boolean checkName(String name) {
		if(!checkEmpty(name))return false;
		for(int i = 0; i < name.length(); i++) {
			if(!Character.isLetter(name.charAt(i)))return false;
		}
		return true;
	}
	private boolean checkDni(String dni) {
		if(!checkEmpty(dni))return false;
		int numero = 0, lletra = 0;
		for (int i = 0; i < dni.length(); i++) {
			if(Character.isDigit(dni.charAt(i)))numero++;
			else if(Character.isLetter(dni.charAt(i)))lletra++;
		}
		return numero == 8 && lletra == 1;
	}
}
