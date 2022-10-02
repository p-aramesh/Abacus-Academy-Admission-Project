package com.examly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Institute")
public class InstituteModel {
	
	@Id
	@SequenceGenerator(name="institution_seq_gen", sequenceName="institution_seq_gen", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="institution_seq_gen")
	private int instituteId;
	
	
//	@Column(unique=true)
	private String instituteName;
	
	private String instituteDescription;
	
	private String instituteAddress;
	
	private String mobile;
	
	private String email;
	
	private String imgUrl;

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(int instituteId) {
		this.instituteId = instituteId;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getInstituteDescription() {
		return instituteDescription;
	}

	public void setInstituteDescription(String instituteDescription) {
		this.instituteDescription = instituteDescription;
	}

	public String getInstituteAddress() {
		return instituteAddress;
	}

	public void setInstituteAddress(String instituteAddress) {
		this.instituteAddress = instituteAddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "InstituteModel [instituteId=" + instituteId + ", instituteName=" + instituteName
				+ ", instituteDescription=" + instituteDescription + ", instituteAddress=" + instituteAddress
				+ ", mobile=" + mobile + ", email=" + email + "]";
	}
	

}
