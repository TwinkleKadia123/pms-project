/**
 * 
 */
package com.pms.personaldetails.controller;

import java.util.List;

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

import com.pms.personaldetails.IPersonalDetailsService;
import com.pms.personaldetails.PersonalDetails;

/**
 * 
 */

import jakarta.validation.Valid;

@RestController
public class PersonalDetailsController {

    private final IPersonalDetailsService service;

    public PersonalDetailsController(IPersonalDetailsService service) {
        this.service = service;
    }

    
    @GetMapping("/auth/getpersonaldetails")
    public List<PersonalDetails> getAll() {
        return service.getAll();
    }

    @GetMapping("/auth/getpersonaldetail/{id}")
    public PersonalDetails getById(@PathVariable Long id) {
        return service.getById(id);
    }

    
    @PostMapping("/user/createpersonaldetail")
    public ResponseEntity<PersonalDetails> create(@Valid @RequestBody PersonalDetails details) {
        return ResponseEntity.ok(service.create(details));
    }

    @PutMapping("/auth/updatepersonaldetail/{id}")
    public ResponseEntity<PersonalDetails> update(@PathVariable Long id, @Valid @RequestBody PersonalDetails details) {
        return ResponseEntity.ok(service.update(id, details));
    }

    @DeleteMapping("/auth/deletepersonaldetail/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
    	boolean isDeleted=  service.delete(id);
        if (isDeleted) {
			String responseContent = "personaldetail has been deleted successfully";
			return new ResponseEntity<String>(responseContent, HttpStatus.OK);
		}
		String error = "Error while deleting personaldetail from database";
		return new ResponseEntity<String>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

