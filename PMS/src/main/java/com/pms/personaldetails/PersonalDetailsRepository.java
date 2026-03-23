package com.pms.personaldetails;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.booking.service.IBookingService;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {

}
