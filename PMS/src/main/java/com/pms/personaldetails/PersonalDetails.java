/**
 * 
 */
package com.pms.personaldetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */

@Entity
@Table(name = "personal_details", schema = "pms_db")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required")
    @Column(nullable = false)
    private String personalDetailName;
    
    @NotBlank(message = "company name is required")
    @Column(nullable = false)
    private String companyName;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;
  
    @Email(message = "Invalid email format")
    @Column(unique = false, nullable = false)
    private String email;
    
    private String address;
    
    
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPersonalDetailName() {
		return personalDetailName;
	}


	public void setPersonalDetailName(String personalDetailName) {
		this.personalDetailName = personalDetailName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
