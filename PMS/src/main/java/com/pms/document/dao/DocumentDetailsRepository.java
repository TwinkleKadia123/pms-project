/**
 * 
 */
package com.pms.document.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pms.document.entity.DocumentDetails;

/**
 * 
 */
public interface DocumentDetailsRepository extends JpaRepository<DocumentDetails, Integer> , JpaSpecificationExecutor<DocumentDetails>{
	
}
