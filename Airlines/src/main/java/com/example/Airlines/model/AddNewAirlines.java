package com.example.Airlines.model;

public class AddNewAirlines {

	private String airlinesName;
	private String address;
	private Integer seatingCapacity;
	private String city;
	
	public String getAirlinesName() {
        return airlinesName;
    }
 
    public void setAirlinesName(String airlinesName) {
        this.airlinesName = airlinesName;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
    
    public Integer getSeatingCapacity(){
	return seatingCapacity;
    }
    
    public void setSeatingCapacity(Integer seatingCapacity){
	this.seatingCapacity = seatingCapacity;
    }
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
    
    
}
