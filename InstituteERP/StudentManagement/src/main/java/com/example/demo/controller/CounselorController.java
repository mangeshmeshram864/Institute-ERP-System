package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.CounsellorDto;
import com.example.demo.entity.Counsellor;
import com.example.demo.interfaces.CounselorService;

@RestController
@RequestMapping("/admin")
public class CounselorController {

    @Autowired
    private CounselorService service;
    
    @PostMapping("/add")
    public ResponseEntity<String> addCounsellor(
            @RequestBody CounsellorDto dto) {

        return ResponseEntity.ok(service.addCounsellor(dto));
    }
    
    @DeleteMapping("/removeCounsellor/{id}")
    public ResponseEntity<String> deleteCounsellor(@PathVariable long id){
    	return ResponseEntity.ok(service.deleteCounsellor(id));
    	
    }
    
    @PutMapping("/updateCounsellor/{id}")
    public ResponseEntity<String> updateCounsellor(@PathVariable long id, @RequestBody Counsellor counsellor){
		 return ResponseEntity.ok(service.updateCounsellor(id ,counsellor));
    	
    }
    
    @GetMapping("/getCounsellor/{id}")
    public ResponseEntity<Counsellor> getCounsellor(@PathVariable long id){
		return new ResponseEntity<Counsellor>(service.getCounsellor(id) , HttpStatus.OK);
    	
    }
    
    @GetMapping("/counsellors")
    public ResponseEntity<List<Counsellor>> getCounsellors(){
    	return new ResponseEntity<List<Counsellor>>(service.getCounsllors(), HttpStatus.OK);
    }
    
    

   
}
