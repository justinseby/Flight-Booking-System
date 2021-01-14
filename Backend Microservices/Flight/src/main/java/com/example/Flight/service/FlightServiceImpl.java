package com.example.Flight.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Flight.dao.FlightDAO;
import com.example.Flight.entity.FlightEntity;
import com.example.Flight.model.AddNewFlight;
import com.example.Flight.model.FlightDTO;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	FlightDAO flightDAO;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public List<FlightDTO> getFlightDetails(String flightName) {
		// TODO Auto-generated method stub
		logger.info("Flightdetails request for customer {}", flightName);
		FlightEntity flightEntities=flightDAO.findByFlightName(flightName);
		List<FlightDTO> flightDTO = new ArrayList<FlightDTO>();
		flightDTO.add(FlightDTO.valueOf(flightEntities));
		return flightDTO;
	}
	
	public List<FlightEntity> getAllFlights() {
        return flightDAO.findAll();
    }
	public AddNewFlight addFlight(AddNewFlight addNewFlight) {
		String message = null;
		FlightEntity flight1 = new FlightEntity();
			message = addNewFlight.getFlightName() + " has been added successfully";
			flight1.setFlightName(addNewFlight.getFlightName());
			flightDAO.save(flight1);
		return addNewFlight;
	}
	

	public AddNewFlight updateFlight(AddNewFlight addNewFlight) {
		FlightEntity flight1 = new FlightEntity();
		flight1 = flightDAO.findByFlightName(addNewFlight.getFlightName());
		flight1.setFlightName(addNewFlight.getFlightName());
		flightDAO.save(flight1);
		return addNewFlight;
	} 
	
	public String delete(String flightName) {
		String message = null;
		FlightEntity flight1 = new FlightEntity();
		flight1 = flightDAO.findByFlightName(flightName);
		if ( flight1.getFlightName().equals(flightName)){
			message = flight1.getFlightName() + " has been deleted successfully";
			flightDAO.delete(flight1);
		}
		return message;
	}
}
