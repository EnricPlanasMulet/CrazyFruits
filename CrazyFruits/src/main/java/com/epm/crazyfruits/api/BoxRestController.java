package com.epm.crazyfruits.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epm.crazyfruits.application.BoxController;
import com.epm.crazyfruits.application.dto.BoxDTO;
import com.epm.crazyfruits.persistence.InvalidParamException;
import com.epm.crazyfruits.persistence.NotFoundException;
import com.google.gson.Gson;

@RestController
public class BoxRestController {

	@GetMapping("/boxes")
	public String getAllBoxes() throws InvalidParamException {
		List<BoxDTO> allBoxes = new BoxController().getAllBoxes();
		Gson gson= new Gson();
		return gson.toJson(allBoxes);
	}
	@GetMapping("/boxes/{id}")
	public String getBox(@PathVariable String id) throws NotFoundException, InvalidParamException {
		BoxDTO box = new BoxController().getBox(id);
		Gson gson= new Gson();
		return gson.toJson(box);
	}
	@PutMapping("/boxes/{id}")
	public void updateBox(@PathVariable String id,@RequestBody String jUser) throws Exception {
		Gson gson= new Gson();
		BoxDTO box =  gson.fromJson(jUser, BoxDTO.class);
		new BoxController().updateBox(id,box);
	}
	@DeleteMapping("/boxes/{id}")
	public void deleteBox(@PathVariable String id) throws NotFoundException {
		new BoxController().deleteBox(id);
	}
	@PostMapping("/boxes")
	public String createBox(@RequestBody String jUser) throws Exception {
		Gson gson= new Gson();
		BoxDTO box =gson.fromJson(jUser, BoxDTO.class);
		box =new BoxController().createBox(box);
		return gson.toJson(box);
	}

}