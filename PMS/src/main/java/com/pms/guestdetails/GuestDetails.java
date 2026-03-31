/**
 * 
 */
package com.pms.guestdetails;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.pms.document.entity.DocumentDetails;
import com.pms.personaldetails.PersonalDetails;
import com.pms.rent.RentDetails;
import com.pms.room.entity.RoomMaster;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="guest_details")
public class GuestDetails {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="guest_details_id")
	private int id;
	
	@Column(name="created_on", nullable = false, updatable = false)
	@CreationTimestamp // Automatically sets value when entity is persisted
	private Date createdOn;
	
	
	@ManyToOne
    @JoinColumn(name = "room_master_id", insertable = false, updatable = false)
    private RoomMaster roomMaster;
	
	@Column(name="room_master_id")
	private Integer roomMasterId;
	
	@OneToOne
    @JoinColumn(name = "personal_details_id", insertable = false, updatable = false)
    private PersonalDetails personalDetails;
	
	@Column(name="personal_details_id")
	private int personalDetailsId;
	
	@OneToOne
    @JoinColumn(name = "document_id", insertable = false, updatable = false)
    private DocumentDetails documentDetails;
	
	@Column(name="document_id")
	private int documentId;
	
	
	@OneToOne
    @JoinColumn(name = "rent_id", insertable = false, updatable = false)
    private RentDetails rentDetails;
	
	@Column(name="rent_id")
	private int rentId;
	
	
	@Column(name="check_in_date")
	private LocalDateTime checkInDate;

	@Column(name="check_out_date")
	private LocalDateTime checkOutDate;
	
	@Column(name="check_in_time")
	private LocalTime  checkInTime;
	
	@Column(name="check_out_time")
	private LocalTime checkOutTime;
	
	@Column(name="guest_details_status")
	private String guestDetailsStats;
	
	public RoomMaster getRoomMaster() {
		return roomMaster;
	}

	public void setRoomMaster(RoomMaster roomMaster) {
		this.roomMaster = roomMaster;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public DocumentDetails getDocumentDetails() {
		return documentDetails;
	}

	public void setDocumentDetails(DocumentDetails documentDetails) {
		this.documentDetails = documentDetails;
	}

	public RentDetails getRentDetails() {
		return rentDetails;
	}

	public void setRentDetails(RentDetails rentDetails) {
		this.rentDetails = rentDetails;
	}

	
	public LocalDateTime getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDateTime checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDateTime getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDateTime checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public LocalTime getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalTime checkInTime) {
		this.checkInTime = checkInTime;
	}

	public LocalTime getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalTime checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public String getGuestDetailsStats() {
		return guestDetailsStats;
	}

	public void setGuestDetailsStats(String guestDetailsStats) {
		this.guestDetailsStats = guestDetailsStats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getRoomMasterId() {
		return roomMasterId;
	}

	public void setRoomMasterId(Integer roomMasterId) {
		this.roomMasterId = roomMasterId;
	}

	public int getPersonalDetailsId() {
		return personalDetailsId;
	}

	public void setPersonalDetailsId(int personalDetailsId) {
		this.personalDetailsId = personalDetailsId;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public int getRentId() {
		return rentId;
	}

	public void setRentId(int rentId) {
		this.rentId = rentId;
	}
	
	

	
}
