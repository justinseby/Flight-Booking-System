package com.example.Airlines.service;

import java.util.List;

import com.example.Airlines.entity.AirlinesEntity;
import com.example.Airlines.model.AddNewAirlines;
import com.example.Airlines.model.AirlinesDTO;

public interface AirlinesService {
	 List<AirlinesDTO> getAirlinesDetails (String airlinesName);
	 AddNewAirlines addAirlines(AddNewAirlines addNewAirlines);
	 AddNewAirlines updateAirlines(AddNewAirlines airlines);
	 String delete(String airlinesName);
	 List<AirlinesEntity> getAllAirliness();
} 
