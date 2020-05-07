package com.jgonzalbo.bolsavalores.externalapi;

import org.json.simple.JSONArray;


public interface IFCSService {
	
	public JSONArray getAllIndex();
	public JSONArray getIndexByCountries(String countries);
	public JSONArray getValuesByCountries(String countries);
	public JSONArray getValuesByIndex(String id);
	public JSONArray getLatestDataBySymbolValues(String values);
	public JSONArray getFundamentalDataBySymbolValues(String values);
	public JSONArray getLatestDataByIdValues(String values);
	public JSONArray getFundamentalDataByIdValues(String values);
	public JSONArray geIndexByValues();
	

}
