package com.backend.backend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.Industry;
import com.backend.backend.repository.IndustryRepository;

@Service
public class IndustryServiceImpl implements IndustryService{
	
	// 1- inject Repository in the Service 
	@Autowired
	private IndustryRepository industryRepository;

	
	@Override
	public Industry createIndustry(Industry industry) {
		return industryRepository.save(industry);
	}

	
	@Override
	public Industry getIndustryById(Long id) {
		
		Optional<Industry> industry = industryRepository.findById(id);
		if(!industry.isPresent()) {
			System.out.println("industry with id " + id + " doesn't Exist ");
			return null;
		}
		System.out.println("industry with id " + id + " is : " + industry.toString());
		return industry.get();
	}

	
	@Override
	public Industry updateIndustry(Long id, Industry industry) {
		
		Industry industryFromDB = industryRepository.findById(id).get();
		
		// New Value :
		String industryName = industry.getName();
		String industryDescription = industry.getDescription();
		
		// Print The Checks
		System.out.println(Objects.nonNull(industryName));
		System.out.println("".equalsIgnoreCase(industryName));
		System.out.println(!"".equalsIgnoreCase(industryName));
		
		// Null and Blank checks of the new values 
		if(Objects.nonNull(industryName) && !"".equalsIgnoreCase(industryName)) {
			industryFromDB.setName(industryName);
		}
		if(Objects.nonNull(industryDescription) && !"".equalsIgnoreCase(industryDescription)) {
			industryFromDB.setDescription(industryDescription);
		}
		
		return industryRepository.save(industryFromDB);
	}

	
	@Override
	public void deleteIndustry(Long id) {
		industryRepository.deleteById(id);		
	}
	

	@Override
	public List<Industry> getAllIndustries() {
		return industryRepository.findAll();
	}

}
