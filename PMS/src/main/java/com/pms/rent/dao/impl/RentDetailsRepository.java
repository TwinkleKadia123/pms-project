/**
 * 
 */
package com.pms.rent.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pms.rent.RentDetails;

/**
 * 
 */
public interface RentDetailsRepository extends JpaRepository<RentDetails, Integer>, JpaSpecificationExecutor<RentDetails>{

}
