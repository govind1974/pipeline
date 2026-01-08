package com.example.demo.web;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    record DateDto(String date, String time) {}
    
    @GetMapping("/viewdt")
	public ResponseEntity<DateDto> getCurrentDateTime(){
		LocalDate ldt = LocalDate.now();
		String dt = ldt.format(DateTimeFormatter.ofPattern("d-M-yyyy"));
		LocalTime ltm = LocalTime.now();
		String tm = ldt.format(DateTimeFormatter.ofPattern("H-m-s"));
		DateDto dto = new DateDto(dt, tm);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}




