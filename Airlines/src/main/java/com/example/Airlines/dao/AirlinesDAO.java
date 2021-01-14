package com.example.Airlines.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Airlines.entity.AirlinesEntity;

@Repository
public interface AirlinesDAO extends JpaRepository<AirlinesEntity, Integer> {

	AirlinesEntity findByAirlinesNameAndCity(String airlinesName, String city);
	AirlinesEntity findByAirlinesName(String airlinesName);

}
