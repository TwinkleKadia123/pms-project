/**
 * 
 */
package com.pms.guestdetails.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.guestdetails.GuestDetails;
import com.pms.guestdetails.dao.IGuestDetailsDAO;
import com.pms.guestdetails.dao.impl.GuestDetailsRepository;
import com.pms.guestdetails.service.IGuestDetailsService;

/**
 * 
 */
@Service
public class GuestDetalsServiceImpl implements IGuestDetailsService {
	
	@Autowired
	private IGuestDetailsDAO dao;
	
	@Autowired
	GuestDetailsRepository guestDetailsRepository;

	public GuestDetalsServiceImpl(IGuestDetailsDAO dao, GuestDetailsRepository guestDetailsRepository) {
		super();
		this.dao = dao;
		this.guestDetailsRepository = guestDetailsRepository;
	}
	
	@Override
	public List<GuestDetails> getGuestDetails() {
		return guestDetailsRepository.findAll();
	}
	
	@Override
	public GuestDetails getGuestDetail(int guestDetailsId) {
		return dao.getGuestDetail(guestDetailsId);
	}
	
	public GuestDetails createGuestDetail(GuestDetails guestDetails) {
		
		return dao.createGuestDetails(guestDetails);
	}
	
	public GuestDetails updateGuestDetails(int guestDetailsId, GuestDetails guestDetails) {
		return dao.updateGuestDetails(guestDetailsId, guestDetails);
	}
	
	
	public boolean deleteGuestDetail(int guestDetailsId)
	{ 
		return dao.deleteGuestDetails(guestDetailsId);
	}
	
	public GuestDetails findById(Integer id)
	{
		return dao.findById(id);
	}


}
