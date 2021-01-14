package com.example.booking.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.booking.entity.BookingEntity;
import com.example.booking.entity.TripsEntity;
import com.example.booking.model.AddTripDTO;
import com.example.booking.model.BookTicketDTO;
import com.example.booking.model.BookingDTO;
import com.example.booking.model.TripsDTO;
import com.example.booking.service.BookingService;
@RestController
@CrossOrigin
public class BookingAPI {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BookingService bookingService;

	/*@PatchMapping(value = "/booking")
	public BookTicketDTO getBookingDetails(@RequestBody BookTicketDTO bookTicket) {
		return bookingService.getBookingDetails(bookTicket);	
	}*/
	@PostMapping(value = "/book")
	public BookingEntity getBookingDetails(@RequestBody BookingDTO bookDTO) {
		return bookingService.book(bookDTO);	
	}
	//fetches all bookings of a user
	@RequestMapping(value = "/getbooking/{userName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookingEntity> allbookings(@PathVariable String userName, BookingDTO model) {
		    return bookingService.getAllBookings(userName, model);  
		    }
	
	//fetches all bookings of a flight for report
	@RequestMapping(value = "/report", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BookingEntity> flightbook(BookingDTO model) {
		    return bookingService.flightbooking(model);  
		    }
	
	// Fetches details of a specific trip
	@RequestMapping(value = "/trips/{tripId}/tripdetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TripsDTO> getFlightDetails(@PathVariable Integer tripId) {

		logger.info("Tripdetails request for user {}", tripId);

		return bookingService.getTripDetails(tripId);
	} 
	

	//fetches all trips of a flight
		@RequestMapping(value = "/gettrips/{flightName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<TripsEntity> allTrips(@PathVariable String flightName, AddTripDTO model) {
	        return bookingService.getAllTrips(flightName, model);  
	    }
		//fetches all trips
				@RequestMapping(value = "/getalltrips", method = RequestMethod.GET)
			    public List<TripsEntity> allAirliness(TripsDTO model) {
			        return bookingService.getAllTrips();  
			    }
				
	// adds new trip
	@PostMapping(value = "/addTrip")
	public TripsEntity addTrip(@RequestBody AddTripDTO trip) {
		return bookingService.addTrip(trip);
	}

	// updates trip
	@PutMapping(value = "/trip/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public TripsEntity updateTrip(@RequestBody AddTripDTO trips) {
		return bookingService.updateTrip(trips);
	}

	 // deletes trip
	@RequestMapping(value = "/trip/{tripId}", method = RequestMethod.DELETE)
	public String deleteTrip(@PathVariable Integer tripId) {
		String message;
		message = bookingService.deleteTrip(tripId);
		return message;
	}

	// cancels Booking
	@RequestMapping(value = "/booking/{bookingId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Integer bookingId) {
		String message;
		message = bookingService.delete(bookingId);
		return message;
	}

}
