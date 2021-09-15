## Flight-Booking-System
Online flight booking software that helps the users to book and view flights with ease.

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Code Examples](#codeexamples)
* [Contact](#contact)
* 
## General info
This project is a flight ticket booking system in which users can book or cancel tickets. They can view fligt and airline details and choose from the collection and also they are able to update their account information. The admin will be able to add, delete and update various components of the services.

## Technologies
* Technology: Java 1.8 
* IDE: STS 11 
* Database: PostgreSQL 
* Discovery Server: Eureka 
* Framework: Spring Boot Application 
* Documentation: swagger.io 
* API gateway: Zuul server 
* Registry: Eureka Server 


## Setup
* For details on installation of STS IDE, Click on https://www.javatpoint.com/spring-boot-download-and-install-sts-ide 
* To download PostgreSQL Server, Click on https://www.postgresql.org/download/
* To download Postman for testing, Click on https://www.postman.com/downloads/

## Code Examples

To update flight
public AddNewFlight updateFlight(AddNewFlight addNewFlight) {
		FlightEntity flight1 = new FlightEntity();
		flight1 = flightDAO.findByFlightName(addNewFlight.getFlightName());
		flight1.setFlightName(addNewFlight.getFlightName());
		flightDAO.save(flight1);
		return addNewFlight;
	} 
	The service implementation for delete flight
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
  
  ## Features
List of features ready aare as follows:
* User can register with the application and can login with password.
* User can view/update their account details and can delete their account.
* Users can view and select various flights and airlines and book their tickets with desired number of seats. They can also cancel their booking.
* Admin can add/delete/update new flights, trips and airlines.

 
## Inspiration
Project based on assignment request on Spring Microservices.

## Contact
created by [@justinseby] - feel free to contact me
