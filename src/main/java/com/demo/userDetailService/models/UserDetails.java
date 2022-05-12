package com.demo.userDetailService.models;

public class UserDetails {
	
    private int id;
    
   private String firstName;
	
	private String lastName;
	
	private Long mobileNumber;
	
	private String place;
	
    private int ratting;
	
	private String comment;
	
	
	
    public UserDetails() {
    	
    }
	
	public UserDetails(int id, String firstName, String lastName, Long mobileNumber,String place, int ratting, String comment) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.place = place;
		this.ratting = ratting;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getRatting() {
		return ratting;
	}

	public void setRatting(int ratting) {
		this.ratting = ratting;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
	

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	
	

}
