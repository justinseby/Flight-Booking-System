package com.example.booking.model;
import java.sql.Date;
import com.example.booking.entity.TripsEntity;

public class TripsDTO {

	private Integer unitPrice;
	private Integer availableSeats;
	private String tripTime;
	private Date tripDate;

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
	public static TripsDTO valueOf(TripsEntity trips) {
		// TODO Auto-generated method stub
		TripsDTO tripsDTO = new TripsDTO();
		tripsDTO.setUnitPrice(trips.getUnitPrice());
		tripsDTO.setAvailableSeats(trips.getAvailableSeats());
		tripsDTO.setTripTime(trips.getTripTime());
		return tripsDTO;
	}
}


