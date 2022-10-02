package com.examly.model;

public class InstituteDAO {


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
		return "InstituteDAO [instituteName=" + instituteName + ", instituteDescription=" + instituteDescription
				+ ", instituteAddress=" + instituteAddress + ", mobile=" + mobile + ", email=" + email + "]";
	}
	
	
}
