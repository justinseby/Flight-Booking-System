package com.example.Airlines.model;

import com.example.Airlines.entity.AirlinesEntity;

public class AirlinesDTO {

	private String airlinesName;
	private Integer seatingCapacity;
	
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
    
    
	public static AirlinesDTO valueOf(AirlinesEntity airlines) {
		// TODO Auto-generated method stub
		AirlinesDTO airlinesDTO = new AirlinesDTO();
		airlinesDTO.setAirlinesName(airlines.getAirlinesName());
		return airlinesDTO;
	}

}

