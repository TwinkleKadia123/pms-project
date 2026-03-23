/**
 * 
 */
package com.pms.personaldetails.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pms.personaldetails.IPersonalDetailsService;
import com.pms.personaldetails.PersonalDetails;
import com.pms.personaldetails.PersonalDetailsRepository;

/**
 * 
 */
@Service
public class PersonalDetailsServiceImpl implements IPersonalDetailsService {

	
	 private final PersonalDetailsRepository repository;

	    public PersonalDetailsServiceImpl(PersonalDetailsRepository repository) {
	        this.repository = repository;
	    }

	    public List<PersonalDetails> getAll() {
	        return repository.findAll();
	    }

	    public PersonalDetails getById(Long id) {
	        return repository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Record not found with id " + id));
	    }

	    public PersonalDetails create(PersonalDetails details) {
	        return repository.saveAndFlush(details);
	        
	    }

	    public PersonalDetails update(Long id, PersonalDetails details) {
	        PersonalDetails existing = getById(id);
	        existing.setPersonalDetailName(details.getPersonalDetailName());
	        existing.setEmail(details.getEmail());
	        existing.setPhone(details.getPhone());
	        existing.setAddress(details.getAddress());
	        return repository.save(existing);
	    }

	    public boolean delete(Long id) {
	    	 repository.deleteById(id);
	    	 return true;
	    }
}
