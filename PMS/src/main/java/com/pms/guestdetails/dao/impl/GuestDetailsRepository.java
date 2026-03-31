/**
 * 
 */
package com.pms.guestdetails.dao.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pms.guestdetails.GuestDetails;

/**
 * 
 */
public interface GuestDetailsRepository extends JpaRepository<GuestDetails, Integer>, JpaSpecificationExecutor<GuestDetails>{ 

}
