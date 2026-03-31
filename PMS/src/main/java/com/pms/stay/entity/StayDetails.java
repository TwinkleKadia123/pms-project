/**
 * 
 */
package com.pms.stay.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pms.building.entity.Building;
import com.pms.floor.entity.Floor;
import com.pms.room.entity.RoomMaster;
import com.pms.roomtype.entity.RoomType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
@Table(name="stay_details")
public class StayDetails {
	
	static final Logger logger = LoggerFactory.getLogger(StayDetails.class);
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="floor_id", nullable = false)
    private Integer floorId;
    
    @Column(name="building_id",nullable = false)
    private Integer buildingId;
    
    @Column(name="room_type_id",nullable = false)
    private Integer roomTypeId;
    
    @Column(name="room_master_id",nullable = false)
    private Integer roomMasterId;
    
    @Column(name="comment",nullable = false)
    private String comment;
    
    @NotNull(message = "RATE type is required")
	@Enumerated(EnumType.STRING) // Store enum name as text in DB
    @Column(nullable = false)
    private RateTypeEnum rateTypeEnum;
    
    @NotNull(message = "STAY status is required")
   	@Enumerated(EnumType.STRING) // Store enum name as text in DB
    @Column(nullable = false)
     private StayStatuEnum stayStatuEnum;
    
    @Column(name="created_on", nullable = false, updatable = false)
	@CreationTimestamp // Automatically sets value when entity is persisted
	private Date createdOn;
    
    @Column(nullable = false)
    private Integer noOfGuest;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
    @JoinColumn(name = "floor_id", insertable = false, updatable = false)
    private Floor floor;
	
	public Integer getFloorId() {
		return floorId;
	}

	public void setFloorId(Integer floorId) {
		this.floorId = floorId;
	}

	@ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    private Building building;
	
	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	@ManyToOne
    @JoinColumn(name = "room_type_id", insertable = false, updatable = false)
    private RoomType roomType;
	
	public Integer getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	@ManyToOne
    @JoinColumn(name = "room_master_id", insertable = false, updatable = false)
    private RoomMaster roomMaster;
	
	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public RoomMaster getRoomMaster() {
		return roomMaster;
	}

	public void setRoomMaster(RoomMaster roomMaster) {
		this.roomMaster = roomMaster;
	}

	public Integer getRoomMasterId() {
		return roomMasterId;
	}

	public void setRoomMasterId(Integer roomMasterId) {
		this.roomMasterId = roomMasterId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public RateTypeEnum getRateTypeEnum() {
		return rateTypeEnum;
	}

	public void setRateTypeEnum(RateTypeEnum rateTypeEnum) {
		this.rateTypeEnum = rateTypeEnum;
	}

	public StayStatuEnum getStayStatuEnum() {
		return stayStatuEnum;
	}

	public void setStayStatuEnum(StayStatuEnum stayStatuEnum) {
		this.stayStatuEnum = stayStatuEnum;
	}

	public Integer getNoOfGuest() {
		return noOfGuest;
	}

	public void setNoOfGuest(Integer noOfGuest) {
		this.noOfGuest = noOfGuest;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StayDetails [id=");
		builder.append(id);
		builder.append(", floorId=");
		builder.append(floorId);
		builder.append(", buildingId=");
		builder.append(buildingId);
		builder.append(", roomTypeId=");
		builder.append(roomTypeId);
		builder.append(", roomMasterId=");
		builder.append(roomMasterId);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", rateTypeEnum=");
		builder.append(rateTypeEnum);
		builder.append(", stayStatuEnum=");
		builder.append(stayStatuEnum);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", noOfGuest=");
		builder.append(noOfGuest);
		builder.append(", floor=");
		builder.append(floor);
		builder.append(", building=");
		builder.append(building);
		builder.append(", roomType=");
		builder.append(roomType);
		builder.append(", roomMaster=");
		builder.append(roomMaster);
		builder.append("]");
		return builder.toString();
	}

}
