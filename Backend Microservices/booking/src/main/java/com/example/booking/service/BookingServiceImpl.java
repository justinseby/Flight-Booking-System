package com.example.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booking.dao.BookingDAO;
import com.example.booking.dao.FlightDAO;
import com.example.booking.dao.TripsDAO;
import com.example.booking.dao.AirlinesDAO;
import com.example.booking.dao.UserDAO;
import com.example.booking.entity.BookingEntity;
import com.example.booking.entity.FlightEntity;
import com.example.booking.entity.AirlinesEntity;
import com.example.booking.entity.TripsEntity;
import com.example.booking.model.AddTripDTO;
import com.example.booking.model.BookTicketDTO;
import com.example.booking.model.BookingDTO;
import com.example.booking.model.TripsDTO;
import com.example.booking.entity.UserEntity;
@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingDAO bookingDAO;
	
	@Autowired
	TripsDAO tripsDAO;
	
	@Autowired
	AirlinesDAO airlinesDAO;
	
	@Autowired
	FlightDAO flightDAO;
	
	@Autowired
	UserDAO userDAO;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	

	/* @Override
	public BookTicketDTO getBookingDetails(BookTicketDTO bookTicket) {
		// TODO Auto-generated method stub

		logger.info("Bookingdetails request for customer {}", bookTicket.getFlightName());
		String message = null;
		String airlinesName = bookTicket.getAirlinesName();
		String username = bookTicket.getUserName();
		String city = bookTicket.getCity();
		String flightName=bookTicket.getFlightName();
		AirlinesEntity airlinesEntity = airlinesDAO.findByAirlinesNameAndCity(airlinesName,city);
	
		UserEntity userEntity = userDAO.findByUserName(userName);
		FlightEntity flightEntity= flightDAO.findByFlightName(flightName);
		String airlinesName1=airlinesEntity.getAirlinesName();
		String flightName1= flightEntity.getFlightName();
		String userName1= userEntity.getUserName();
		
		TripsEntity tripsEntity= tripsDAO.findByFlightNameAndAirlinesName(flightName1,airlinesName1);
		float totalCost = 0;
		Integer availableSeats = 0;
		if (flightName1!=null && airlinesName1!=null)
		{
		BookingEntity bookingEntity = new BookingEntity();
		bookingEntity.setUserName(userName1);
		bookingEntity.setTripId(tripsEntity.getTripId());
		bookingEntity.setSeatsBooked(bookTicket.getSeatsforBooking());
		totalCost = ( bookTicket.getSeatsforBooking() * tripsEntity.getUnitPrice() );
		bookingEntity.setTotalCost(totalCost);
		availableSeats = ( tripsEntity.getAvailableSeats() - bookTicket.getSeatsforBooking() );
		tripsEntity.setAvailableSeats(availableSeats);
		tripsDAO.save(tripsEntity);
		bookingDAO.save(bookingEntity);
			message ="Booking Successful'";
		}
		return bookTicket;
	}  */
	
	@Override
	public BookingEntity book(BookingDTO bookDTO) {
		Integer tripId = bookDTO.getTripId();
		Integer seatsBooked = bookDTO.getSeatsBooked();
		String userName = bookDTO.getUserName();
		TripsEntity tripsEntity = tripsDAO.findByTripId(tripId);
		UserEntity userEntity = userDAO.findByUserName(userName);
		BookingEntity bookingEntity = new BookingEntity();
		float totalCost = 0;
		Integer availableSeats = 0;
		if (tripId!=null && seatsBooked!=null)
		{
			bookingEntity.setUserName(bookDTO.getUserName());
			bookingEntity.setTripId(tripsEntity.getTripId());
			bookingEntity.setSeatsBooked(bookDTO.getSeatsBooked());
			totalCost = ( bookDTO.getSeatsBooked() * tripsEntity.getUnitPrice() );
			bookingEntity.setTotalCost(totalCost);
			availableSeats = ( tripsEntity.getAvailableSeats() - bookDTO.getSeatsBooked() );
			tripsEntity.setAvailableSeats(availableSeats);
			tripsDAO.save(tripsEntity);
			bookingDAO.save(bookingEntity);
			}
			return bookingEntity;
		}
	
	
	@Override
	public List<TripsDTO> getTripDetails(Integer tripId) {
		// TODO Auto-generated method stub

		logger.info("Tripdetails request for customer {}", tripId);

		TripsEntity tripsEntities=tripsDAO.findByTripId(tripId);
		List<TripsDTO> tripsDTO = new ArrayList<TripsDTO>();
		tripsDTO.add(TripsDTO.valueOf(tripsEntities));
		
		return tripsDTO;
	}


	public TripsEntity addTrip(AddTripDTO tripsDTO) {
		TripsEntity trip1 = new TripsEntity();
		trip1.setFlightName(tripsDTO.getFlightName());
		trip1.setAirlineName(tripsDTO.getAirlineName());
			trip1.setTripDate(tripsDTO.getTripDate());
			trip1.setTripTime(tripsDTO.getTripTime());
			trip1.setAvailableSeats(tripsDTO.getAvailableSeats());
			trip1.setUnitPrice(tripsDTO.getUnitPrice());
			tripsDAO.save(trip1);
		return trip1;
	}


	public TripsEntity updateTrip(AddTripDTO trips) {
		TripsEntity trip1 = new TripsEntity();
		trip1 = tripsDAO.findByTripId(trips.getTripId());
		trip1.setFlightName(trips.getFlightName());
		trip1.setAirlineName(trips.getAirlineName());
		trip1.setTripDate(trips.getTripDate());
		trip1.setTripTime(trips.getTripTime());
		trip1.setAvailableSeats(trips.getAvailableSeats());
		trip1.setUnitPrice(trips.getUnitPrice());
		tripsDAO.save(trip1);
		return trip1;
	}


	@Override
	public List<TripsEntity> getAllTrips(String flightName ,AddTripDTO model) {
		return tripsDAO.findAllByFlightName(flightName);
    }

	public String deleteTrip(Integer tripId) {
		String message = null;
		TripsEntity trip1 = new TripsEntity();
		trip1 = tripsDAO.findByTripId(tripId);
		if ( trip1.getTripId().equals(tripId)){
			message = "Trip has been deleted successfully";
			tripsDAO.delete(trip1);
		}
		return message;
	}
	
	@Override
	public List<BookingEntity> getAllBookings(String userName ,BookingDTO model) {
		return bookingDAO.findAllByUserName(userName);
    }
	
	public List<BookingEntity> flightbooking(BookingDTO model) {
		return bookingDAO.findAll();
  }
	
	public List<TripsEntity> getAllTrips() {
        return tripsDAO.findAll();
    }

	public String delete(Integer bookingId) {
		String message = null;
		Integer availableSeats = 0;
		BookingEntity booking1 = new BookingEntity();
		TripsEntity trip1 = new TripsEntity();
		booking1 = bookingDAO.findByBookingId(bookingId);
		trip1 = tripsDAO.findByTripId(booking1.getTripId());
		if ( booking1.getBookingId().equals(bookingId)){
			availableSeats = ( trip1.getAvailableSeats() + booking1.getSeatsBooked() );
			trip1.setAvailableSeats(availableSeats);
			message = "Booking has been cancelled successfully";
			bookingDAO.delete(booking1);
		}
		return message;
	}		
}