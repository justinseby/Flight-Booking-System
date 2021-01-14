package com.example.Flight.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Flight.entity.FlightEntity;
import com.example.Flight.model.AddNewFlight;
import com.example.Flight.model.FlightDTO;
import com.example.Flight.service.FlightService;

@RestController
@CrossOrigin
public class FlightAPI {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	FlightService flightService;
	
	//fetches all flights
	@RequestMapping(value = "/getallflights", method = RequestMethod.GET)
    public List<FlightEntity> allFlights(FlightDTO model) {
        return flightService.getAllFlights();  
    }
	
	// Fetches details of a specific flight
	@RequestMapping(value = "/flight/{flightName}/flightdetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FlightDTO> getFlightDetails(@PathVariable String flightName) {

		logger.info("Flightdetails request for user {}", flightName);

		return flightService.getFlightDetails(flightName);
	}
	
	// adds new flight
		@PostMapping(value = "/addflight")
		public AddNewFlight addFlight(@RequestBody AddNewFlight addNewFlight) {
			return flightService.addFlight(addNewFlight);
			
		} 
		
	// updates a flight
				@PutMapping(value = "/flight/update",produces = MediaType.APPLICATION_JSON_VALUE)
				public AddNewFlight updateFlight(@RequestBody AddNewFlight addNewFlight) {
					return flightService.updateFlight(addNewFlight);
				} 
		
	// deletes flight
		@RequestMapping(value = "flight/{flightName}", method = RequestMethod.DELETE )
		public String delete(@PathVariable String flightName) {
			String message;
			flightService.delete(flightName);
			message = flightName+" has been deleted successfully";
			return message;
		} 

}
