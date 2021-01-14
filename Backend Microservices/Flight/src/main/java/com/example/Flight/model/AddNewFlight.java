package com.example.Flight.model;

import java.sql.Date;

public class AddNewFlight {
	private String flightName;
	private String genre;
	private Date releaseDate;
	private Integer rating;

	public String getFlightName() {
        return flightName;
    }
 
    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }
 
    public String getGenre() {
        return genre;
    }
 
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Date getReleaseDate(){
	return releaseDate;
    }
    public void setReleaseDate(Date releaseDate){
	this.releaseDate = releaseDate;
    }
    public Integer getRating(){
	return rating;
    }
    public void setRating(Integer rating){
	this.rating = rating;
    }


}
