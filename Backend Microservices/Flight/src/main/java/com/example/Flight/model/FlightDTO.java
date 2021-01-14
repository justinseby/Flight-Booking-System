package com.example.Flight.model;

import java.sql.Date;

import com.example.Flight.entity.FlightEntity;

public class FlightDTO {
	private String flightName;
	private String Dateof_Departure;
	public String getDateof_Departure() {
		return Dateof_Departure;
	}

	public void setDateof_Departure(String dateof_Departure) {
		Dateof_Departure = dateof_Departure;
	}

	private String Dateof_Arrival;
	private String FromCity;
	private String ToCity;

	public String getFlightName() {
        return flightName;
    }
 
    public void setFlightName(String flightName) {
        this.flightName = flightName;
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

	public static FlightDTO valueOf(FlightEntity flight) {
		// TODO Auto-generated method stub
		FlightDTO flightDTO = new FlightDTO();
		flightDTO.setFlightName(flight.getFlightName());
		flightDTO.setDateof_Departure(flight.getDateof_Departure());
		flightDTO.setDateof_Arrival(flight.getDateof_Arrival());
		return flightDTO;
	}

}
