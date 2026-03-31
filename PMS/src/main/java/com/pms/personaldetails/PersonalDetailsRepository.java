package com.pms.personaldetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long>, JpaSpecificationExecutor<PersonalDetails> {

}
