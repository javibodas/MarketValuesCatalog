package com.jgonzalbo.bolsavalores.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jgonzalbo.bolsavalores.models.Stock;
import com.jgonzalbo.bolsavalores.models.Value;

@Service
public interface IStockService {
	
	public List<Stock> getAllStocks();
	public List<Stock> geStocksByValues(List<Value> values);
	public List<Stock> getStockByCountries(String[] countries);

}
