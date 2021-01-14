package com.example.booking.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight", schema="public")
public class FlightEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "flightid")
	Integer flightId;
	@Column(name="flightname", nullable = false)
	String flightName;
	@Column(name="Dateof_Departure", nullable = false)
	String Dateof_Departure;
	@Column(name="Dateof_Arrival", nullable = false)
	String Dateof_Arrival;
	@Column(name="FromCity", nullable = false)
	String FromCity;
	@Column(name="ToCity", nullable = false)
	String ToCity;
	
	
	public String getDateof_Departure() {
		return Dateof_Departure;
	}

	public void setDateof_Departure(String dateof_Departure) {
		Dateof_Departure = dateof_Departure;
	}

	public String getDateof_Arrival() {
		return Dateof_Arrival;
	}

	public void setDateof_Arrival(String dateof_Arrival) {
		Dateof_Arrival = dateof_Arrival;
	}

	public String getFromCity() {
		return FromCity;
	}

	public void setFromCity(String fromCity) {
		FromCity = fromCity;
	}

	public String getToCity() {
		return ToCity;
	}

	public void setToCity(String toCity) {
		ToCity = toCity;
	}

	public FlightEntity() {
		super();
	}
	
	public Integer getFlightId() {
        return flightId;
    }
    
	public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }
 
    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }
 
}
