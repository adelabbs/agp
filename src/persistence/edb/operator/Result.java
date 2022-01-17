package persistence.edb.operator;

import java.util.HashMap;

public class Result {
	private HashMap<String, Object> resultRow = new HashMap<String, Object>();
	
	public Result() {
		
	}
	
	void addField(String key, Object value) {
		resultRow.put(key, value);
	}
	
	Object getObject(String key) {
		return resultRow.get(key);
	}
}
