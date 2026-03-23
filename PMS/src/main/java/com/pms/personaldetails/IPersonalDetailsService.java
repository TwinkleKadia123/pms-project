/**
 * 
 */
package com.pms.personaldetails;

import java.util.List;

/**
 * 
 */
public interface IPersonalDetailsService {
	
	 public List<PersonalDetails> getAll();
	 public PersonalDetails getById(Long id);
	 public PersonalDetails create(PersonalDetails details);
	 public PersonalDetails update(Long id, PersonalDetails details);
	 public boolean delete(Long id);
	
	

}
