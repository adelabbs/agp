package persistence.edb.operator;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Operator {
	
	ResultSet result = null;
	
	boolean init() {
		try {
			return result.first();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	boolean next() {
		try {
			return result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	abstract void execQuery(String query);
	
}
