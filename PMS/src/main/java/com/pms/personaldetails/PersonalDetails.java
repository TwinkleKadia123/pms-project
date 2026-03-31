/**
 * 
 */
package com.pms.personaldetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pms.floor.entity.Floor;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="personal_details")
public class PersonalDetails {
	
static final Logger logger = LoggerFactory.getLogger(PersonalDetails.class);
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "firstname is required")
    @Column(nullable = false)
    private String firstName;
    
    @NotBlank(message = "lastname is required")
    @Column(nullable = false)
    private String lastName;
    
    @NotBlank(message = "company name is required")
    @Column(nullable = false)
    private String companyName;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;
  
    @Email(message = "Invalid email format")
    @Column(unique = false, nullable = false)
    private String email;
    
    private String address;

    @Column(unique = true, nullable = true)
    private String profilePhoto;
    
    @Column(unique = true, nullable = true)
    private String signature;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
