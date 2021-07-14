package com.epm.project.domain.person;

import java.util.ArrayList;
import java.util.List;

import com.epm.project.application.dto.ClientDTO;
import com.epm.project.domain.Box;
import com.epm.project.persistence.InvalidParamException;

public class Client {

	private String id, name, lastName, dni, username, password;

	private List<Box> buyedBoxes;

	public Client(ClientDTO clientDTO) throws Exception {
		if(clientDTO==null)throw new InvalidParamException();
		this.id=clientDTO.getId();
		this.name=clientDTO.getName();
		this.lastName=clientDTO.getLastName();
		this.dni=clientDTO.getDni();
		this.username=clientDTO.getUsername();
		this.password=clientDTO.getPassword();
		buyedBoxes=new ArrayList<Box>();
		this.buyedBoxes=clientDTO.getBuyedBoxes();
	}
	public void update(ClientDTO c) throws InvalidParamException {
		setDni(c.getDni());
		setName(c.getName());
		setLastName(c.getLastName());
		setPassword(c.getPassword());
		setUsername(c.getUsername());
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

	public void buyBox(String fruit1,String fruit2,String fruit3) throws Exception {
		Box box=new Box();
		box.completeBox(fruit1, fruit2, fruit3);
		buyedBoxes.add(box);
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

	public List<Box> getBuyedBoxes() {
		return buyedBoxes;
	}

	public void addBuyedBoxes(Box buyedBoxes) {
		this.buyedBoxes.add(buyedBoxes);
	}
	public Box getFruit(Box b) {
		if(buyedBoxes.contains(b)) {
			return b;
		}
		else return null;
	}

}