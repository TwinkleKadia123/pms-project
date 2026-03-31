/**
 * 
 */
package com.pms.personaldetails.impl;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pms.personaldetails.IPersonalDetailsService;
import com.pms.personaldetails.PersonalDetails;
import com.pms.personaldetails.PersonalDetailsRepository;
import com.pms.search.specification.PersonalDetailsSpecification;

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
//	        existing.setPersonalDetailName(details.getPersonalDetailName());
	        existing.setFirstName(details.getFirstName());
	        existing.setLastName(details.getLastName());	        
	        existing.setEmail(details.getEmail());
	        existing.setPhone(details.getPhone());
	        existing.setAddress(details.getAddress());
	        return repository.save(existing);
	    }

	    public boolean delete(Long id) {
	    	 repository.deleteById(id);
	    	 return true;
	    }
	    
	    public List<PersonalDetails> search(String firstName,String lastName, String email, String phone, String address) {
	        Specification<PersonalDetails> spec = Specification
	                .where(PersonalDetailsSpecification.hasFirstName(firstName))
	                .and(PersonalDetailsSpecification.hasLastName(lastName))
	                .and(PersonalDetailsSpecification.hasEmail(email))
	                .and(PersonalDetailsSpecification.hasPhone(phone))
	                .and(PersonalDetailsSpecification.hasAddress(address));

	        return repository.findAll(spec);
	    }
	    
}
