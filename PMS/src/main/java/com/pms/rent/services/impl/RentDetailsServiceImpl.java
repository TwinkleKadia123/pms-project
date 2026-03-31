/**
 * 
 */
package com.pms.rent.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pms.rent.RentDetails;
import com.pms.rent.dao.IRentDetailsDAO;
import com.pms.rent.dao.impl.RentDetailsRepository;
import com.pms.rent.services.IRentDetailsService;
import com.pms.room.dao.IRoomMasterDAO;
import com.pms.room.dao.impl.RoomMasterRepository;
import com.pms.room.entity.RoomMaster;

/**
 * 
 */
@Service
public class RentDetailsServiceImpl implements IRentDetailsService {
	
	@Autowired
	private IRentDetailsDAO dao;
	
	@Autowired
	RentDetailsRepository rentDetailsRepository;

	public RentDetailsServiceImpl(IRentDetailsDAO dao, RentDetailsRepository rentDetailsRepository) {
		super();
		this.dao = dao;
		this.rentDetailsRepository = rentDetailsRepository;
	}
	
	@Override
	public List<RentDetails> getRentDetails() {
		return rentDetailsRepository.findAll();
	}
	
	public RentDetails createRentDetail(RentDetails rentDetail) {
		
		return dao.createRentDetail(rentDetail);
	}
	
	@Override
	public RentDetails updateRentDetail(int rentDetailsId, RentDetails rentDetail) {
		return dao.updateRentDetail(rentDetailsId, rentDetail);
	}
	
	public RentDetails getRentDetail(int rentDetailsId) {
		return dao.getRentDetail(rentDetailsId);
	}

	@Override
	public boolean deleteRentDetail(int rentDetailsId) {
		return dao.deleteRentDetail(rentDetailsId);
	}
	
	@Override
	public RentDetails findById(Integer id) {
		return dao.findById(id);
	}

}
