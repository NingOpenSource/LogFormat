package org.yanning.lib.LogFormat;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonStreamParser;

class JsonFormat {

	public static String format(Object object) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(object);
	}
	public static String formatJson(String json) {
		JsonStreamParser jsonStreamParser=new JsonStreamParser(json);
		if(jsonStreamParser.hasNext()){
			return new GsonBuilder().setPrettyPrinting().create().toJson(jsonStreamParser.next());
		}else{
			return json;
		}
	}
}
