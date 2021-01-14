package com.example.booking.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trip",schema="public")
public class TripsEntity implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tripid")
	Integer tripId;
	@Column(name="unitprice", nullable = false)
	Integer unitPrice;
	@Column(name="availableseats", nullable = false)
	Integer availableSeats;
	@Column(name="triptime", nullable = false)
	String tripTime;
	@Column(name="tripdate", nullable = false)
	Date tripDate;
	@Column(name="flightname", nullable = false)
	String flightName;
	@Column(name="airlinename", nullable = false)
	String airlineName;
	
	public TripsEntity() {
		super();
	}
	
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
}
