package com.jgonzalbo.bolsavalores.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jgonzalbo.bolsavalores.models.Index;
import com.jgonzalbo.bolsavalores.models.Value;

@Service
public interface IIndexService {
	
	public List<Index> getAllStocks();
	public List<Index> geStocksByValues(List<Value> values);
	public List<Index> getStockByCountries(String[] countries);

}
