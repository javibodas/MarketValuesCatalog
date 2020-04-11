package com.jgonzalbo.bolsavalores.externalapi;

import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;

import com.jgonzalbo.bolsavalores.models.Value;

public interface IFCSService {
	
	public JSONArray getAllIndex();
	public JSONArray getIndexByCountries(String countries);
	public JSONArray getValuesByCountries(String countries);
	public JSONArray getValuesByIndex(String id);
	public JSONArray getLatestDataByValues(String values);
	public JSONArray getFundamentalDataByValues(String values);
	public JSONArray geIndexByValues();
	

}
