package com.epm.project.persistence;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason="Not valid")
public class InvalidParamException extends Exception {
	public InvalidParamException(){

	}
}
