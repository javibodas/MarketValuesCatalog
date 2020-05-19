package com.jgonzalbo.bolsavalores.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgonzalbo.bolsavalores.models.Country;
import com.jgonzalbo.bolsavalores.repository.CountryRepository;
import com.jgonzalbo.bolsavalores.service.ICountryService;


@Service
public class CountryServiceImpl implements ICountryService {
	
	@Autowired
	private CountryRepository countryRepository; 

	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

}
