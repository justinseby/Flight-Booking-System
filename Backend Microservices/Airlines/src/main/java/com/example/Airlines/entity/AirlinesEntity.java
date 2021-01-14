 package com.example.Airlines.entity;

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
	@Column(name = "seatingcapacity" , nullable = false)
	Integer seatingCapacity;
	
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
 
    
    public Integer getSeatingCapacity(){
	return seatingCapacity;
    }
    
    public void setSeatingCapacity(Integer seatingCapacity){
	this.seatingCapacity = seatingCapacity;
    }
    
}

