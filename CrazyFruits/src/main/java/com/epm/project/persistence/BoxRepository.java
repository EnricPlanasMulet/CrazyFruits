package com.epm.project.persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.epm.project.application.dto.BoxDTO;
import com.epm.project.domain.Box;

public class BoxRepository {

	private static Set<Box> boxes = new HashSet<>();

	public Box getBox(String id) throws NotFoundException {
		for(Box b:boxes) {
			if(b.getId().equals(id)) {
				return b;
			}
		}
		throw new NotFoundException();
	}
	public void updateBox(String id,BoxDTO box) throws Exception {
		for(Box b:boxes) {
			if(b.getId().equals(id)) {
				boxes.remove(b);
				boxes.add(new Box(box));return;
			}
		}
		throw new NotFoundException();
	}
	public List<Box> getAllBoxes(){
		return new ArrayList<>(boxes);
	}
	public void addBox(Box box) throws InvalidParamException {
		if(box==null)throw new InvalidParamException();
		boxes.add(box);
	}
	public void deleteBox(String id) throws NotFoundException {
		for(Box b:new ArrayList<>(boxes)) {
			if(b.getId().equals(id)) {
				boxes.remove(b);
				return;
			}
		}
		throw new NotFoundException();

	}

}