package persistence.edb.operator;

import java.util.HashMap;

public class Result {
	private HashMap<String, Object> resultRow = new HashMap<String, Object>();
	
	public Result() {
		
	}
	
	public void addField(String key, Object value) {
		resultRow.put(key, value);
	}
	
	public Object getObject(String key) {
		return resultRow.get(key);
	}
	
	public HashMap<String,Object> getResultRow(){
		return resultRow;
	}
}
