package com.example.booking.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airlines",schema="public")
public class AirlinesEntity implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "airlinesid")
	Integer airlinesId;
	@Column(name = "airlinesname", nullable = false)
	String airlinesName;
	@Column(nullable = false)
	String address;
	@Column(name = "seatingcapacity" , nullable = false)
	Integer seatingCapacity;
	@Column(nullable = false)
	String city;
	
	public AirlinesEntity() {
		super();
	}

	public Integer getAirlinesId() {
        return airlinesId;
    }
    
	public void setAirlinesId(Integer airlinesId) {
        this.airlinesId = airlinesId;
    }

    public String getAirlinesName() {
        return airlinesName;
    }
 
    public void setAirlinesName(String airlinesName) {
        this.airlinesName = airlinesName;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
    
    public Integer getSeatingCapacity(){
	return seatingCapacity;
    }
    
    public void setSeatingCapacity(Integer seatingCapacity){
	this.seatingCapacity = seatingCapacity;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
}

