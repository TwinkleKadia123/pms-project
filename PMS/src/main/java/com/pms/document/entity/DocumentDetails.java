/**
 * 
 */
package com.pms.document.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pms.personaldetails.PersonalDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="document_details")
public class DocumentDetails {
	
static final Logger logger = LoggerFactory.getLogger(DocumentDetails.class);
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="document_id")
	private int id;
	
	@NotNull(message = "Document type is required")
	@Enumerated(EnumType.STRING) // Store enum name as text in DB
	private DocumentTypeEnum documentTypeEnum;
	
	@Column(name="document_number")
	private String documentNumber;
	
	@Column(name="valid_till")
	private Date validTill;
	
	@Column(name="front_image_path")
	private String frontImagePath;
	
	@Column(name="back_image_path")
	private String backImagePath;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="created_on", nullable = false, updatable = false)
	@CreationTimestamp // Automatically sets value when entity is persisted
	private Date createdOn;
	
	@ManyToOne
    @JoinColumn(name = "personal_details_id", insertable = false, updatable = false)
    private PersonalDetails personalDetails;
	
	@Column(name="personal_details_id")
	private Integer personalDetailsId;
	
	
	public Integer getPersonalDetailsId() {
		return personalDetailsId;
	}

	public void setPersonalDetailsId(Integer personalDetailsId) {
		this.personalDetailsId = personalDetailsId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DocumentTypeEnum getDocumentTypeEnum() {
		return documentTypeEnum;
	}

	public void setDocumentTypeEnum(DocumentTypeEnum documentTypeEnum) {
		this.documentTypeEnum = documentTypeEnum;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	public String getFrontImagePath() {
		return frontImagePath;
	}

	public void setFrontImagePath(String frontImagePath) {
		this.frontImagePath = frontImagePath;
	}

	public String getBackImagePath() {
		return backImagePath;
	}

	public void setBackImagePath(String backImagePath) {
		this.backImagePath = backImagePath;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DocumentDetails [id=");
		builder.append(id);
		builder.append(", documentTypeEnum=");
		builder.append(documentTypeEnum);
		builder.append(", documentNumber=");
		builder.append(documentNumber);
		builder.append(", validTill=");
		builder.append(validTill);
		builder.append(", frontImagePath=");
		builder.append(frontImagePath);
		builder.append(", backImagePath=");
		builder.append(backImagePath);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", personalDetails=");
		builder.append(personalDetails);
		builder.append("]");
		return builder.toString();
	}

}