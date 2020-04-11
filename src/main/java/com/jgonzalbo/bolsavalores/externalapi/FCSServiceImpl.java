package com.jgonzalbo.bolsavalores.externalapi;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FCSServiceImpl implements IFCSService {
	
	private static final Logger logger = LogManager.getLogger(FCSServiceImpl.class);
	
	private final RestTemplate restTemplate;
	private String uri = "https://fcsapi.com/api-v2";
	private String key = "1Jykl7CoegqKkg72RZXh5Z4YPvLyyn2IdKfrIASTNuxJ5WV088";
	
	public FCSServiceImpl() {
		 this.restTemplate = new RestTemplate();
	}
	
	private JSONArray callAPI(String uri) {
		JSONArray jsonArray = null;
		JSONParser parser = new JSONParser();
		
		try {
			 
			 JSONObject  jsonStocks = (JSONObject)parser.parse(this.restTemplate.getForObject(uri, String.class));
			 jsonArray = (JSONArray)jsonStocks.get("response");
		 
		 } catch (org.json.simple.parser.ParseException e) {
			 logger.log(Level.ERROR, "Parse exception error in getIndexByCountries, uri = " + uri + ".\n" + e.getMessage());	
			 jsonArray = new JSONArray();
		 }
		
		logger.log(Level.INFO, "Call API " + uri);
		
		return jsonArray;
	}
	
	/**
	 * GET INDEX
	 */
	public JSONArray getAllIndex() {
		String countries = "brazil,canada,china,denmark,dubai, finland,france,germany, hong-kong,india,indonesia,ireland,japan,malaysia,mexico,netherlands,pakistan,philippines,russia,saudi-arabia,singapore,south-africa,south-korea,spain,sweden,switzerland,thailand,turkey,united-kingdom,united-states";
		JSONArray listIndex = getIndexByCountries(countries);
		return listIndex;
	}
	
	@Override
	public JSONArray getIndexByCountries(String countries) {
		
		 return callAPI(uri
	    			.concat("/stock/category?country=")
	    			.concat(countries)
	    			.concat("&access_key=")
	    			.concat(key));
	}
	
	@Override
	public JSONArray geIndexByValues() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * GET VALUES
	 */

	@Override
	public JSONArray getValuesByIndex(String id) {
		 return callAPI(uri
	    			.concat("/stock/list?indices_id=")
	    			.concat(String.valueOf(id))
	    			.concat("&access_key=")
	    			.concat(key));
	}

	@Override
	public JSONArray getValuesByCountries(String countries) {
		 return callAPI(uri
	    			.concat("/stock/list?indices_id=")
	    			.concat(countries)
	    			.concat("&access_key=")
	    			.concat(key));
	}
	
	/**
	 * GET DATA VALUES
	 */
	
	@Override
	public JSONArray getLatestDataByValues(String values) {
		return 	callAPI(uri
       			.concat("/stock/latest?symbol=")
    			.concat(values)
    			.concat("&access_key=")
    			.concat(key));
	}
	
	@Override
	public JSONArray getFundamentalDataByValues(String values) {
		return callAPI(uri
	       			.concat("/stock/fundamental?symbol=")
	        			.concat(values)
	        			.concat("&access_key=")
	        			.concat(key));
	}

}
