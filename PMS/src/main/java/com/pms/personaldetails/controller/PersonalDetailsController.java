/**
 * 
 */
package com.pms.personaldetails.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/user/getpersonaldetails")
//    @GetMapping("/auth/getpersonaldetails")
    public List<PersonalDetails> getAll() {
        return service.getAll();
    }

    @GetMapping("/user/getpersonaldetail/{id}")
//    @GetMapping("/auth/getpersonaldetail/{id}")
    public PersonalDetails getById(@PathVariable Long id) {
        return service.getById(id);
    }

    
    @PostMapping(value= "/user/createpersonaldetail")
    public ResponseEntity<PersonalDetails> create(@Valid @RequestBody PersonalDetails details) throws IOException {
    	  	
        return ResponseEntity.ok(service.create(details));
    }
    
    @PutMapping("/user/updatepersonaldetail/{id}")
    public ResponseEntity<PersonalDetails> update(@PathVariable Long id, @Valid @RequestBody PersonalDetails details) {
        return ResponseEntity.ok(service.update(id, details));
    }

    @DeleteMapping("/user/deletepersonaldetail/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
    	boolean isDeleted=  service.delete(id);
        if (isDeleted) {
			String responseContent = "personaldetail has been deleted successfully";
			return new ResponseEntity<String>(responseContent, HttpStatus.OK);
		}
		String error = "Error while deleting personaldetail from database";
		return new ResponseEntity<String>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/user/personaldetail/search")
    public List<PersonalDetails> searchPersonalDetails(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String address) {

        return service.search(firstName,lastName, email, phone, address);
    }
    
}

