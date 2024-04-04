package com.backend.backend.service;

import java.util.List;
import java.util.Optional;

import com.backend.backend.entity.Industry;

public interface IndustryService {
	
	public Industry createIndustry(Industry industry);
	public Industry getIndustryById(Long id);
	public Industry updateIndustry(Long id, Industry industry);
	public void deleteIndustry(Long id);
	public List<Industry> getAllIndustries();

}
