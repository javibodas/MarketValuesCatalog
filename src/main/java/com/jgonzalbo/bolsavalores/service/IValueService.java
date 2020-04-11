package com.jgonzalbo.bolsavalores.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jgonzalbo.bolsavalores.models.Value;

@Service
public interface IValueService {
	
	public Object[] search(String values, String index, String countries);

}
