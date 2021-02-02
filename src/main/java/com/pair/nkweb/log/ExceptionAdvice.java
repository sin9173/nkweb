package com.pair.nkweb.log;

import com.pair.nkweb.responsevo.BasicVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestControllerAdvice("com.pair.nkweb.controller")
@Slf4j
public class ExceptionAdvice {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public BasicVO common(Exception e) {
		
		StringWriter errors = new StringWriter();
		
		e.printStackTrace(new PrintWriter(errors));
		log.error("controller: " + errors.toString());
		
		return BasicVO.builder()
				.result("110")
				.message(errors.toString())
				.build();
		
	}
}
