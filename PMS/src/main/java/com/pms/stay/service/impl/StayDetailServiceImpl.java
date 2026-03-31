/**
 * 
 */
package com.pms.stay.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.stay.dao.IStatyDetailsDAO;
import com.pms.stay.dao.StayDetailsRepository;
import com.pms.stay.entity.StayDetails;
import com.pms.stay.service.IStayDetailsService;

/**
 * 
 */
@Service
public class StayDetailServiceImpl  implements IStayDetailsService {
	
static final Logger logger = LoggerFactory.getLogger(StayDetailServiceImpl.class);
	
	@Autowired
	private IStatyDetailsDAO dao;
	
	public StayDetailServiceImpl(IStatyDetailsDAO dao, StayDetailsRepository stayDetailsRepository) {
		this.dao = dao;
	}

	public List<StayDetails> getStayDetails() {
		return dao.getStayDetails();
	}

	public StayDetails createStayDetails(StayDetails stayDetails) {
		
		return dao.createStayDetails(stayDetails);
	}

	public StayDetails updateStayDetails(int stayDetailsId, StayDetails stayDetails) {
		return dao.updateStayDetails(stayDetailsId, stayDetails);
	}

	public StayDetails getStayDetail(int stayDetailsId) {
		return dao.getStayDetail(stayDetailsId);
	}

	public boolean deleteStayDetails(int stayDetailsId) {
		return dao.deleteStayDetails(stayDetailsId);
	}

	public StayDetails findById(Integer id) {
		return dao.findById(id);
	}

}
