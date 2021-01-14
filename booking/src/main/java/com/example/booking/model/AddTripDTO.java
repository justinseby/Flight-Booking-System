package com.example.booking.model;

import java.sql.Date;
import javax.persistence.Column;

import com.example.booking.entity.TripsEntity;

public class AddTripDTO {
	private Integer tripId;
	private String flightName;
	private String airlineName;
	private Integer unitPrice;
	private Integer availableSeats;
	private String tripTime;
	private Date tripDate;
	
	public Integer getTripId() {
        return tripId;
    }
    
	public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public String getFlightName() {
        return flightName;
    }
    
    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }
    
    public String getAirlineName() {
        return airlineName;
    }
    
	public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
 
    public Integer getUnitPrice(){
    	return unitPrice;
        }
 
    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice= unitPrice;
    }
    public Integer getAvailableSeats() {
        return availableSeats;
    }
    
	public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
	public String getTripTime() {
        return tripTime;
    }
    
	public void setTripTime(String tripTime) {
        this.tripTime = tripTime;
    }
	public Date getTripDate() {
        return tripDate;
    }
    
	public void setTripDate(Date tripDate) {
        this.tripDate = tripDate;
    }


	public static AddTripDTO valueOf(TripsEntity trips) {
		// TODO Auto-generated method stub
		AddTripDTO tripsDTO = new AddTripDTO();
		tripsDTO.setTripId(trips.getTripId());
		tripsDTO.setFlightName(trips.getFlightName());
		tripsDTO.setAirlineName(trips.getAirlineName());
		tripsDTO.setUnitPrice(trips.getUnitPrice());
		tripsDTO.setAvailableSeats(trips.getAvailableSeats());
		tripsDTO.setTripTime(trips.getTripTime());
		tripsDTO.setTripDate(trips.getTripDate());
		return tripsDTO;
	}
}
