package com.epm.crazyfruits.application;

import java.util.ArrayList;
import java.util.List;

import com.epm.crazyfruits.application.dto.BoxDTO;
import com.epm.crazyfruits.domain.Box;
import com.epm.crazyfruits.persistence.BoxRepository;
import com.epm.crazyfruits.persistence.InvalidParamException;
import com.epm.crazyfruits.persistence.NotFoundException;

public class BoxController {

	public BoxDTO createBox(BoxDTO box) throws Exception {
		Box b = new Box(box);
		b.completeBox(box.getFruit1(), box.getFruit2(), box.getFruit3());
		new BoxRepository().addBox(b);
		return new BoxDTO(b);
	}
	public void updateBox(String id,BoxDTO box) throws Exception {
		new BoxRepository().updateBox(id,box);
	}

	public void deleteBox(String id) throws NotFoundException {
		new BoxRepository().deleteBox(id);
	}

	public BoxDTO getBox(String id) throws NotFoundException, InvalidParamException {
		Box box =new BoxRepository().getBox(id);
		return new BoxDTO(box);
	}
	public List<BoxDTO> getAllBoxes() throws InvalidParamException {
		List<Box> allBoxes=new BoxRepository().getAllBoxes();
		return convertBoxesToDTO(allBoxes);
	}
	private List<BoxDTO> convertBoxesToDTO(List<Box> allBoxes) throws InvalidParamException {
		List<BoxDTO> result = new ArrayList<>();
		for(Box b:allBoxes) {
			result.add(new BoxDTO(b));
		}
		return result;
	}

}
