package com.jgonzalbo.bolsavalores.service.jpa;

import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgonzalbo.bolsavalores.externalapi.IFCSService;
import com.jgonzalbo.bolsavalores.models.Index;
import com.jgonzalbo.bolsavalores.models.Value;
import com.jgonzalbo.bolsavalores.service.IIndexService;

@Service
public class IndexServiceImpl implements IIndexService {
	
	@Autowired
	private IFCSService externalService;
	
	@Override
	public List<Index> getAllStocks() {
		List<Index> stocksList = new LinkedList<>();
		JSONArray listStokcs = null;
      
        // Api stocks
        try {
        	
			listStokcs = externalService.getAllIndex();
			for(Object jo: listStokcs) {
				stocksList.add(new Index(Integer.parseInt((String)((JSONObject)jo).get("category_id")),
							(String)((JSONObject)jo).get("category_name"),
							(String)((JSONObject)jo).get("country")));
			}
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
        
        // Default Stock
        stocksList.add(new Index(-1, "Choose stock", null));
        
        return stocksList;
	}

	@Override
	public List<Index> geStocksByValues(List<Value> values) {
		List<Index> stocks = new LinkedList<>();
    	// TO-DO
    	return stocks;
	}

	@Override
	public List<Index> getStockByCountries(String[] countries) {
		List<Index> stocks = new LinkedList<>();    	
    	
    	String cs = "";
    	for(String country : countries) {
	    		if (cs.trim().length() == 0) {
	    			cs = country.toLowerCase();
	    		}else{
	    			cs.concat("," + country.toLowerCase());
	    		}
    		}
        
        try {
        	JSONArray listStokcs = null;
        	
			if(!cs.equals("choose your country")) {
				listStokcs = externalService.getIndexByCountries(cs);
			}else{
				return this.getAllStocks();
			}
			

			for(Object jo: listStokcs) {
				stocks.add(new Index(Integer.parseInt((String)((JSONObject)jo).get("category_id")),
							(String)((JSONObject)jo).get("category_name"),
							(String)((JSONObject)jo).get("country")));
			}
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
        
        return stocks;
	}

}
