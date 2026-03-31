/**
 * 
 */
package com.pms.stay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pms.stay.entity.StayDetails;

/**
 * 
 */
public interface StayDetailsRepository extends JpaRepository<StayDetails, Integer> , JpaSpecificationExecutor<StayDetails>{

}
