package com.example.Airlines.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Airlines.dao.AirlinesDAO;
import com.example.Airlines.entity.AirlinesEntity;
import com.example.Airlines.model.AddNewAirlines;
import com.example.Airlines.model.AirlinesDTO;
@Service
public class AirlinesServiceImpl implements AirlinesService{
	@Autowired
	AirlinesDAO airlinesDAO;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public List<AirlinesDTO> getAirlinesDetails(String airlinesName) {
		// TODO Auto-generated method stub
		logger.info("Airlines details request for customer {}", airlinesName);
		AirlinesEntity airlinesEntity=airlinesDAO.findByAirlinesName(airlinesName);
		List<AirlinesDTO> airlinesDTO = new ArrayList<AirlinesDTO>();
		airlinesDTO.add(AirlinesDTO.valueOf(airlinesEntity));
		return airlinesDTO;
	}
	
	public List<AirlinesEntity> getAllAirliness() {
        return airlinesDAO.findAll();
    }
	public AddNewAirlines addAirlines(AddNewAirlines addNewAirlines) {
		String message = null;
		AirlinesEntity airlines1 = new AirlinesEntity();
			message = addNewAirlines.getAirlinesName() + "has been added successfully";
			airlines1.setAirlinesName(addNewAirlines.getAirlinesName());

			airlines1.setSeatingCapacity(addNewAirlines.getSeatingCapacity());
			airlinesDAO.save(airlines1);
		return addNewAirlines;
	}
	
	public AddNewAirlines updateAirlines(AddNewAirlines airlines) {
		AirlinesEntity airlines1 = new AirlinesEntity();
		airlines1 = airlinesDAO.findByAirlinesName(airlines.getAirlinesName());
		airlines1.setAirlinesName(airlines.getAirlinesName());
		airlines1.setSeatingCapacity(airlines.getSeatingCapacity());
		airlinesDAO.save(airlines1);
		return airlines;
	}
	

	@Override
	public String delete(String airlinesName) {
		String message = null;
		AirlinesEntity airlines1 = new AirlinesEntity();
		airlines1 = airlinesDAO.findByAirlinesName(airlinesName);
		if ( airlines1.getAirlinesName().equals(airlinesName)){
			message = airlines1.getAirlinesName() + " has been deleted successfully";
			airlinesDAO.delete(airlines1);
		}
		return message;
	}
}
