package com.example.Airlines.api;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Airlines.entity.AirlinesEntity;
import com.example.Airlines.model.AddNewAirlines;
import com.example.Airlines.model.AirlinesDTO;
import com.example.Airlines.service.AirlinesService;

@RestController
@CrossOrigin
public class AirlinesAPI {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	AirlinesService airlinesService;
	
	//fetches all airliness
		@RequestMapping(value = "/getallairliness", method = RequestMethod.GET)
	    public List<AirlinesEntity> allAirliness(AirlinesDTO model) {
	        return airlinesService.getAllAirliness();  
	    }
		
	// Fetches details of a specific airlines
	@RequestMapping(value = "/airlines/{airlinesName}/airlinesdetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AirlinesDTO> getAirlinesDetails(@PathVariable String airlinesName) {

		logger.info("Airlinesdetails request for user {}", airlinesName);
		return airlinesService.getAirlinesDetails(airlinesName);
	} 
	
	// adds new airlines
	@PostMapping(value = "/addAirlines")
	public AddNewAirlines addAirlines(@RequestBody AddNewAirlines addNewAirlines) {	
		return airlinesService.addAirlines(addNewAirlines);
		
	} 
	
	// updates a airlines
		@PutMapping(value = "/airlines/update" ,produces = MediaType.APPLICATION_JSON_VALUE)
		public AddNewAirlines updateAirlines(@RequestBody AddNewAirlines airlines) {
			return airlinesService.updateAirlines(airlines);
		} 
		
	// deletes airlines
		@RequestMapping(value = "/airlines/{airlinesName}", method = RequestMethod.DELETE )
		public String delete(@PathVariable String airlinesName) {
		String message;
		message = airlinesService.delete(airlinesName);
		return message;
	} 
}
