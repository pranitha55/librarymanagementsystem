package com.capgemini.librarymanagementsystem_springlms.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.librarymanagementsystem_springlms.dto.LMSResponse;
import com.capgemini.librarymanagementsystem_springlms.exception.LMSException;

@RestControllerAdvice
public class LMSController {
	
	@ExceptionHandler
	public LMSResponse myExceptionHandler(LMSException lmsException) {
		LMSResponse response = new LMSResponse();
		response.setError(true);
		response.setMessage(lmsException.getMessage());
	
		return response;
	
	}

}
