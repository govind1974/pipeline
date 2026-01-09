package com.example.demo.web;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MyController {
    record DateDto(String date, String time) {}
    record EmpDto(Integer empId, String empName, Double empSal) {}
    
    @GetMapping("/viewdt")
	public ResponseEntity<DateDto> getCurrentDateTime(){
		LocalDate ldt = LocalDate.now();
		String dt = ldt.format(DateTimeFormatter.ofPattern("d-M-yyyy"));
		LocalTime ltm = LocalTime.now();
		String tm = ltm.format(DateTimeFormatter.ofPattern("H-m-s"));
		DateDto dto = new DateDto(dt, tm);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
    
    @GetMapping("/viewempbyid/{eid}")
    public ResponseEntity<EmpDto> getEmp(@PathVariable Integer eid) {
    	    Map<Integer, EmpDto> map = new HashMap<>();
    	    map.put(1001, new EmpDto(1001, "rama", 56000.0));
    	    map.put(1002, new EmpDto(1002, "tom", 46000.0));
    	    map.put(1003, new EmpDto(1003, "sam", 66000.0));
    	    if (map.containsKey(eid)) {
    	    	    return new ResponseEntity<>(map.get(eid), HttpStatus.OK);
    	    }
    	    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/viewall")
    public ResponseEntity<List<EmpDto>> getAllEmp() {
    	    Map<Integer, EmpDto> map = new HashMap<>();
    	    map.put(1001, new EmpDto(1001, "rama", 56000.0));
    	    map.put(1002, new EmpDto(1002, "tom", 46000.0));
    	    map.put(1003, new EmpDto(1003, "sam", 66000.0));
    	    List<EmpDto> lst = new ArrayList<>(map.values()); 
    	    	return new ResponseEntity<>(lst, HttpStatus.OK);
    	    
    }
}




