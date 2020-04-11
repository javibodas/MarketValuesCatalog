package com.jgonzalbo.bolsavalores.externalapi;

import org.json.simple.JSONArray;


public interface IFCSService {
	
	public JSONArray getAllIndex();
	public JSONArray getIndexByCountries(String countries);
	public JSONArray getValuesByCountries(String countries);
	public JSONArray getValuesByIndex(String id);
	public JSONArray getLatestDataByValues(String values);
	public JSONArray getFundamentalDataByValues(String values);
	public JSONArray geIndexByValues();
	

}
