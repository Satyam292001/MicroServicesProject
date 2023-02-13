package com.hotel.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.hotel.payload.ApiResponsse;

@RestControllerAdvice
public class GlobalResourceException {

	@ExceptionHandler(ResourceNotFound.class)
//	public ResponseEntity<ApiResponsse> handlerResourceNotFound(ResourceNotFound ex)
//	{
//		String message=ex.getMessage();
//		ApiResponsse response= ApiResponsse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND);
//		return new ResponseEntity<ApiResponsse>(response,HttpStatus.NOT_FOUND);
//	}
	public ResponseEntity<Map<String, Object>> handlerResourceNotFound(ResourceNotFound ex)
	{
		Map map=new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("success", false);
		map.put("status", HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}
