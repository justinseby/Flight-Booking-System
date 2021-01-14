package com.example.booking.model;

import com.example.booking.entity.BookingEntity;

public class BookingDTO {

	Integer seatsBooked;
	Integer tripId;
	String userName;

    public Integer getSeatsBooked() {
        return seatsBooked;
    }
    
    public void setSeatsBooked(Integer seatsBooked ) {
        this.seatsBooked = seatsBooked;
    }
 
    public Integer getTripId(){
    	return tripId;
        }
 
    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
	public static BookingDTO valueOf(BookingEntity booking) {
		// TODO Auto-generated method stub
		BookingDTO bookingDTO = new BookingDTO();
		bookingDTO.setTripId(booking.getTripId());
		bookingDTO.setSeatsBooked(booking.getSeatsBooked());
		//bookingDTO.setUserName(booking.getUserName());
		return bookingDTO;
	}
}
