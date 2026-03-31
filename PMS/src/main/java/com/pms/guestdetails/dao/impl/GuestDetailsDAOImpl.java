/**
 * 
 */
package com.pms.guestdetails.dao.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pms.document.dao.DocumentDetailsRepository;
import com.pms.document.entity.DocumentDetails;
import com.pms.guestdetails.GuestDetails;
import com.pms.guestdetails.dao.IGuestDetailsDAO;
import com.pms.personaldetails.PersonalDetails;
import com.pms.personaldetails.PersonalDetailsRepository;
import com.pms.rent.RentDetails;
import com.pms.rent.dao.impl.RentDetailsRepository;
import com.pms.room.dao.impl.RoomMasterRepository;
import com.pms.room.entity.RoomMaster;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * 
 */
@Transactional
@Repository
public class GuestDetailsDAOImpl implements IGuestDetailsDAO {
	
	static final Logger logger = LoggerFactory.getLogger(GuestDetailsDAOImpl.class);
	
	@Autowired
	private GuestDetailsRepository guestDetailsRepository;
	
	@Autowired
	private RoomMasterRepository roomMasterRepository;
	
	@Autowired
	private PersonalDetailsRepository personalDetailsRepository;
	
	@Autowired
	private DocumentDetailsRepository documentDetailsRepository;
	
	@Autowired
	private RentDetailsRepository rentDetailsRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<GuestDetails> getGuestDetails(){
		
//		String hql = "FROM GuestDetails as atcl ORDER BY atcl.id";
		return  guestDetailsRepository.findAll();
	}
	
	public GuestDetails getGuestDetail(int guestDetailsId) {
		return entityManager.find(GuestDetails.class, guestDetailsId);
	}
	
	@Override
	public GuestDetails createGuestDetails(GuestDetails guestDetails) {
		
//		entityManager.persist(guestDetails);
//		GuestDetails b = getLastInsertedGuestDetail();
		
		GuestDetails b = guestDetailsRepository.saveAndFlush(guestDetails);
		Optional<DocumentDetails> details = documentDetailsRepository.findById(b.getDocumentId());
		
		details.ifPresent(doc -> {
		    // use doc
			b.setDocumentDetails(doc);
		});
		
		Optional<RentDetails> rDetails = rentDetailsRepository.findById(b.getRentId());
		rDetails.ifPresent(rent -> {
		    // use doc
			b.setRentDetails(rent);
		});
		
		Optional<PersonalDetails> pDetails = personalDetailsRepository.findById((long) b.getPersonalDetailsId());
		pDetails.ifPresent(pdet -> {
		    // use doc
			b.setPersonalDetails(pdet);
		});
		
		Optional<RoomMaster> roomMaster= roomMasterRepository.findById(b.getRoomMasterId());
		
			roomMaster.ifPresent(rmaster -> {
		    // use doc
			b.setRoomMaster(rmaster);
		});
		
		return b;
	}
	
	@Override
	public GuestDetails updateGuestDetails(int guestDetailsId,GuestDetails guestDetails) {
		
		GuestDetails guestDetailsDB = getGuestDetail(guestDetailsId);
		guestDetailsDB.setCheckInDate(guestDetails.getCheckInDate());
		guestDetailsDB.setCheckInTime(guestDetails.getCheckInTime());
		guestDetailsDB.setCheckOutDate(guestDetails.getCheckOutDate());
		guestDetailsDB.setCheckOutTime(guestDetails.getCheckOutTime());
		guestDetailsDB.setDocumentDetails(guestDetails.getDocumentDetails());
		guestDetailsDB.setGuestDetailsStats(guestDetails.getGuestDetailsStats());
		guestDetailsDB.setPersonalDetails(guestDetails.getPersonalDetails());
		guestDetailsDB.setRentDetails(guestDetails.getRentDetails());
		guestDetailsDB.setRoomMaster(guestDetails.getRoomMaster());
		
		entityManager.flush();
		GuestDetails updatedGuestDetails = getGuestDetail(guestDetailsId);
		return updatedGuestDetails;
	}
	
	@Override
	public boolean deleteGuestDetails(int guestDetailsId) {
		
		GuestDetails guestDetails = getGuestDetail(guestDetailsId);
		entityManager.remove(guestDetails);
		
		//we are checking here that whether entityManager contains earlier deleted book or not
		// if contains then book is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(guestDetails);
		if(status){
			return false;
		}
		return true;
	}
	
	
	public GuestDetails findById(Integer id) {
		
		return entityManager.find(GuestDetails.class, id);
	}

	
	private GuestDetails getLastInsertedGuestDetail(){
		String hql = "from GuestDetails order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
		GuestDetails guestDetails = (GuestDetails)query.getSingleResult();
		return guestDetails;
	}

	

	

	

	

	

	
	
}
