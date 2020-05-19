package com.jgonzalbo.bolsavalores.service.jpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgonzalbo.bolsavalores.externalapi.IFCSService;
import com.jgonzalbo.bolsavalores.models.Index;
import com.jgonzalbo.bolsavalores.models.Value;
import com.jgonzalbo.bolsavalores.service.IIndexService;
import com.jgonzalbo.bolsavalores.service.IValueService;

@Service
public class ValueServiceImpl implements IValueService {

	@Autowired
	private IFCSService externalService;

	@Autowired
	private IIndexService stockService;

	@Override
	public Object[] search(String values, String index, String countries) {
		String[] countriesList = countries.split(",");

		Object[] o = new Object[3];
		List<Value> listValues = new LinkedList<>();
		List<Index> listIndex = new LinkedList<>();

		if(values != null && !values.trim().equals("")) {
			listValues = this.getValuesBySymbol(values);
			listIndex = stockService.geStocksByValues(listValues);
		}else if(index != null && !index.trim().equals("")) {
			listValues = this.getValuesByIndex(index);
		}else if(countriesList.length > 1 && countriesList[0].equals("")) {

		}

		o[0] = listValues;
		o[1] = listIndex;

		return o;
	}


	private List<Value> getValuesByIndex(String index) {
		List<Value> listValues = new LinkedList<>();
		String values = "";

		// Api stocks
		JSONArray latestDataValues = externalService.getValuesByIndex(index);
		for(Object jo: latestDataValues) {
			if(!values.equals("")) values += ",";
			//values += (String)((JSONObject)jo).get("short_name");
			values += (String)((JSONObject)jo).get("stock_id");
		}

		listValues = this.getValuesById(values);

		return listValues;
	}
	
	private List<Value> getValuesBySymbol(String values){

		JSONArray latestDataValues = externalService.getLatestDataBySymbolValues(values);
		List<Object> fundamentalDataValues = externalService.getFundamentalDataBySymbolValues(values);
		
		return getValuesFromData(latestDataValues, fundamentalDataValues);
		
	}
	
	private List<Value> getValuesById(String values){

		JSONArray latestDataValues = externalService.getLatestDataByIdValues(values);
		List<Object> fundamentalDataValues = externalService.getFundamentalDataByIdValues(values);
		
		return getValuesFromData(latestDataValues, fundamentalDataValues);
		
	}

	private List<Value> getValuesFromData(JSONArray latestDataValues, List<Object> fundamentalDataValues) {
		HashMap<String, Value> valuesHashMap = new HashMap<>();

		for(Object jo: latestDataValues) {
			Value v = new Value();
			
			v.setId((String)((JSONObject)jo).get("id"));
			v.setName((String)((JSONObject)jo).get("symbol"));
			v.setDay_performance((String)((JSONObject)jo).get("chg_percent"));
			v.setPrice((String)((JSONObject)jo).get("price"));
			v.setDay_change((String)((JSONObject)jo).get("dateTime"));
			v.setCountry(((String)((JSONObject)jo).get("country")).toUpperCase());

			valuesHashMap.put(v.getId(),v);
		}

		for(Object jo: fundamentalDataValues) {
			Value v = valuesHashMap.get((String)((JSONObject)jo).get("id"));

			v.setPe((String)((JSONObject)jo).get("pe_ratio"));
			v.setShares((String)((JSONObject)jo).get("avg_vol_3m"));
			v.setMarket_cap((String)((JSONObject)jo).get("market_cap"));
		}

		List<Value> valuesList = new ArrayList<>(valuesHashMap.values());
		return valuesList;
	}

}
