package br.com.divoi.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONUtil {
	
	public static String objectToJSON(Object object){
		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		return gson.toJson(object);
	}

}
