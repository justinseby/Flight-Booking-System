package com.example.booking.service;


import java.util.List;

import com.example.booking.entity.BookingEntity;
import com.example.booking.entity.TripsEntity;
import com.example.booking.model.AddTripDTO;
import com.example.booking.model.BookingDTO;
import com.example.booking.model.TripsDTO;
public interface BookingService {

	//BookTicketDTO getBookingDetails(BookTicketDTO bookTicket);
	List<TripsDTO> getTripDetails(Integer tripId);
	TripsEntity addTrip(AddTripDTO trip);
	TripsEntity updateTrip(AddTripDTO trips);
	String deleteTrip(Integer tripId);
	String delete(Integer bookingId);
	BookingEntity book(BookingDTO bookDTO);
	List<TripsEntity> getAllTrips(String flightName, AddTripDTO model);
	List<BookingEntity> getAllBookings(String userName, BookingDTO model);
	List<TripsEntity> getAllTrips();
	List<BookingEntity> flightbooking( BookingDTO model);
}
