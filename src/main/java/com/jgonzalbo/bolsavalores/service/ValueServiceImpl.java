package com.jgonzalbo.bolsavalores.service;

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
import com.jgonzalbo.bolsavalores.models.Stock;
import com.jgonzalbo.bolsavalores.models.Value;

@Service
public class ValueServiceImpl implements IValueService {

	@Autowired
	private IFCSService externalService;

	@Autowired
	private IStockService stockService;

	@Override
	public Object[] search(String values, String index, String countries) {
		String[] countriesList = countries.split(",");

		Object[] o = new Object[3];
		List<Value> listValues = new LinkedList<>();
		List<Stock> listIndex = new LinkedList<>();

		if(values != null && !values.trim().equals("")) {
			listValues = this.getDataValues(values);
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
			values += (String)((JSONObject)jo).get("short_name");
		}

		listValues = this.getDataValues(values);

		return listValues;
	}

	private List<Value> getDataValues(String values) {
		HashMap<String, Value> valuesHashMap = new HashMap<>();
		int numberOfValues = values.split(",").length;

		JSONArray latestDataValues = externalService.getLatestDataByValues(values);
		List<Object> fundamentalDataValues = externalService.getFundamentalDataByValues(values).subList(0, numberOfValues - 1);

		for(Object jo: latestDataValues) {
			Value v = new Value();

			v.setName((String)((JSONObject)jo).get("symbol"));
			v.setDay_performance((String)((JSONObject)jo).get("chg_percent"));
			v.setPrice((String)((JSONObject)jo).get("price"));
			v.setDay_change((String)((JSONObject)jo).get("dateTime"));

			valuesHashMap.put(v.getName(),v);
		}

		for(Object jo: fundamentalDataValues) {
			Value v = valuesHashMap.get((String)((JSONObject)jo).get("symbol"));

			v.setPe((String)((JSONObject)jo).get("pe_ratio"));
			v.setShares((String)((JSONObject)jo).get("avg_vol_3m"));
			v.setMarket_cap((String)((JSONObject)jo).get("market_cap"));
		}

		List<Value> valuesList = new ArrayList<>(valuesHashMap.values());
		return valuesList;
	}

}
