package com.panaromafinance.member.advise;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemberControllerAdvice {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> emptyResultDataAccessException(
			EmptyResultDataAccessException emptyResultDataAccessException) {

		return new ResponseEntity<String>("Input is empty. Please add an input", HttpStatus.BAD_REQUEST);

	}
}
